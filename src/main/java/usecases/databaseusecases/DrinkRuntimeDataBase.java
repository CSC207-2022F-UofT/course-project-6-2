package usecases.databaseusecases;

import entities.Drink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The drink runtime database use case is used to keep track of all the drinks in the database.
 */
public class DrinkRuntimeDataBase {
    /**
     * HashMap of all drinks existed in database.
     * Key: StoreName
     * Value: key: DrinkName, value: Drink
     */

    protected static HashMap<String, HashMap<String, Drink>> drinks;

    public static HashMap<String, HashMap<String, Drink>> getDrinks() {
        if (drinks != null) {
            return drinks;
        } else{
            return new HashMap<>();
        }
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
        if (drinks == null) {
            drinks = new HashMap<>();
        }
        DrinkRuntimeDataBase.drinks.put(storeName, new HashMap<>());
        }
    }
