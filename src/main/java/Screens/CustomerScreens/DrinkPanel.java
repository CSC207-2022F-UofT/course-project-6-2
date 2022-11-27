package Screens.CustomerScreens;

import Entities.Drink;
import Screens.Button;
import UseCases.GetOnSaleDrinks;
import UseCases.GetRandomDrinks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class DrinkPanel extends JFrame implements ActionListener {
    JScrollPane scrollPane;
    JPanel panel = new JPanel();
    JTable drinkTable;
    Drink selectedDrink;
    Button addToCart = new Button();

    public DrinkPanel() {
        Vector headers = new Vector();
        Vector data = new Vector();
        Vector line = new Vector();
        ArrayList<Drink> randomDrinks = new GetRandomDrinks().randomDrinks();
        DecimalFormat df = new DecimalFormat("0.00");

        headers.add("Drink name");
        headers.add("Store Name");
        headers.add("Price");
        headers.add("Volume");

        for (Drink drink: randomDrinks) {
            line.add(drink.getName());
            line.add(drink.getStoreName());
            line.add("$" + drink.getPrice());
            line.add(drink.getVolume());
            data.add(line);
        }

        // test part
        for (int i = 0; i < 25; i ++) {
            Vector<String> line1 = new Vector<>();
            line1.add("Apple Juice");
            line1.add("Andy's Drink Store");
            line1.add("$10.00");
            line1.add("750ml");
            data.add(line1);
        }

        drinkTable = new JTable(data, headers);
        drinkTable.getTableHeader().setReorderingAllowed(false);
        drinkTable.getTableHeader().setResizingAllowed(false);

        addToCart.createButton(panel, "Add to Cart", 0, 0, 0, 0);
        addToCart.addActionListener(this);
        scrollPane = new JScrollPane(drinkTable);
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

    }
}
