package screens.loginregisterscreens;

import controllers.RegisterController;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextVerticalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// Frameworks/Drivers layer

public class SellerRegisterPanel extends JFrame implements ActionListener {
    // Swing components declaration
    private final JPanel panel = new JPanel();
    private final Button registerButton = new Button();
    private final JTextField accountNameField = new JTextField(15);
    private final JTextField phoneNumField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JPasswordField confirmPassField = new JPasswordField(15);
    private final JTextField addressField = new JTextField(15);
    private final JTextField storeNameField = new JTextField(15);
    public SellerRegisterPanel(){
        panel.setLayout(null);

        // Create info labels and text-fields
        LabelTextVerticalPanel accountNamePanel = new LabelTextVerticalPanel();
        accountNamePanel.createLabelTextPanel(panel, new JLabel("Account Name : "), accountNameField,
                250, 30, 300, 30);

        LabelTextVerticalPanel phoneNumPanel = new LabelTextVerticalPanel();
        phoneNumPanel.createLabelTextPanel(panel, new JLabel("Phone Number : "), phoneNumField,
                250, 90, 300, 30);

        LabelTextVerticalPanel passwordPanel = new LabelTextVerticalPanel();
        passwordPanel.createLabelTextPanel(panel, new JLabel("Password : "), passwordField,
                250, 150, 300, 30);

        LabelTextVerticalPanel confirmpassPanel = new LabelTextVerticalPanel();
        confirmpassPanel.createLabelTextPanel(panel, new JLabel("Confirm Password: "), confirmPassField,
                250, 210, 300, 30);

        LabelTextVerticalPanel addressPanel = new LabelTextVerticalPanel();
        addressPanel.createLabelTextPanel(panel, new JLabel("Address: "), addressField,
                250, 270, 300, 30);

        LabelTextVerticalPanel storePanel = new LabelTextVerticalPanel();
        storePanel.createLabelTextPanel(panel, new JLabel("Store Name: "), storeNameField,
                250, 330, 300, 30);

        // Create register button and add action listener
        registerButton.createButton(panel, "Register", 315, 420, 150, 40);
        registerButton.addActionListener(this);
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
        String accountName = accountNameField.getText();
        String phoneNum = phoneNumField.getText();
        String password = String.valueOf(passwordField.getPassword());
        String confirmPass = String.valueOf(confirmPassField.getPassword());
        String address = addressField.getText();
        String storeName = storeNameField.getText();

        if(e.getSource() == registerButton.button){
            String registerResult = new RegisterController(accountName, phoneNum, password, confirmPass,
                    address, "-1", storeName).registerUser();
            // Clear the text-boxes when the user successfully registered
            if (Objects.equals(registerResult, "Successfully registered")) {
                accountNameField.setText("");
                phoneNumField.setText("");
                passwordField.setText("");
                confirmPassField.setText("");
                addressField.setText("");
                storeNameField.setText("");
            }
        }
    }
}
