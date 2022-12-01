package usecases.drinkusecases;

import java.util.ArrayList;

import entities.Drink;

import java.util.Vector;
import java.util.Date;

public class SearchDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>(DrinkRuntimeDataBase.getDrinkList());
    static Vector<Drink> filteredItems = new Vector<>();
    public static Vector<Vector<Drink>> addToFiltered(String keyword){
        Vector<Vector<Drink>> data = new Vector<>();
        for (Drink drink : drinks){
            if (drink.getName().equals(keyword)){
                filteredItems.add(drink);
            } else if (drink.getDescription().contains(keyword)) {
                filteredItems.add(drink);
            }
        }
        if (filteredItems != null){
            for (Drink drink : filteredItems) {
                String name = drink.getName();
                float price = drink.getPrice();
                String description = drink.getDescription();
                String ingredient = drink.getIngredient();
                int volume = drink.getVolume();
                Date productionDate = drink.getProductionData();
                Date expirationDate = drink.getExpirationDate();
                float discount = drink.getDiscount();
                String storeName = drink.getStoreName();
                Vector line = new Vector<>();
                line.add(name);
                line.add(price);
                line.add(description);
                line.add(ingredient);
                line.add(volume);
                line.add(productionDate);
                line.add(expirationDate);
                line.add(discount);
                line.add(storeName);
                data.add(line);
            }
        }
        return data;
    }

    public static Vector<Drink> getDrinks() {
        return filteredItems;
    }
}