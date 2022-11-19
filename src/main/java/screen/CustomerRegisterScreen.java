package screen;

import users.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerRegisterScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button loginButton = new Button();
    Button registerButton = new Button();
    Button resetButton = new Button();
    JRadioButton registerAsSeller = new JRadioButton("Seller");
    JRadioButton registerAsCustomer = new JRadioButton("Customer");
    JTextField accountNameField = new JTextField(15);
    JTextField phoneNumField = new JTextField(15);
    JPasswordField passwordField = new JPasswordField(15);
    JPasswordField confirmPassField = new JPasswordField(15);
    JTextField addressField = new JTextField(15);
    JTextField ageField = new JTextField(15);

    public CustomerRegisterScreen(){
        // Basic setups
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Choose register as customer or seller
        registerAsSeller.setBounds(300, 50, 80, 25);
        registerAsSeller.addActionListener(this);
        registerAsCustomer.setBounds(400, 50, 100, 25);
        registerAsCustomer.setSelected(true);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(registerAsSeller);
        buttonGroup.add(registerAsCustomer);
        panel.add(registerAsSeller);
        panel.add(registerAsCustomer);

        // Info textboxes
        LabelTextPanel accountNamePanel = new LabelTextPanel(new JLabel("Account Name: "), accountNameField);
        accountNamePanel.setBounds(225, 90, 300, 40);
        panel.add(accountNamePanel);

        LabelTextPanel phoneNumPanel = new LabelTextPanel(new JLabel("Phone Number: "), phoneNumField);
        phoneNumPanel.setBounds(210, 140, 330, 40);
        panel.add(phoneNumPanel);

        LabelTextPanel passwordPanel =  new LabelTextPanel(new JLabel("Password: "), passwordField);
        passwordPanel.setBounds(250, 190, 280, 40);
        panel.add(passwordPanel);

        LabelTextPanel confirmpassPanel =  new LabelTextPanel(new JLabel("Confirm Password: "), confirmPassField);
        confirmpassPanel.setBounds(198, 240, 330, 40);
        panel.add(confirmpassPanel);

        LabelTextPanel addressPanel =  new LabelTextPanel(new JLabel("Address: "), addressField);
        addressPanel.setBounds(252, 290, 280, 40);
        panel.add(addressPanel);

        LabelTextPanel agePanel =  new LabelTextPanel(new JLabel("Age: "), ageField);
        agePanel.setBounds(265, 340, 280, 40);
        panel.add(agePanel);

        // Buttons
        loginButton.createButton(panel, "Login", 250, 400, 150, 40);
        loginButton.addActionListener(this);

        registerButton.createButton(panel, "Register", 400, 400, 150, 40);
        registerButton.addActionListener(this);

        resetButton.createButton(panel, "Reset Password", 325, 450, 150, 40);
        resetButton.addActionListener(this);

        frame.setVisible(true);
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
        int age = Integer.parseInt(ageField.getText());

        if(e.getSource() == resetButton.button){
            boolean registerResult = UserController.registerUser(accountName, phoneNum, password, confirmPass, address, age, none);
            if (registerResult) {
                JOptionPane.showMessageDialog(null, "You have successfully registered, please log in!");
                new LoginScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Phone number exists or password doesn't match!");
            }
        }
        if(e.getSource() == loginButton.button){
            new LoginScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == registerAsSeller){
            new SellerRegisterScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == resetButton.button) {
            new ResetPasswordScreen();
            frame.setVisible(false);
        }
    }
}
