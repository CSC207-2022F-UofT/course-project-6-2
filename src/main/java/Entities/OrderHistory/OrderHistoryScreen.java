package Entities.OrderHistory;

import Controller.LoginController;
import Entities.Order;
import Entities.Users.Customer;
import Screens.ButtonEditor;
import Screens.ButtonRenderer;
import UseCases.ExtractUserFromPhoneNum;
import UseCases.OrderUseCases.OrderActionPerformed;
import UseCases.OrderUseCases.OrderTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author sanciagao
 */
public class OrderHistoryScreen extends JFrame {

    // Variables declaration
    JButton searchButton = new JButton("Search");
    JTextField searchOrderHistory = new JTextField();
    JScrollPane scrollPane = new JScrollPane();
    JTable table = new JTable();
    ExtractUserFromPhoneNum extractedUser = new ExtractUserFromPhoneNum();
    OrderTable orderTable = new OrderTable();
    OrderActionPerformed actionPerformed = new OrderActionPerformed();
    LoginController loginController = new LoginController("904839274");
    public OrderHistoryScreen() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        searchOrderHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        // Creating the table
        // orderTable.createOrderTable(table, extractedUser, loginController);
        ArrayList<Order> orders = new ArrayList<>();

        Customer customer = new Customer("Yuan", "6485930948", "HI", 19,
                "123 happy Street", orders);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                                {String.valueOf(i), customer.getOrderHistory().get(i).getTotalOrder(),
                                        customer.getOrderHistory().get(i).getOrderStatus(), "Re-Order"}
                        }, new String[]{
                        "Order", "Order Price", "Order Status", "Re-Order"
                }) {
                    // making the columns uneditable
                    final boolean[] canEdit = new boolean[]{
                            false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        }
        // Setting the settings for the table
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        // adding buttons for the column with "Re-Order" as the column name
        table.getColumn("Re-Order").setCellRenderer(new ButtonRenderer());
        table.getColumn("Re-Order").setCellEditor(
                new ButtonEditor(new JCheckBox()));

        // Setting Columns to be not resizable
        for (int i = 0; i > table.getColumnCount(); i++){
            if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(i).setResizable(false);
            }
        }

        // Creating layout of OrderHistory Screen
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(457, Short.MAX_VALUE))
                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchOrderHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
}

