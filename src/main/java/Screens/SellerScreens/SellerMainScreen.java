package Screens.SellerScreens;

import Screens.Button;
import Screens.CustomerScreens.CustomerMainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SellerMainScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Screens.Button modifyDrinkButton = new Screens.Button();
    Screens.Button addDrinkButton = new Screens.Button();
    Screens.Button onSaleButton = new Screens.Button();
    Screens.Button orderHistoryButton = new Button();
    Vector headers = new Vector();
    Vector data = new Vector();

    public SellerMainScreen() {
        // Basic setups for the JTable.
        headers.add("drink name");
        headers.add("price");
        headers.add("description");
        headers.add("ingredient");
        headers.add("volume");
        headers.add("production Date");
        headers.add("expiration Date");
        headers.add("discount");

        Vector line1 = new Vector();
        line1.add("1");
        line1.add("1");
        line1.add("1");
        line1.add("1");
        line1.add("1");
        line1.add("1");
        line1.add("1");
        line1.add("1");
        data.add(line1);

        System.out.println(line1);

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Seller main page");
        frame.setResizable(false);

        //Setting up the two panels.
        JPanel panel = new JPanel();
        JTable orderTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        Container contentPane = frame.getContentPane();

        //Adding the two Buttons.
        modifyDrinkButton.createButton(panel, "Modify Drink", 100, 400, 150, 40);
        modifyDrinkButton.addActionListener(this);
        addDrinkButton.createButton(panel, "Add Drink", 250, 400, 150, 40);
        addDrinkButton.addActionListener(this);
        onSaleButton.createButton(panel, "On sale", 400, 400, 150, 40);
        onSaleButton.addActionListener(this);
        orderHistoryButton.createButton(panel, "Order History", 550, 400, 150, 40);
        orderHistoryButton.addActionListener(this);

        //Adding the two panels to the contentPane.
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         if(e.getSource() == modifyDrinkButton){
         new SellerModifyItemFrame();
         frame.setVisible(false);
         }
         if(e.getSource() == orderHistoryButton){
         new OrderStatusScreen();
         frame.setVisible(false);
         }*/

    }

    public static void main(String[] args) {
        new SellerMainScreen();
    }
}