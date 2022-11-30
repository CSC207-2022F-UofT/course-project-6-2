package usecases.drinkusecases;

import java.util.ArrayList;

import entities.Drink;

import java.util.Vector;
import java.util.Date;

public class SearchDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    public static Vector<Vector<Drink>> addToFiltered(String keyword){
        Vector<Drink> filtered_items = new Vector();
        Vector<Vector<Drink>> data = new Vector<>();
        for (Drink drink : drinks){
            if (drink.getName().equals(keyword)){
                filtered_items.add(drink);
            } else if (drink.getDescription().contains(keyword)) {
                filtered_items.add(drink);
            }
        }
        if (filtered_items != null){
            for (Drink d :filtered_items) {
                String name = d.getName();
                float price = d.getPrice();
                String description = d.getDescription();
                String ingredient = d.getIngredient();
                int volume = d.getVolume();
                Date production_date = d.getProductionData();
                Date expiration_date = d.getExpirationDate();
                float discount = d.getDiscount();
                String storeName = d.getStoreName();
                Vector line = new Vector<>();
                line.add(name);
                line.add(price);
                line.add(description);
                line.add(ingredient);
                line.add(volume);
                line.add(production_date);
                line.add(expiration_date);
                line.add(discount);
                line.add(storeName);
                data.add(line);
            }
        }

        return data;
    }
}