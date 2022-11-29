package usecases.drinkusecases;

import entities.Drink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public static ArrayList<Drink> getDrinkList() {
        ArrayList<Drink> drinkList = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, Drink>> drinkSet : DrinkRuntimeDataBase.getDrinks().entrySet()) {
            for (Map.Entry<String, Drink> drink : drinkSet.getValue().entrySet()) {
                drink.getValue().setStoreName(drinkSet.getKey());
                drinkList.add(drink.getValue());
            }
        }
        return drinkList;
    }

    public static void setDrinks(HashMap<String, HashMap<String, Drink>> drinks) {
        DrinkRuntimeDataBase.drinks = drinks;
    }

    public static void addStore(String storeName) {
        DrinkRuntimeDataBase.drinks.put(storeName, new HashMap<>());
    }
}
