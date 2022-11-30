package screens.customerscreens;

import entities.Drink;
import entities.Order;
import entities.users.Customer;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
    JButton reOrderButton = new JButton("Re-Order");
    Customer currCustomer = UserRuntimeDataBase.getCurrentCustomer();
    ArrayList<Order> orderList = currCustomer.getOrderHistory();
    private final HashMap<Drink, Integer> drinks = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList();


    public OrderHistoryPanel() {

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Order History");
        frame.setResizable(false);
        frame.add(panel);

        // setting up JTable
        headers.add("Past Drinks Ordered");
        headers.add("Quantity");
        headers.add("Total Price");

        if (orderList.size() > 0){
            for (int i = 0; i < orderList.size(); i++){
                for (Drink drink : orderList.get(i).getOrderList().keySet()) {
                    Vector row = new Vector<>();
                    row.add(drink.getName());
                    row.add(UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList().values());
                    row.add(UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getTotalPrize());
                    data.add(row);
                }
            }
        } else{
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
                    // currCustomer.getOrderHistory()put((Drink)table.getValueAt(row, 0), 1);
                    new CustomerMainScreen();
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

