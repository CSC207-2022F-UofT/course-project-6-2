package screens.loginregisterscreens;

import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextVerticalPanel;
import usecases.loginregisterusecases.RegisterUser;
import usecases.userinputboundary.RegisterInputBoundary;
import usecases.userresponsemodel.RegisterResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class CustomerRegisterPanel extends JFrame implements ActionListener {
    // Swing components declaration
    private final JPanel panel = new JPanel();
    private final Button registerButton = new Button();
    private final JTextField accountNameField = new JTextField(15);
    private final JTextField phoneNumField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JPasswordField confirmPassField = new JPasswordField(15);
    private final JTextField addressField = new JTextField(15);
    private final JTextField ageField = new JTextField(15);
    public CustomerRegisterPanel(){
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

        LabelTextVerticalPanel agePanel = new LabelTextVerticalPanel();
        agePanel.createLabelTextPanel(panel, new JLabel("Age: "), ageField,
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
        int age = new RegisterInputBoundary().getAge(ageField.getText());

        if(e.getSource() == registerButton.button){
            String registerResult = RegisterUser.registerUser(accountName, phoneNum, password, confirmPass, address, age, null);
            new RegisterResponseModel(registerResult);
            accountNameField.setText("");
            phoneNumField.setText("");
            passwordField.setText("");
            confirmPassField.setText("");
            addressField.setText("");
            ageField.setText("");
        }
    }
}