package UseCases;

import Entities.Drink;
import Helpers.Deserializer;

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
        if (drinks.size() > 25) {
            ArrayList<Drink> randomDrinks = new ArrayList<>();
            for (int i = 0; i < 25; i ++) {
                randomDrinks.add(drinks.get(i));
            }
            return randomDrinks;
        }
        return drinks;
    }
}
