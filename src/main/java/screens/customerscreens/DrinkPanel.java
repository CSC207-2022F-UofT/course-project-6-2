package screens.customerscreens;

import entities.Drink;
import screens.swingcomponents.Button;
import usecases.drinkusecases.GetRandomDrinks;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The drinks panel that displays random drinks and can be added to shopping cart
 */

public class DrinkPanel extends JFrame implements ActionListener {
    private final JPanel panel = new JPanel();
    private Drink selectedDrink;
    public DrinkPanel() {
        panel.setLayout(null);

        Vector<String> headers = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();
        Vector<String > line = new Vector<>();
        ArrayList<Drink> randomDrinks = new GetRandomDrinks().randomDrinks();

        headers.add("Drink name");
        headers.add("Store Name");
        headers.add("Price");
        headers.add("Volume");

        for (Drink drink: randomDrinks) {
            line.add(drink.getName());
            line.add(drink.getStoreName());
            line.add("$" + drink.getPrice());
            line.add(drink.getVolume() + "ml");
            data.add(line);
        }

        // test part
        for (int i = 0; i < 30; i ++) {
            Vector<String> line1 = new Vector<>();
            line1.add("Apple Juice");
            line1.add("Andy's Drink Store");
            line1.add("$10.00");
            line1.add("750ml");
            data.add(line1);
        }

        JTable drinkTable = new JTable(data, headers);
        drinkTable.getTableHeader().setReorderingAllowed(false);
        drinkTable.getTableHeader().setResizingAllowed(false);

        Button addToCart = new Button();
        addToCart.createButton(panel, "Add to Cart", 330, 440, 120, 40);
        addToCart.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane(drinkTable);
        scrollPane.setBounds(50,0,700, 400);
        panel.add(scrollPane);

        ListSelectionModel model = drinkTable.getSelectionModel();
        model.addListSelectionListener(e -> {
            if (! model.isSelectionEmpty()) {
                int selectedRow = model.getMinSelectionIndex();
                selectedDrink = randomDrinks.get(selectedRow);
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
        UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().addItem(selectedDrink, 1);
    }
}
