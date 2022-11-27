package UseCases.DrinkUseCases;

import Entities.Drink;
import UseCases.UserUseCases.UserRuntimeDataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SaveDrinkDataBase {
    private static final Helpers.Serializer drinkSerializer = new Helpers.Serializer();
    /**
     * saveDrinkDataBase: Store drinks HashMap data to database
     */
    public static void saveDrinkDataBase() throws IOException {
        HashMap<String, HashMap<String, Drink>> drinks = DrinkRuntimeDataBase.getDrinks();
        drinkSerializer.serialize("./data/users", drinks);
    }
}




