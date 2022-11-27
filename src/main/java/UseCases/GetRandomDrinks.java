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
        ArrayList randomDrinks = new ArrayList<>();
        for (Drink drink : drinks){
            if (drink.getDiscount() != 1) {
                randomDrinks.add(drink);
            }
        }
        return randomDrinks;
    }
}
