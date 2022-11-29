package screens.loginregisterscreens;

import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextPanel;
import usecases.userusercases.ResetUserPassword;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Frameworks/Drivers layer

public class ResetPasswordScreen extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    private final Button loginButton = new Button();
    private final Button registerButton = new Button();
    private final Button resetButton = new Button();
    private final JTextField phoneNumField = new JTextField(15); //The phone number entered
    private final JPasswordField passwordField = new JPasswordField(15); //The new password entered
    private final JPasswordField confirmPassField = new JPasswordField(15); //The password entered second time

    public ResetPasswordScreen() {
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Delivery Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Phone number and password info
        LabelTextPanel usernamePanel = new LabelTextPanel(new JLabel("Phone Number: "), phoneNumField);
        usernamePanel.setBounds(244, 150, 300, 40);
        panel.add(usernamePanel);

        LabelTextPanel passwordPanel =  new LabelTextPanel(new JLabel("New Password: "), passwordField);
        passwordPanel.setBounds(230, 200, 330, 40);
        panel.add(passwordPanel);

        LabelTextPanel confirmPassPanel =  new LabelTextPanel(new JLabel("Confirm Password: "), confirmPassField);
        confirmPassPanel.setBounds(218, 250, 330, 40);
        panel.add(confirmPassPanel);

        // Buttons
        loginButton.createButton(panel, "Login", 250, 350, 150, 40);
        loginButton.addActionListener(this);

        registerButton.createButton(panel, "Register", 400, 350, 150, 40);
        registerButton.addActionListener(this);

        resetButton.createButton(panel, "Reset Password", 325, 400, 150, 40);
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
        String newPass = String.valueOf(passwordField.getPassword());
        String confirmPass = String.valueOf(confirmPassField.getPassword());

        if(e.getSource() == resetButton.button){
            boolean resetResult;
            try {
                resetResult = ResetUserPassword.resetPassword(phoneNum, newPass, confirmPass);
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            if (resetResult) {
                JOptionPane.showMessageDialog(null, "You have reset your password!");
            } else {
                JOptionPane.showMessageDialog(null, "Phone number incorrect or password doesn't match!");
            }
        }
        if(e.getSource() == loginButton.button){
            new LoginScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == registerButton.button){
            new CustomerRegisterScreen();
            frame.setVisible(false);
        }
    }
}
