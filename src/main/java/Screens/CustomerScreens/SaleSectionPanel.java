package Screens.CustomerScreens;

import Entities.Drink;
import Screens.Button;
import UseCases.GetOnSaleDrinks;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class SaleSectionPanel {
    JScrollPane scrollPane;
    Button addToCart;
    public SaleSectionPanel() {
        Vector headers = new Vector();
        Vector data = new Vector();
        Vector line = new Vector();
        JPanel panel = new JPanel();
        ArrayList<Drink> onSaleDrinks = new GetOnSaleDrinks().onSale();
        DecimalFormat df = new DecimalFormat("0.00");

        headers.add("Drink name");
        headers.add("Original Price");
        headers.add("Discount");
        headers.add("Current Price");

        JTable drinkTable = new JTable(data, headers);
        drinkTable.getTableHeader().setReorderingAllowed(false);
        drinkTable.getTableHeader().setResizingAllowed(false);

        for (Drink drink: onSaleDrinks) {
            line.add(drink.getName());
            line.add("$" + drink.getPrice());
            line.add((1 - drink.getDiscount()) * 100 + "%");
            line.add("$" + df.format(drink.getPrice() * drink.getDiscount()));
            data.add(line);
        }

        // test part
        for (int i = 0; i < 30; i ++) {
            Vector line1 = new Vector();
            line1.add("Strawberry Coconut");
            line1.add("$18.00");
            line1.add("30%");
            line1.add("$12.60");
            data.add(line1);
        }

        addToCart.createButton(panel, "Add to Cart", 50, 50, 100, 50);

        scrollPane = new JScrollPane(drinkTable);
    }
    public JScrollPane getPanel() {
        return scrollPane;
    }
}
