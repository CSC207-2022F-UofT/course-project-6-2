package screens.customerscreens;

import controllers.ShoppingCartController;
import entities.Drink;
import entities.users.Customer;
import usecases.drinkusecases.GetSumOfDrinks;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.*;

public class ShoppingCartPanel extends JFrame implements ActionListener {
    // Variables declaration
    private final JTable table;
    ArrayList<Float> totalAmount = new ArrayList<>();
    protected Vector<Vector<String>> data = new Vector<>();
    private final JFrame frame;
    private final JPanel panel = new JPanel();
    private final Vector<String> headers = new Vector<>();
    private final JButton checkoutButton = new JButton("Checkout");
    private final JButton addQuantityButton = new JButton("+");
    private final JButton minusQuantityButton = new JButton("-");
    public static JLabel totalAmountLabel = new JLabel();
    private final HashMap<Drink, Integer> drinks = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getItemList();
    private Drink selectedDrink;
    protected static Customer currCustomer = UserRuntimeDataBase.getCurrentCustomer();
    private final DecimalFormat df = new DecimalFormat("0.00");
    private Float total = 0.00f;

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
        headers.add("Store Name");
        headers.add("Discounted Price");
        headers.add("Drink Final Price");

        // setting up JTable data
        for (Map.Entry<Drink, Integer> drinkSet: drinks.entrySet()) {
            Drink drink = drinkSet.getKey();
            Vector<String> col = new Vector<>();
            col.add(drink.getName());
            col.add("$" + drink.getPrice());
            col.add(df.format((1 - drink.getDiscount()) * 100) + "%");
            col.add(String.valueOf(drinkSet.getValue()));
            col.add(drink.getStoreName());
            col.add(df.format(drink.getPrice() * drink.getDiscount()));
            col.add(String.valueOf(total));
            data.add(col);
        }

        // Adding components onto JTable
        table = new JTable(data, headers);

        // Getting sum of the drink prices
        total = getSum.getSumOfDrinks(table, totalAmount, total);

        // showing the sum
        totalAmountLabel.setText("$" + df.format(total));

        // get selected drink
        ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(e -> {
            if (! model.isSelectionEmpty()) {
                int selectedRow = model.getMinSelectionIndex();
                List<Drink> drinkList = new ArrayList<>(drinks.keySet());
                selectedDrink = drinkList.get(selectedRow);
            }
        });

        // Setting Columns to be not resizable and not reorderable
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // Creating the scrollpane and adding it to the panel
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 0, 700, 400);
        panel.add(scrollPane);

        // Creating components
        addQuantityButton.setBounds(80, 415, 100, 40);
        addQuantityButton.addActionListener(this);
        minusQuantityButton.setBounds(80, 465, 100, 40);
        minusQuantityButton.addActionListener(this);
        checkoutButton.setBounds(600, 450, 100, 40);
        checkoutButton.addActionListener(this);
        totalLabel.setBounds(600, 400, 100, 45);
        totalAmountLabel.setBounds(650, 400, 100, 45);

        // adding components on panel
        panel.add(addQuantityButton);
        panel.add(minusQuantityButton);
        panel.add(checkoutButton);
        panel.add(totalLabel);
        panel.add(totalAmountLabel);
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ShoppingCartController shoppingCartController = new ShoppingCartController(data, headers, drinks, selectedDrink,
                totalAmount, total, frame, table);
        if (e.getSource() == addQuantityButton) {
            total = shoppingCartController.addItem();

            // showing the sum
            totalAmountLabel.setText("$" + df.format(total));
        }

        if (e.getSource() == minusQuantityButton) {
            total = shoppingCartController.minusItem();

            // showing the sum
            totalAmountLabel.setText("$" + df.format(total));
        }

        if (e.getSource() == checkoutButton) {
            shoppingCartController.checkOut();
            total = 0.00f;
            currCustomer.getShoppingCart().getItemList().clear();
            new CustomerMainScreen();
        }
    }
}
