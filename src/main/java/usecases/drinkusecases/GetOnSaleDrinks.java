package usecases.drinkusecases;

import entities.Drink;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GetOnSaleDrinks {
    public ArrayList<Drink> onSale() {
        ArrayList<Drink> onSaleDrinks = new ArrayList<>();
        for (Map.Entry<String, HashMap<String, Drink>> drinkSet : DrinkRuntimeDataBase.getDrinks().entrySet()) {
            for (Map.Entry<String, Drink> drink : drinkSet.getValue().entrySet()) {
                if (drink.getValue().getDiscount() != 1) {
                    onSaleDrinks.add(drink.getValue());
                }
            }
        }
        return onSaleDrinks;
    }
}