package Entities.ShoppingCartInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author sanciagao
 */
public class ShoppingCartScreen extends JFrame {

    // Variables declaration
    JButton checkoutButton = new JButton("Checkout");
    JButton addQuantity = new JButton("+");
    JButton minusQuantity = new JButton("-");
    JScrollPane innerScrollPane = new JScrollPane();
    JTable table = new JTable();
    JPanel panel = new JPanel();
    JLabel totalAmountLabel = new JLabel();
    JLabel totalLabel = new JLabel("Total: ");
    ArrayList<Double> totalAmount = new ArrayList<>();
    Double total = 0.0;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    Double discountedVal = 0.0;
    Double newVal = 0.0;
    Double quantity;

    public ShoppingCartScreen() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));
        setResizable(false);

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
        table.setFillsViewportHeight(true);
        table.getTableHeader().setReorderingAllowed(false);

        // Getting sum of the drink prices
        for (int i = 0; i < table.getRowCount(); i++) {
            discountedVal = ((Double)table.getValueAt(i, 1) * (Double)table.getValueAt(i, 2));
            table.setValueAt((discountedVal*100)/100, i, 4);

            newVal = ((Double)table.getValueAt(i, 3) * (Double)table.getValueAt(i, 4));
            table.setValueAt((newVal*100)/100, i, 5);

            totalAmount.add((Double)table.getValueAt(i, 5));
            total += totalAmount.get(i);
        }

        // showing the sum
        totalAmountLabel.setText(df.format(total));


        // Setting Columns to be not resizable
        for (int i = 0; i > table.getColumnCount(); i++){
            if (table.getColumnModel().getColumnCount() > 0) {
                table.getColumnModel().getColumn(i).setResizable(false);
            }
        }
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
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(innerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(addQuantity)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(checkoutButton)
                                                .addGap(35, 35, 35))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(minusQuantity)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalAmountLabel)
                                                .addGap(50, 50, 50))))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(innerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(totalLabel)
                                                        .addComponent(totalAmountLabel)))
                                        .addComponent(minusQuantity, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkoutButton)
                                        .addComponent(addQuantity))
                                .addContainerGap(97, Short.MAX_VALUE))
        );
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
            if (quantity >= 1) {
                table.setValueAt(quantity -= 1.0, row, 3);
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
        total -= totalAmount.get(row);

        // showing the sum
        totalAmountLabel.setText(df.format(total));
    }

    public JPanel getPanel() {
        return panel;
    }
}
