package screens.customerscreens;

import entities.Drink;

import java.util.ArrayList;
import java.util.Date;

public class DrinkTester {
    public ArrayList<Drink> drinkArrayList() {
        Date productionDate = new Date();
        Date expirationDate = new Date();
        Drink drink1 = new Drink("Strawberry coconut", (float) 7.25, "nueovneroerneoerno", "oat milk", 90,
                productionDate, expirationDate, (float) 0.7);
        Drink drink2 = new Drink("Coffee", (float) 9.0, "vaervererere", "water", 90,
                productionDate, expirationDate, (float) 0.9);
        Drink drink3 = new Drink("Whiskey", (float) 20.0, "deaefefee", "alcohol", 150,
                productionDate, expirationDate, (float) 0.8);

        ArrayList<Drink> drinks = new ArrayList<>();
        drinks.add(drink1);
        drinks.add(drink2);
        drinks.add(drink3);

        return drinks;
    }
}
