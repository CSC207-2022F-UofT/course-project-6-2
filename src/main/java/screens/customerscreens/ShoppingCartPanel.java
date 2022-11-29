package screens.customerscreens;
import usecases.drinkusecases.GetSumOfDrinks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author sanciagao
 */
public class ShoppingCartPanel extends JFrame {

    // Variables declaration
    private final JPanel panel = new JPanel();
    JTable table;
    JScrollPane scrollPane;
    Vector headers = new Vector();
    Vector data = new Vector();
    JButton checkoutButton = new JButton("Checkout");
    JButton addQuantity = new JButton("+");
    JButton minusQuantity = new JButton("-");
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

        // setting up JTable
        headers.add("Drink Name");
        headers.add("Drink Price");
        headers.add("Discount");
        headers.add("Quantity");
        headers.add("Discounted Price");
        headers.add("Drink Final Price");

        Vector col = new Vector<>();
        for (int i = 0; i < 20; i++) {
            col.add(0, "Drink1");
            col.add(1, 19.0);
            col.add(2, 0.1);
            col.add(3, 1.0);
            col.add(4, discountedVal);
            col.add(5, 0.0);
            data.add(col);
        }

        table = new JTable(data, headers);

        // Setting Columns to be not resizable
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Creating table and scrollpane
        table.setFillsViewportHeight(true);

        //Adding the two panels to the contentPane.
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 0, 700, 400);
        panel.add(scrollPane);

        // adding components on panel
        addQuantity.setBounds(80, 450, 120, 40);
        minusQuantity.setBounds(80, 500, 120, 40);
        checkoutButton.setBounds(600, 475, 120, 40);
        totalLabel.setBounds(600, 400, 100, 45);
        totalAmountLabel.setBounds(650, 400, 100, 45);

        panel.add(addQuantity);
        panel.add(minusQuantity);
        panel.add(checkoutButton);
        panel.add(totalLabel);
        panel.add(totalAmountLabel);

        // Getting sum of the drink prices
        total = getSum.getSumOfDrinks(table, discountedVal, newVal, totalAmount, total);

        // showing the sum
        totalAmountLabel.setText(df.format(total));

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
    }


    private void checkoutButtonActionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutButton){
            scrollPane.removeAll();
            totalAmountLabel.setText("0");
            JOptionPane.showMessageDialog(null,
                    "You have checked out! You can go to your order history to check your items :)");
        }
    }

    private void addQuantityActionPerformed(ActionEvent e) {

        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();

        if (e.getSource() == addQuantity) {
            quantity = (Double) table.getValueAt(row, column);
            table.setValueAt(quantity += 1.0, row, column);
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
