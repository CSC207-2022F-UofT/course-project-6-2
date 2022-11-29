package screens.loginregisterscreens;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextPanel;
import screens.customerscreens.CustomerMainScreen;
import screens.sellerscreens.SellerMainScreen;
import usecases.userresponsemodel.LoginResponseModel;
import usecases.loginregisterusecases.LoginUser;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class LoginScreen extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    final Button loginButton = new Button();
    final Button registerButton = new Button();
    final Button resetButton = new Button();
    final JTextField phoneNumField = new JTextField(15); //The phone number entered
    final JPasswordField passwordField = new JPasswordField(15); //The password entered

    public LoginScreen() {
        // Basic setups
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Delivery Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Username and password info
        LabelTextPanel phoneNumPanel = new LabelTextPanel(new JLabel("Phone Number: "), phoneNumField);
        phoneNumPanel.setBounds(244, 170, 300, 40);
        panel.add(phoneNumPanel);

        LabelTextPanel passwordPanel =  new LabelTextPanel(new JLabel("Password: "), passwordField);
        passwordPanel.setBounds(270, 220, 280, 40);
        panel.add(passwordPanel);

        // Buttons
        loginButton.createButton(panel, "Login", 250, 300, 150, 40);
        loginButton.addActionListener(this);

        registerButton.createButton(panel, "Register", 400, 300, 150, 40);
        registerButton.addActionListener(this);

        resetButton.createButton(panel, "Reset Password", 325, 350, 150, 40);
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
        String phoneNum = phoneNumField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if(e.getSource() == loginButton.button){
            String loginResult = LoginUser.login(phoneNum, password);
            new LoginResponseModel(loginResult);
            if (loginResult.equals("Seller")) {
                new SellerMainScreen();
                new UserRuntimeDataBase().constructCurrentSeller(phoneNum);
            } else if (loginResult.equals("Customer")) {
                new CustomerMainScreen();
                new UserRuntimeDataBase().constructCurrentCustomer(phoneNum);
            }
        }
        if(e.getSource() == registerButton.button){
            new CustomerRegisterScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == resetButton.button) {
            new ResetPasswordScreen();
            frame.setVisible(false);
        }
    }
    public static void main(String[] args) {new LoginScreen();}
}
