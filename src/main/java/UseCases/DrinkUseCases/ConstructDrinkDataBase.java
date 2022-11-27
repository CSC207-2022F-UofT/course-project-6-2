package UseCases.DrinkUseCases;

import Entities.Drink;
import Helpers.Deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstructDrinkDataBase {
    private static final Deserializer drinkDeserializer = new Helpers.Deserializer();

    @SuppressWarnings("unchecked")
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        drinkDeserializer.deserialize("./data/drinks");

        DrinkRuntimeDataBase.drinks = (HashMap<String, HashMap<String, Drink>>) drinkDeserializer.getObject();
    }
}
