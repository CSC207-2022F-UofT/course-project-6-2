package Entities.OrderHistory;

import Screens.ButtonEditor;
import Screens.ButtonRenderer;
import UseCases.ExtractUserFromPhoneNum;
import UseCases.OrderUseCases.OrderTable;

import javax.swing.*;
import java.io.IOException;

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
    public OrderHistoryScreen() throws IOException, ClassNotFoundException {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        searchOrderHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOrderHistoryActionPerformed(evt);
            }
        });

        // Creating the table
        orderTable.createOrderTable(table, extractedUser);

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

    private void SearchOrderHistoryActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
}

