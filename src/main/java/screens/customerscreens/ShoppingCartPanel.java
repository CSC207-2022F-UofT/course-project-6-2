package screens.customerscreens;

import entities.Drink;
import usecases.drinkusecases.GetSumOfDrinks;
import usecases.shoppingcartusecases.AddQuantityButtonActionPerformed;
import usecases.shoppingcartusecases.CheckoutButtonActionPerformed;
import usecases.shoppingcartusecases.MinusQuantityButtonActionPerformed;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author sanciagao
 */
public class ShoppingCartPanel extends JFrame {

    // Variables declaration
    JFrame frame = new JFrame();
    JTable table;
    JScrollPane scrollPane;
    Float quantity = 1.0F;
    ArrayList<Float> totalAmount = new ArrayList<>();
    protected static Vector data = new Vector<>();
    private final JPanel panel = new JPanel();
    private final Vector<String> headers = new Vector<>();
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton addQuantity = new JButton("+");
    private final JButton minusQuantity = new JButton("-");
    public static JLabel totalAmountLabel = new JLabel();
    private final DecimalFormat df = new DecimalFormat("0.00");
    private final HashMap<Drink, Integer> drinks = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList();
    private Float total = 0.0f;

    public ShoppingCartPanel() {

        // setting up local variable
        JLabel totalLabel = new JLabel("Total: ");
        GetSumOfDrinks getSum = new GetSumOfDrinks();

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Order History");
        frame.setResizable(false);
        panel.setLayout(null);

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
            col.add(total);
            data.add(col);
        }

        // Adding components onto JTable
        table = new JTable(data, headers);

        // Getting sum of the drink prices
        total = getSum.getSumOfDrinks(table, totalAmount, total);

        // showing the sum
        totalAmountLabel.setText("$" + df.format(total));

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
        frame.add(panel);

        // Action Listeners
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CheckoutButtonActionPerformed.checkoutButtonActionPerformed(evt, checkoutButton, data, drinks,
                        frame, totalAmount);
            }
        });

        addQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                total = AddQuantityButtonActionPerformed.addQuantityActionPerformed(evt, headers, table, addQuantity,
                        totalAmount, df, total);

                // showing the sum
                totalAmountLabel.setText("$" + df.format(total));
            }
        });

        minusQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                total = MinusQuantityButtonActionPerformed.minusQuantityActionPerformed(evt,headers, table, minusQuantity,
                        totalAmount, df, total);

                // showing the sum
                totalAmountLabel.setText("$" + df.format(total));
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
