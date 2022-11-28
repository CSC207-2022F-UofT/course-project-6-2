package Screens.CustomerScreens;

import UseCases.GetSumOfDrinks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author sanciagao
 */
public class ShoppingCartPanel extends JFrame {

    // Variables declaration
    private final JPanel panel = new JPanel();
    JButton checkoutButton = new JButton("Checkout");
    JButton addQuantity = new JButton("+");
    JButton minusQuantity = new JButton("-");
    JScrollPane innerScrollPane = new JScrollPane();
    Screens.ShoppingCartPanel shoppingCartPanel = new Screens.ShoppingCartPanel();
    JTable table = new JTable();
    JLabel totalAmountLabel = new JLabel();
    JLabel totalLabel = new JLabel("Total: ");
    ArrayList<Double> totalAmount = new ArrayList<>();
    Double total = 0.0;
    DecimalFormat df = new DecimalFormat("0.00");
    Double discountedVal = 0.0;
    Double newVal = 0.0;
    Double quantity = 1.0;
    GetSumOfDrinks getSum = new GetSumOfDrinks();

    public ShoppingCartPanel() {
        panel.setLayout(null);

        // scrollPane settings
        innerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Creating the Table
        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"Drink 1", 1.0, 0.5, 1.0, 0.0, 0.0},
                        {"Drink 2", 19.0, 0.1, 1.0, 0.0, 0.0},
                        {"Drink 3", 8.5, 1.0, 1.0, 0.0, 0.0},
                        {"Drink 4", 3.0, 0.9, 1.0, 0.0, 0.0}
                },
                new String [] {
                        "Drink Name", "Drink Price", "Discount", "Quantity", "Discounted Value", "Drink Total"
                }
        ) {
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        innerScrollPane.setViewportView(table);
        innerScrollPane.setBounds(50,0,700, 400);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        // Getting sum of the drink prices
        total = getSum.getSumOfDrinks(table, discountedVal, newVal, totalAmount, total);

        // showing the sum
        totalAmountLabel.setText(df.format(total));

        // Setting Columns to be not resizable
        for (int i = 0; i < table.getColumnCount(); i++){
            if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(i).setResizable(false);
            }
        }

        // Action Listeners
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        addQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addQuantityActionPerformed(evt);
            }
        });

        minusQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                minusQuantityActionPerformed(evt);
            }
        });


        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);

        shoppingCartPanel.createShoppingCartPanel(panelLayout, innerScrollPane, addQuantity, checkoutButton, minusQuantity,
                totalLabel, totalAmountLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel)
        );

        pack();
    }

    private void checkoutButtonActionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutButton){
            table.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                            {0, 0, 0, 0, 0, 0},
                    },
                    new String [] {
                            "Drink Name", "Drink Price", "Discount", "Quantity", "Discounted Value", "Drink Total"
                    }
            ) {
                final boolean[] canEdit = new boolean [] {
                        false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            totalAmountLabel.setText("0");
            JOptionPane.showMessageDialog(null,
                    "You have checked out! You can go to your order history to check your items :)");
        }
    }

    private void addQuantityActionPerformed(ActionEvent e) {

        int column = 3;
        int row = table.getSelectedRow();

        if (e.getSource() == addQuantity) {
            quantity = (Double) table.getValueAt(row, column);
            table.setValueAt(quantity += 1.0, row, 3);
        }

        totalAmount.add((Double) table.getValueAt(row, 4));

        for (int i = 0; i < totalAmount.size(); i++) {
            newVal = quantity * (Double) table.getValueAt(row, 4);
            table.setValueAt(df.format(newVal), row, 5);
        }
        total += totalAmount.get(row);

        // showing the sum
        totalAmountLabel.setText(df.format(total));
    }

    private void minusQuantityActionPerformed(ActionEvent e) {

        int column = 3;
        int row = table.getSelectedRow();

        if (e.getSource() == minusQuantity) {
            quantity = (Double) table.getValueAt(row, column);
            if (quantity > 0) {
                table.setValueAt(quantity -= 1.0, row, 3);
                total -= totalAmount.get(row);
            } else{
                JOptionPane.showMessageDialog(null,
                        "Sorry, You can not delete anymore drinks");
            }
        }

        totalAmount.add(Double.parseDouble(table.getValueAt(row, 4).toString()));

        for (int i = 0; i < totalAmount.size(); i++) {
            newVal = quantity * (Double) table.getValueAt(row, 4);
            table.setValueAt(df.format(newVal), row, 5);
        }

        // showing the sum
        totalAmountLabel.setText(df.format(total));
    }

    public JPanel getPanel() {
        return panel;
    }
}
