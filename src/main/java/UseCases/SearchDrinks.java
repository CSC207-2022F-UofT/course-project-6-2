package UseCases;

import java.io.IOException;
import java.util.ArrayList;


import Entities.Drink;
import Helpers.Deserializer;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;


import javax.xml.crypto.Data;

public class SearchDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    private static final Deserializer searchDeserializer = new Deserializer();
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        drinks = (ArrayList<Drink>) searchDeserializer.getObject();
    }

    public static Vector<Vector<Drink>> Add_to_Filtered(String keyword){
        Vector<Drink> filtered_items = new Vector();
        Vector<Vector<Drink>> data = new Vector<>();
        for (Drink drink : drinks){
            String lowercase_name = drink.getName().toLowerCase();
            String lowercase_description = drink.getDescription().toLowerCase();
            if (lowercase_name.equals(keyword.toLowerCase())){
                filtered_items.add(drink);
            } else if (lowercase_description.contains(keyword.toLowerCase())) {
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
            return data;
        }
        return null;


    }
}

