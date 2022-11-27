package UseCases.DrinkUseCases;

import Entities.Drink;
import Helpers.Deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstructDrinkDataBase {
    private static final Deserializer searchDeserializer = new Helpers.Deserializer();

    @SuppressWarnings("unchecked")
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        DrinkRuntimeDataBase.drinks = (HashMap<String, Drink>) searchDeserializer.getObject();
    }
}
