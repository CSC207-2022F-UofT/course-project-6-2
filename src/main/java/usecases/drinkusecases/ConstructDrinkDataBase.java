package usecases.drinkusecases;

import entities.Drink;
import helpers.Deserializer;

import java.io.IOException;
import java.util.HashMap;

public class ConstructDrinkDataBase {
    private static final Deserializer drinkDeserializer = new helpers.Deserializer();

    @SuppressWarnings("unchecked")
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        drinkDeserializer.deserialize("./data/drinks");

        DrinkRuntimeDataBase.drinks = (HashMap<String, HashMap<String, Drink>>) drinkDeserializer.getObject();
    }
}
