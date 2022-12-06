package screens.customerscreens;

import entities.Order;
import entities.users.Customer;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author sanciagao
 */
public class OrderHistoryPanel extends JFrame {

    // setting up variables
    JPanel panel = new JPanel();
    Customer currCustomer = ShoppingCartPanel.currCustomer;

    public OrderHistoryPanel() {

        // setting up local variables
        Vector<String> headers = new Vector();
        Vector data = new Vector();
        ArrayList<Order> orders = currCustomer.getOrderHistory();
        DecimalFormat df = new DecimalFormat("0.00");

        panel.setLayout(null);

        // setting up JTable components
        headers.add("Order Number");
        headers.add("Total Price");
        headers.add("Order Status");

        // add components to table
        if (orders.size() > 0){
            for (Order order : currCustomer.getOrderHistory()) {
                Vector row = new Vector<>();
                row.add(order.getOrderNum());
                row.add("$" + df.format(order.getTotalPrice()));
                row.add(order.getOrderStatus());
                data.add(row);
            }
        }

        // Initializing and constructing table
        JTable table = new JTable(data, headers);

        // Setting Columns to be not resizable
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Creating table and scrollpane
        table.setFillsViewportHeight(true);

        //Adding the two panels to the contentPane.
        JScrollPane scrollPane;
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 0, 700, 400);
        panel.add(scrollPane);
    }

    public JPanel getPanel() {
        return panel;
    }
}

