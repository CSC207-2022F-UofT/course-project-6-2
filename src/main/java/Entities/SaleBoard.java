package Entities;

import UseCases.DrinkRuntimeDataBase;

import java.util.ArrayList;
import java.util.Map;

public class SaleBoard {

    public ArrayList<Drink> onSale(){
        ArrayList onSaleDrinks = new ArrayList<>();
        for (Map.Entry<String, Drink> drink : DrinkRuntimeDataBase.drinks.entrySet()){
            if (drink.getValue().getDiscount() != 1) {
                onSaleDrinks.add(drink);
            }
        }
        return onSaleDrinks;
    }
}
