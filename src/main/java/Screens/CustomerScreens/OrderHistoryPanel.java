package Screens.CustomerScreens;

import Entities.Users.Customer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author sanciagao
 */
public class OrderHistoryPanel extends JFrame {

    // Variables declaration
    JFrame frame = new JFrame();
    JTable table;
    JPanel panel = new JPanel();
    Vector headers = new Vector();
    Vector data = new Vector();
    // HashMap<String, Integer> orders;
    // Order order = new Order(orders, "hi");
    // ArrayList<Order> aLOrders;
    Customer currCustomer = new Customer("i", "i", "i",9,"i",
            new ArrayList<>());
    // Customer currCustomer = UserRuntimeDataBase.getCurrentCustomer();
    JButton reOrderButton = new JButton("Re-Order");

    public OrderHistoryPanel() {
        /*
        orders.put("Drink 1", 1);
        orders.put("Drink 2", 1);
        aLOrders.add(order);
         */

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Order History");
        frame.setResizable(false);

        // setting up JTable
        headers.add("Past Drinks Ordered");
        headers.add("Total Price");

        Vector row = new Vector<>();
        if (currCustomer.getOrderHistory().size() > 0){
            for (int i = 0; i < currCustomer.getOrderHistory().size(); i++) {
                row.add(currCustomer.getOrderHistory().get(i));
                data.add(row);
            }
        } else{
            JOptionPane.showMessageDialog(null,
                    "Sorry, you have not ordered anything in the past so you don't have an order history");
            panel.setLayout(null);
        }

        table = new JTable(data, headers);

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

        // adding components on panel
        reOrderButton.setBounds(80, 450, 120, 40);
        panel.add(reOrderButton);

        reOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                reOrderButtonActionPerformed(evt);
            }

            private void reOrderButtonActionPerformed(ActionEvent e){

                int row = table.getSelectedRow();
                if (e.getSource() == reOrderButton){
                    // currCustomer.shoppingCart.itemList.put((Drink)table.getValueAt(row, 0), 1);
                    JOptionPane.showMessageDialog(null,
                            "Drink has been re-added to your shopping cart");
                }
            }
        });
    }
    public JPanel getPanel() {
        return panel;
    }
}

