package OrderHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderHistoryView implements ActionListener {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JTextField orderNumber = new JTextField();
    static JButton search = new JButton("Search");
    static JButton nextPage = new JButton("Next Page");

    public static void main(String[] args) {
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Order History");
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
        panel.setLayout(null);

        orderNumber.setBounds(25, 25, 225, 30);
        frame.add(orderNumber);

        search.setBounds(275,25,75,30);
        frame.add(search);

        nextPage.setBounds(500,500,125,30);
        frame.add(nextPage);

        JLabel order1 = new JLabel("Order 1");
        order1.setBounds(45, 75, 80,20);
        frame.add(order1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if(s.equals("Next Page")) {
            frame.getContentPane().setBackground(Color.pink);
            frame.setVisible(true);
        }
    }
}
