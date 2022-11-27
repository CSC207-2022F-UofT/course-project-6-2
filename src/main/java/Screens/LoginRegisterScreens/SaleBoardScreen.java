package Screens.LoginRegisterScreens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaleBoardScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    ScrollPane scrollPane = new ScrollPane();
    public SaleBoardScreen() {
        // Basic setups
        JPanel panel = new JPanel();
        scrollPane.createScrollPane(frame, panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Sale Board");
        frame.setResizable(false);


        frame.setVisible(true);

    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
