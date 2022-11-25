package Screens.CustomerScreens;

import Screens.LoginRegisterScreens.LoginScreen;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class SaleSectionPanel {
    JFrame frame = new JFrame();
    Vector headers = new Vector();
    Vector data = new Vector();

    public SaleSectionPanel() {
        // Basic setups
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        // Headers of the JTable
        headers.add("Drink name");
        headers.add("Original Price");
        headers.add("Discount");
        headers.add("Current Price");
        headers.add("Add to Shopping Cart");

        Vector line1 = new Vector();

        JTable orderTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        Container contentPane = frame.getContentPane();

        //Adding the two panels to the contentPane.
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new SaleSectionPanel();
    }
}
