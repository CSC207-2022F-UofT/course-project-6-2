package usecases.drinkusecases;

import entities.Drink;

import java.io.IOException;
import java.util.HashMap;

public class SaveDrinkDataBase {
    private static final helpers.Serializer drinkSerializer = new helpers.Serializer();
    /**
     * saveDrinkDataBase: Store drinks HashMap data to database
     */
    public static void saveDrinkDataBase() throws IOException {
        HashMap<String, HashMap<String, Drink>> drinks = DrinkRuntimeDataBase.getDrinks();
        drinkSerializer.serialize("./data/users", drinks);
    }
}




