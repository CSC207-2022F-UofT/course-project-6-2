package screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPasswordScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    public ResetPasswordScreen() {
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Phone number and password info
        LabelTextPanel usernamePanel = new LabelTextPanel(new JLabel("Phone Number: "), new JTextField(15));
        usernamePanel.setBounds(244, 150, 300, 40);
        panel.add(usernamePanel);

        LabelTextPanel passwordPanel =  new LabelTextPanel(new JLabel("New Password: "), new JTextField(15));
        passwordPanel.setBounds(230, 200, 330, 40);
        panel.add(passwordPanel);

        LabelTextPanel confirmpassPanel =  new LabelTextPanel(new JLabel("Confirm Password: "), new JTextField(15));
        confirmpassPanel.setBounds(218, 250, 330, 40);
        panel.add(confirmpassPanel);

        // Buttons
        loginButton.setBounds(250, 400, 150, 40);
        panel.add(loginButton);
        loginButton.addActionListener(this);

        registerButton.setBounds(400, 400, 150, 40);
        panel.add(registerButton);
        registerButton.addActionListener(this);

        JButton resetButton = new JButton("Reset Password");
        resetButton.setBounds(325, 450, 150, 40);
        panel.add(resetButton);

        frame.setVisible(true);
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            new LoginScreen();
        }
        if(e.getSource() == registerButton){
            new CustomerRegisterScreen();
        }
        frame.setVisible(false);
    }
}
