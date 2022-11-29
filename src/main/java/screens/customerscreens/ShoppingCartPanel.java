package screens.customerscreens;

import entities.Drink;
import entities.Order;
import entities.users.Customer;
import usecases.customerusecases.AddToOrderHistory;
import usecases.drinkusecases.GetSumOfDrinks;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
    private final Vector headers = new Vector();
    Vector data = new Vector();
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton addQuantity = new JButton("+");
    private final JButton minusQuantity = new JButton("-");
    private final JLabel totalAmountLabel = new JLabel();
    private final JLabel totalLabel = new JLabel("Total: ");
    private final ArrayList<Float> totalAmount = new ArrayList<>();
    float total = 0.0F;
    private final DecimalFormat df = new DecimalFormat("0.00");
    float newVal = 0.0F;
    private final GetSumOfDrinks getSum = new GetSumOfDrinks();
    private final HashMap<Drink, Integer> drinks = new HashMap<>();
    private final Date productionDate = new Date();
    private final Date expirationDate = new Date();
    private final Drink drink1 = new Drink("i", (float) 19.8, "drink", "water", 90,
            productionDate, expirationDate, (float) 0.7);
    private final Drink drink2 = new Drink("d", (float) 9.0, "drink1", "water", 90,
            productionDate, expirationDate, (float) 0.9);
    private final Drink drink3 = new Drink("hii", (float) 9.0, "drink2", "water", 90,
            productionDate, expirationDate, (float) 0.3);
    float quantity = 1.0F;

    public ShoppingCartPanel() {
        panel.setLayout(null);
        drinks.put(drink1, (int) quantity);
        drinks.put(drink2, (int) quantity);
        drinks.put(drink3, (int) quantity);

        // setting up JTable headers
        headers.add("Drink Name");
        headers.add("Drink Price");
        headers.add("Discount");
        headers.add("Quantity");
        headers.add("Discounted Price");
        headers.add("Drink Final Price");

        // setting up JTable data
        for (Drink drink: drinks.keySet()) {
            Vector col = new Vector<>();
            col.add(drink.getName());
            col.add("$" + drink.getPrice());
            col.add(df.format((1 - drink.getDiscount()) * 100) + "%");
            col.add(quantity);
            col.add(df.format(drink.getPrice() * drink.getDiscount()));
            col.add("$" + total);
            data.add(col);
        }

        // Adding components onto JTable
        table = new JTable(data, headers);

        // Getting sum of the drink prices
        total = getSum.getSumOfDrinks(table, totalAmount, total);

        // Setting Columns to be not resizable and not reorderable
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Creating the scrollpane and adding it to the panel
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 0, 700, 400);
        panel.add(scrollPane);

        // Creating components
        addQuantity.setBounds(80, 415, 100, 40);
        minusQuantity.setBounds(80, 465, 100, 40);
        checkoutButton.setBounds(600, 450, 100, 40);
        totalLabel.setBounds(600, 400, 100, 45);
        totalAmountLabel.setBounds(650, 400, 100, 45);

        // adding components on panel
        panel.add(addQuantity);
        panel.add(minusQuantity);
        panel.add(checkoutButton);
        panel.add(totalLabel);
        panel.add(totalAmountLabel);

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


    // Creating checkoutButton Action Event
    private void checkoutButtonActionPerformed(ActionEvent e) {
        if (e.getSource() == checkoutButton){
            Order order = new Order(drinks, "Processing");

            data.removeAllElements();
            AddToOrderHistory addToOrderHistory = new AddToOrderHistory();
            addToOrderHistory.addToOrderHistory(drinks);

            totalAmountLabel.setText("0");
            JOptionPane.showMessageDialog(null,
                    "You have checked out! You can go to your order history to check your items :)");
        }
    }

    // Creating addQuantityButton Action Event
    private void addQuantityActionPerformed(ActionEvent e) {

        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();
        if (row == -1) return;

        if (e.getSource() == addQuantity) {
            quantity = Float.parseFloat(table.getValueAt(row, column).toString());
            table.setValueAt(quantity += 1, row, column);
        }

        totalAmount.add(Float.parseFloat(table.getValueAt(row, 4).toString()));

        for (int i = 0; i < totalAmount.size(); i++) {
            newVal = quantity * Float.parseFloat(table.getValueAt(row, 4).toString());
            table.setValueAt(df.format(newVal), row, 5);
        }
        total += totalAmount.get(row);

        // showing the sum
        totalAmountLabel.setText("$" + df.format(total));
    }

    // Creating minusQuantity Action Event
    private void minusQuantityActionPerformed(ActionEvent e) {

        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();
        if (row == -1) return;

        if (e.getSource() == minusQuantity) {
            quantity = Float.parseFloat(table.getValueAt(row, column).toString());
            if (quantity > 0) {
                table.setValueAt(quantity -= 1, row, column);
                total -= totalAmount.get(row);
            } else{
                JOptionPane.showMessageDialog(null,
                        "Sorry, You can not delete anymore drinks");
            }
        }

        totalAmount.add(Float.parseFloat(table.getValueAt(row, 4).toString()));

        for (int i = 0; i < totalAmount.size(); i++) {
            newVal = quantity * Float.parseFloat(table.getValueAt(row, 4).toString());
            table.setValueAt(df.format(newVal), row, 5);
        }

        // showing the sum
        totalAmountLabel.setText("$" + df.format(total));
    }

    public JPanel getPanel() {
        return panel;
    }
}
