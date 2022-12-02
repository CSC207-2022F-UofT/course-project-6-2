package screens.customerscreens;

import entities.Drink;
import entities.users.Customer;
import usecases.drinkusecases.GetSumOfDrinks;
import usecases.shoppingcartusecases.AddQuantityButtonActionPerformed;
import usecases.shoppingcartusecases.CheckoutButtonActionPerformed;
import usecases.shoppingcartusecases.MinusQuantityButtonActionPerformed;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author sanciagao
 */
public class ShoppingCartPanel extends JFrame {

    // Variables declaration
    JTable table;
    JScrollPane scrollPane;
    ArrayList<Float> totalAmount = new ArrayList<>();
    protected Vector data = new Vector<>();
    private final JFrame frame;
    private final JPanel panel = new JPanel();
    private final Vector<String> headers = new Vector<>();
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton addQuantityButton = new JButton("+");
    private final JButton minusQuantityButton = new JButton("-");
    public static JLabel totalAmountLabel = new JLabel();
    private final DecimalFormat df = new DecimalFormat("0.00");
    private final HashMap<Drink, Integer> drinks = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList();
    protected static Customer currCustomer = UserRuntimeDataBase.getCurrentCustomer();
    private Float total = 0.0f;

    public ShoppingCartPanel(JFrame frame) {

        this.frame = frame;

        // setting up local variable
        JLabel totalLabel = new JLabel("Total: ");
        GetSumOfDrinks getSum = new GetSumOfDrinks();

        panel.setLayout(null);

        // setting up JTable headers
        headers.add("Drink Name");
        headers.add("Drink Price");
        headers.add("Discount");
        headers.add("Quantity");
        headers.add("Discounted Price");
        headers.add("Drink Final Price");

        // setting up JTable data
        for (Map.Entry<Drink, Integer> drinkSet: drinks.entrySet()) {
            Drink drink = drinkSet.getKey();
            Vector col = new Vector<>();
            col.add(drink.getName());
            col.add("$" + drink.getPrice());
            col.add(df.format((1 - drink.getDiscount()) * 100) + "%");
            col.add(drinkSet.getValue());
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
        addQuantityButton.setBounds(80, 415, 100, 40);
        minusQuantityButton.setBounds(80, 465, 100, 40);
        checkoutButton.setBounds(600, 450, 100, 40);
        totalLabel.setBounds(600, 400, 100, 45);
        totalAmountLabel.setBounds(650, 400, 100, 45);

        // adding components on panel
        panel.add(addQuantityButton);
        panel.add(minusQuantityButton);
        panel.add(checkoutButton);
        panel.add(totalLabel);
        panel.add(totalAmountLabel);

        // Action Listeners
        addQuantityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                total = AddQuantityButtonActionPerformed.addQuantityActionPerformed(evt, headers, table, addQuantityButton,
                        totalAmount, df, total);

                // showing the sum
                totalAmountLabel.setText("$" + df.format(total));
            }
        });

        minusQuantityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                total = MinusQuantityButtonActionPerformed.minusQuantityActionPerformed(evt,headers, table, minusQuantityButton,
                        totalAmount, df, total);

                // showing the sum
                totalAmountLabel.setText("$" + df.format(total));
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CheckoutButtonActionPerformed.checkoutButtonActionPerformed(evt, checkoutButton, data, drinks,
                        totalAmount, total, frame);
                total = 0.0f;
                currCustomer.getShoppingCart().getItemList().clear();
                drinks.clear();
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
