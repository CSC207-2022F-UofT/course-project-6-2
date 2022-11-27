package Screens.SellerScreens;

//import UseCases.ExtractUserFromPhoneNum;
import Screens.Button;
import Screens.SellerScreens.SellerMainScreen;
import Entities.Users.Seller;
import UseCases.UserUseCases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

public class OrderStatusScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    public Screens.Button modifyButton = new Button();
    public Screens.Button backButton = new Button();
    Vector headers = new Vector();
    Vector data = new Vector();

    public OrderStatusScreen() {
        // Basic setups for the Jtable.
        headers.add("order number");
        headers.add("order status");

         //Get the phone number from login and extract the corresponding seller object.
        Seller seller = UserRuntimeDataBase.getCurrentSeller();
        for (int i = 0; i < seller.allOrders.size(); i++){
            Vector line = new Vector();
            line.add(seller.allOrders.get(i).orderNum);
            line.add(seller.allOrders.get(i).orderStatus);
            data.add(line);
         }

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("order history");
        frame.setResizable(false);

        //Setting up the two panels.
        JPanel panel = new JPanel();
        JTable orderTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        Container contentPane = frame.getContentPane();

        //Adding the two Buttons.
        modifyButton.createButton(panel, "Modify status", 250, 400, 150, 40);
        modifyButton.addActionListener(this);
        backButton.createButton(panel, "Previous Page", 400, 400, 150, 40);
        backButton.addActionListener(this);

        //Adding the two panels to the contentPane.
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == modifyButton.getButton()){
            new ModifyStatusScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == backButton.getButton()){
            new SellerMainScreen();
            frame.setVisible(false);
        }
    }
}
