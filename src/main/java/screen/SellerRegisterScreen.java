package screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SellerRegisterScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset Password");

    JRadioButton registerAsSeller = new JRadioButton("Seller");
    JRadioButton registerAsCustomer = new JRadioButton("Customer");
    public SellerRegisterScreen(){
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
        registerAsSeller.setSelected(true);
        registerAsCustomer.setBounds(400, 50, 100, 25);
        registerAsCustomer.addActionListener(this);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(registerAsSeller);
        buttonGroup.add(registerAsCustomer);
        panel.add(registerAsSeller);
        panel.add(registerAsCustomer);

        // Info textboxes
        LabelTextPanel accountNamePanel = new LabelTextPanel(new JLabel("Account Name: "), new JTextField(15));
        accountNamePanel.setBounds(225, 90, 300, 40);
        panel.add(accountNamePanel);

        LabelTextPanel phoneNumPanel = new LabelTextPanel(new JLabel("Phone Number: "), new JTextField(15));
        phoneNumPanel.setBounds(210, 140, 330, 40);
        panel.add(phoneNumPanel);

        LabelTextPanel passwordPanel =  new LabelTextPanel(new JLabel("Password: "), new JTextField(15));
        passwordPanel.setBounds(250, 190, 280, 40);
        panel.add(passwordPanel);

        LabelTextPanel confirmpassPanel =  new LabelTextPanel(new JLabel("Confirm Password: "), new JTextField(15));
        confirmpassPanel.setBounds(198, 240, 330, 40);
        panel.add(confirmpassPanel);

        LabelTextPanel addressPanel =  new LabelTextPanel(new JLabel("Address: "), new JTextField(15));
        addressPanel.setBounds(252, 290, 280, 40);
        panel.add(addressPanel);

        LabelTextPanel birthDatePanel =  new LabelTextPanel(new JLabel("Store Name: "), new JTextField(15));
        birthDatePanel.setBounds(240, 340, 280, 40);
        panel.add(birthDatePanel);


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
        if(e.getSource() == loginButton){
            new LoginScreen();
        }

        if(e.getSource() == registerAsCustomer){
            new CustomerRegisterScreen();
        }
        if(e.getSource() == resetButton) {
            new ResetPasswordScreen();
        }
        frame.setVisible(false);
    }
}
