package screens.loginregisterscreens;

import controllers.ResetPasswordController;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextVerticalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

public class ResetPasswordPanel extends JFrame implements ActionListener {
    // Swing components declaration
    private final JPanel panel = new JPanel();
    private final Button resetButton = new Button();
    private final JTextField phoneNumField = new JTextField(15); //The phone number entered
    private final JPasswordField passwordField = new JPasswordField(15); //The new password entered
    private final JPasswordField confirmPassField = new JPasswordField(15); //The password entered second time

    public ResetPasswordPanel() {
        panel.setLayout(null);

        // Create info labels and text-fields
        LabelTextVerticalPanel phoneNumPanel = new LabelTextVerticalPanel();
        phoneNumPanel.createLabelTextPanel(panel, new JLabel("Phone Number :"), phoneNumField,
                250, 100, 300, 30);

        LabelTextVerticalPanel passwordPanel = new LabelTextVerticalPanel();
        passwordPanel.createLabelTextPanel(panel, new JLabel("Password :"), passwordField,
                250, 160, 300, 30);

        LabelTextVerticalPanel confirmPassPanel = new LabelTextVerticalPanel();
        confirmPassPanel.createLabelTextPanel(panel, new JLabel("Confirm Password :"), confirmPassField,
                250, 220, 300, 30);

        // Create reset button and add action listener
        resetButton.createButton(panel, "Reset Password", 315, 300, 150, 40);
        resetButton.addActionListener(this);
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
        String phoneNum = phoneNumField.getText();
        String newPass = String.valueOf(passwordField.getPassword());
        String confirmPass = String.valueOf(confirmPassField.getPassword());

        if(e.getSource() == resetButton.button){
            boolean resetResult = new ResetPasswordController(phoneNum, newPass, confirmPass).resetPassword();
            if (resetResult) {
                phoneNumField.setText("");
                passwordField.setText("");
                confirmPassField.setText("");
            }
        }
    }
}
