package usecases.drinkusecases;

import java.util.ArrayList;

import entities.Drink;
import usecases.databaseusecases.DrinkRuntimeDataBase;

import java.util.Vector;
import java.util.Date;

public class SearchDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>(DrinkRuntimeDataBase.getDrinkList());
    private static final Vector<Drink> filteredItems = new Vector<>();
    public static Vector<Vector<String>> addToFiltered(String keyword){
        Vector<Vector<String>> data = new Vector<>();
        for (Drink drink : drinks){
            if (drink.getName().equals(keyword)){
                filteredItems.add(drink);
            } else if (drink.getDescription().contains(keyword)) {
                filteredItems.add(drink);
            }
        }
        if (!filteredItems.isEmpty()){
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
                @SuppressWarnings("unchecked")
                Vector<String> line = new Vector<>();
                line.add(name);
                line.add(storeName);
                line.add(String.valueOf(price));
                line.add(String.valueOf(volume));
                line.add(description);
                line.add(ingredient);
                line.add(String.valueOf(productionDate));
                line.add(String.valueOf(expirationDate));
                line.add(String.valueOf(discount));
                data.add(line);
            }
        }
        return data;
    }

    public void clearFilteredItems() {
        filteredItems.clear();
    }

    public static Vector<Drink> getDrinks() {
        return filteredItems;
    }
}