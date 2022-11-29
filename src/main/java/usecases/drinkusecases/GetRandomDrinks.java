package usecases.drinkusecases;

import entities.Drink;
import helpers.Deserializer;

import java.io.IOException;
import java.util.ArrayList;

public class GetRandomDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    private static final Deserializer searchDeserializer = new Deserializer();
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        drinks = (ArrayList<Drink>) searchDeserializer.getObject();
    }
    public ArrayList<Drink> randomDrinks(){
        if (drinks.size() > 30) {
            ArrayList<Drink> randomDrinks = new ArrayList<>();
            for (int i = 0; i < 30; i ++) {
                randomDrinks.add(drinks.get(i));
            }
            return randomDrinks;
        }
        return drinks;
    }
}
