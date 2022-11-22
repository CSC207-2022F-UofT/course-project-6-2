package Entities.OrderHistory;

import Screens.OrderHistoryGrouping;
import Screens.ScrollPane;
import UseCases.ExtractUserFromPhoneNum;
import Screens.Button;
import Screens.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderHistoryScreen extends JFrame implements ActionListener {

    static JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    TextField orderNumber = new TextField();
    Button searchButton = new Button();
    JButton reOrderButton = new JButton();
    JLabel orderLabels = new JLabel();
    ScrollPane scrollPane = new ScrollPane();
    OrderHistoryGrouping orderGroup = new OrderHistoryGrouping();
    //orderLabel orders = new orderLabel();
    ExtractUserFromPhoneNum getCustomer = new ExtractUserFromPhoneNum();

    public OrderHistoryScreen() {

        //creating frame
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Order History");
        panel.setSize(frame.getSize());
        scrollPane.createScrollPane(frame, panel);

        // adding the components onto the panel
        orderNumber.createTextField(panel,25, 25, 300, 30);
        searchButton.createButton(panel,"Search", 375,25,75,30);

        orderLabels.setText("1");
        orderLabels.setSize(100, 50);

        orderGroup.grouping(panel, orderLabels, reOrderButton);

        //orders.createOrderLabel(panel, order);

        frame.setVisible(true);
    }
    /**
     * Invoked when action occurs
     *
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}