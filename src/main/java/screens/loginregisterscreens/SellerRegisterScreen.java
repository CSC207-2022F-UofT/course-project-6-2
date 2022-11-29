package screens.loginregisterscreens;

import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextPanel;
import usecases.userresponsemodel.RegisterResponseModel;
import usecases.loginregisterusecases.RegisterUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class SellerRegisterScreen extends JFrame implements ActionListener {
    // Frame
    private final JFrame frame = new JFrame();

    // Buttons
    private final Button loginButton = new Button();
    private final Button registerButton = new Button();
    private final Button resetButton = new Button();

    // TextFields
    private final JTextField accountNameField = new JTextField(15);
    private final JTextField phoneNumField = new JTextField(15);
    private final JPasswordField passwordField = new JPasswordField(15);
    private final JPasswordField confirmPassField = new JPasswordField(15);
    private final JTextField addressField = new JTextField(15);
    private final JTextField storeNameField = new JTextField(15);

    // RadioButton
    private final JRadioButton registerAsCustomer = new JRadioButton("Customer");
    public SellerRegisterScreen(){
        // Basic setups
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Delivery Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Choose register as customer or seller
        JRadioButton registerAsSeller = new JRadioButton("Seller");
        registerAsSeller.setBounds(300, 50, 80, 25);
        registerAsSeller.setSelected(true);
        registerAsCustomer.setBounds(400, 50, 100, 25);
        registerAsCustomer.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(registerAsSeller);
        buttonGroup.add(registerAsCustomer);
        panel.add(registerAsSeller);
        panel.add(registerAsCustomer);

        // Info text-boxes
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

        LabelTextPanel storeNameDatePanel =  new LabelTextPanel(new JLabel("Store Name: "), storeNameField);
        storeNameDatePanel.setBounds(240, 340, 280, 40);
        panel.add(storeNameDatePanel);

        // Set button sizes and add action listener
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
        String storeName = storeNameField.getText();

        if(e.getSource() == registerButton.button){
            String registerResult = RegisterUser.registerUser(accountName, phoneNum, password, confirmPass, address, -1, storeName);
            new RegisterResponseModel(registerResult);
            if (registerResult.equals("Successfully registered")) {
                new LoginScreen();
            }
        }
        if(e.getSource() == loginButton.button){
            new LoginScreen();
        }

        if(e.getSource() == registerAsCustomer){
            new CustomerRegisterScreen();
        }
        if(e.getSource() == resetButton.button){
            new ResetPasswordScreen();
        }
        frame.setVisible(false);
    }
}
