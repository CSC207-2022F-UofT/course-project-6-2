package screens.loginregisterscreens;

import controllers.LoginController;
import screens.customerscreens.CustomerMainScreen;
import screens.sellerscreens.SellerMainScreen;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextVerticalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class LoginScreenPanel extends JFrame implements ActionListener {
    // Swing components declaration
    private final JFrame frame;
    private final JPanel panel = new JPanel();
    private final Button loginButton = new Button();
    private final JTextField phoneNumField = new JTextField(); //The phone number entered
    private final JPasswordField passwordField = new JPasswordField(); //The password entered
    public LoginScreenPanel(JFrame frame) {
        this.frame = frame;
        panel.setLayout(null);

        // Create phone number and password labels and text-fields
        LabelTextVerticalPanel phoneNumPanel = new LabelTextVerticalPanel();
        phoneNumPanel.createLabelTextPanel(panel, new JLabel("Phone Number :"), phoneNumField,
                250, 130, 300, 30);

        LabelTextVerticalPanel passwordPanel = new LabelTextVerticalPanel();
        passwordPanel.createLabelTextPanel(panel, new JLabel("Password :"), passwordField,
                250, 190, 300, 30);

        // Create login button and add action listener
        loginButton.createButton(panel, "Login", 315, 280, 150, 40);
        loginButton.addActionListener(this);
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String phoneNum = phoneNumField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if(e.getSource() == loginButton.button){
            String result = new LoginController(phoneNum, password).loginUser();
            if(result.equals("Seller")) {
                new SellerMainScreen();
                frame.setVisible(false);
            } else if (result.equals("Customer")) {
                new CustomerMainScreen();
                frame.setVisible(false);
            }
            phoneNumField.setText("");
            passwordField.setText("");
        }
    }
}
