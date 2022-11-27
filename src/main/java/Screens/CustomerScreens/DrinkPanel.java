package Screens.CustomerScreens;

import Entities.Drink;
import UseCases.GetOnSaleDrinks;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class DrinkPanel {
    JScrollPane scrollPane;

    public DrinkPanel() {
        Vector headers = new Vector();
        Vector data = new Vector();
        Vector line = new Vector();
        ArrayList<Drink> onSaleDrinks = new GetOnSaleDrinks().onSale();
        DecimalFormat df = new DecimalFormat("0.00");

        headers.add("Drink name");
        headers.add("Store name");
        headers.add("Price");
        headers.add("Add to Shopping Cart");

        for (Drink drink: onSaleDrinks) {
            line.add(drink.getName());
            line.add(drink.getPrice());
            line.add(drink.getDiscount());
            line.add(df.format(drink.getPrice() * drink.getDiscount()));
            data.add(line);
        }

        JTable orderTable = new JTable(data, headers);
        scrollPane = new JScrollPane(orderTable);
    }

    public JScrollPane getPanel() {
        return scrollPane;
    }
}
