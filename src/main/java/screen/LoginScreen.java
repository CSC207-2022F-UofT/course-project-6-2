package screen;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    JButton resetButton = new JButton("Reset Password");

    public LoginScreen() {
        // Basic setups
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Username and password info
        LabelTextPanel usernamePanel = new LabelTextPanel(new JLabel("Phone Number: "), new JTextField(15));
        usernamePanel.setBounds(244, 270, 300, 40);
        panel.add(usernamePanel);

        LabelTextPanel passwordPanel =  new LabelTextPanel(new JLabel("Password: "), new JTextField(15));
        passwordPanel.setBounds(270, 320, 280, 40);
        panel.add(passwordPanel);

        // Buttons
        loginButton.setBounds(250, 400, 150, 40);
        panel.add(loginButton);
        loginButton.addActionListener(this);

        registerButton.setBounds(400, 400, 150, 40);
        panel.add(registerButton);
        registerButton.addActionListener(this);

        resetButton.setBounds(325, 450, 150, 40);
        panel.add(resetButton);
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
        if(e.getSource() == registerButton){
            new CustomerRegisterScreen();
        }
        if(e.getSource() == resetButton) {
            new ResetPasswordScreen();
        }
        frame.setVisible(false);
    }
}
