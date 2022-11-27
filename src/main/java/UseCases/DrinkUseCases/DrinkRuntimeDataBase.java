package UseCases.DrinkUseCases;

import Entities.Drink;

import java.util.HashMap;

public class DrinkRuntimeDataBase {
    protected static HashMap<String, Drink> drinks;

    public static HashMap<String, Drink> getDrinks() {
        return drinks;
    }
}
