package usecases.drinkusecases;

import java.util.ArrayList;

import entities.Drink;
import usecases.databaseusecases.DrinkRuntimeDataBase;

import java.util.Objects;
import java.util.Vector;

public class SearchDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>(DrinkRuntimeDataBase.getDrinkList());
    private static Vector<Drink> filteredItems = new Vector<>();
    public static Vector<Vector<String>> addToFiltered(String keyword){
        Vector<Vector<String>> data = new Vector<>();

        if (Objects.equals(keyword, "")) {
            filteredItems = new Vector<>();
        } else {
            for (Drink drink : drinks){
                if (drink.getName().contains(keyword)){
                    filteredItems.add(drink);
                } else if (drink.getDescription().contains(keyword)) {
                    filteredItems.add(drink);
                }
            }
        }

        if (!filteredItems.isEmpty()){
            for (Drink drink : filteredItems) {
                String name = drink.getName();
                float price = drink.getPrice();
                int volume = drink.getVolume();
                String storeName = drink.getStoreName();
                Vector<String> line = new Vector<>();
                line.add(name);
                line.add(storeName);
                line.add("$" + price);
                line.add(volume + "ml");
                data.add(line);
            }
        }
        return data;
    }

    public static void clearFilteredItems() {
        filteredItems.clear();
    }

    public static Vector<Drink> getDrinks() {
        return filteredItems;
    }
}