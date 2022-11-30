package screens.customerscreens;

import entities.Drink;
import entities.Order;
import entities.users.Customer;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author sanciagao
 */
public class OrderHistoryPanel extends JFrame {

    // Variables declaration
    private final JTable table;
    JPanel panel = new JPanel();
    private final JButton reOrderButton = new JButton("Re-Order");
    Customer currCustomer = ShoppingCartPanel.currCustomer;

    public OrderHistoryPanel() {

        // setting up local variables
        Vector<String> headers = new Vector();
        Vector data = new Vector();
        HashMap<Drink, Integer> drinks = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList();
        Order orders = new Order(drinks, "Processing");
        panel.setLayout(null);

        // setting up JTable
        headers.add("Past Drinks Ordered");
        headers.add("Total Price");
        headers.add("Order Status");

        if (orders.getOrderList().size() > 0){
            for (int i = 0; i < orders.getOrderList().size(); i++){
                for (Order order : currCustomer.getOrderHistory()) {
                    Vector row = new Vector<>();
                    row.add("Order");
                    row.add(currCustomer.getShoppingCart().getTotalPrize());
                    row.add(order.getOrderStatus());
                    data.add(row);
                }
            }
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
        reOrderButton.setBounds(330, 440, 120, 40);
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

