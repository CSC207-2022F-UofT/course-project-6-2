package screens.customerscreens;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Main Page");
        frame.setResizable(false);
        frame.add(new OrderHistoryPanel().getPanel());
        panel.setLayout(null);

        frame.setVisible(true);
    }
}
