package screens.customerscreens;

import entities.Drink;
import screens.swingcomponents.Button;
import usecases.drinkusecases.GetOnSaleDrinks;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The sale section panel that displays on sale drinks and can be added to shopping cart
 */

public class SaleSectionPanel extends JFrame implements ActionListener {
    private final JPanel panel = new JPanel();
    JScrollPane scrollPane;
    JTable drinkTable;
    Drink selectedDrink;
    Button addToCart = new Button();
    public SaleSectionPanel() {
        panel.setLayout(null);

        Vector<String> headers = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();
        Vector<String> line = new Vector<>();
        ArrayList<Drink> onSaleDrinks = new GetOnSaleDrinks().onSale();
        DecimalFormat df = new DecimalFormat("0.00");

        headers.add("Drink name");
        headers.add("Original Price");
        headers.add("Discount");
        headers.add("Current Price");

        for (Drink drink: onSaleDrinks) {
            line.add(drink.getName());
            line.add("$" + drink.getPrice());
            line.add((1 - drink.getDiscount()) * 100 + "%");
            line.add("$" + df.format(drink.getPrice() * drink.getDiscount()));
            data.add(line);
        }

        // test part
        for (int i = 0; i < 30; i ++) {
            Vector<String> line1 = new Vector<>();
            line1.add("Strawberry Coconut");
            line1.add("$18.00");
            line1.add("30%");
            line1.add("$12.60");
            data.add(line1);
        }

        drinkTable = new JTable(data, headers);
        drinkTable.getTableHeader().setReorderingAllowed(false);
        drinkTable.getTableHeader().setResizingAllowed(false);

        addToCart.createButton(panel, "Add to Cart", 330, 440, 120, 40);
        addToCart.addActionListener(this);

        scrollPane = new JScrollPane(drinkTable);
        scrollPane.setBounds(50,0,700, 400);
        panel.add(scrollPane);

        ListSelectionModel model = drinkTable.getSelectionModel();
        model.addListSelectionListener(e -> {
            if (! model.isSelectionEmpty()) {
                int selectedRow = model.getMinSelectionIndex();
                // selectedDrink = onSaleDrinks.get(selectedRow);
            }
        });
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
        if (e.getSource() == addToCart.button) {
            UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().addItem(selectedDrink, 1);
        }
    }
}