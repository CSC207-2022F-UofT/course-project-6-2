package UseCases.DrinkUseCases;

import Entities.Drink;
import Entities.Users.Seller;

import java.util.HashMap;

public class DrinkRuntimeDataBase {
    /**
     * HashMap of all drinks existed in database.
     * Key: StoreName
     * Value: key: DrinkName, value: Drink
     */

    protected static HashMap<String, HashMap<String, Drink>> drinks;

    public static HashMap<String, HashMap<String, Drink>> getDrinks() {
        return drinks;
    }

    public static void addStore(String storeName) {
        DrinkRuntimeDataBase.drinks.put(storeName, new HashMap<>());
    }
}
