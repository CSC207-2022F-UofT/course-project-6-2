package screen;

import users.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPasswordScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button loginButton = new Button();
    Button registerButton = new Button();
    Button resetButton = new Button();

    JTextField phoneNumField = new JTextField(15);; //The phone number entered
    JPasswordField passwordField = new JPasswordField(15); //The new password entered
    JPasswordField comfirmPassField = new JPasswordField(15); //The password entered second time

    public ResetPasswordScreen() {
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Application");
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

        LabelTextPanel confirmpassPanel =  new LabelTextPanel(new JLabel("Confirm Password: "), comfirmPassField);
        confirmpassPanel.setBounds(218, 250, 330, 40);
        panel.add(confirmpassPanel);

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
        String phoneNum = phoneNumField.getText();
        String newPass = String.valueOf(passwordField.getPassword());
        String confirmPass = String.valueOf(comfirmPassField.getPassword());

        if(e.getSource() == resetButton.button){
            boolean resetResult = UserController.resetPassword(phoneNum, newPass, confirmPass);
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
