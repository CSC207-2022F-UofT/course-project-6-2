package OrderHistory;

import javax.swing.*;


public class OrderHistoryView{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Order History");
        frame.add(panel);
        panel.setLayout(null);

        JTextField orderNumber = new JTextField();
        orderNumber.setBounds(25, 25, 225, 30);
        frame.add(orderNumber);

        JButton search = new JButton("Search");
        search.setBounds(275,25,75,30);
        frame.add(search);

        JButton nextPage = new JButton("Next Page");
        nextPage.setBounds(500,500,125,30);
        frame.add(nextPage);

        JLabel order1 = new JLabel("Order 1");
        order1.setBounds(45, 75, 80,20);
        frame.add(order1);

        frame.setLayout(null);
        frame.setVisible(true);
    }

}