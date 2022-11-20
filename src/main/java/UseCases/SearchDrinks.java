package UseCases;

import java.io.IOException;
import java.util.ArrayList;


import Entities.Drink;
import Helpers.Deserializer;

public class SearchDrinks {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    private static final Deserializer searchDeserializer = new Deserializer();
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        drinks = (ArrayList<Drink>) searchDeserializer.getObject();
    }

    public static ArrayList Add_to_Filtered(String keyword){
        ArrayList filtered_items = new ArrayList<>();
        for (Drink drink : drinks){
            String lowercase_name = drink.getName().toLowerCase();
            String lowercase_description = drink.getDescription().toLowerCase();
            if (lowercase_name.equals(keyword.toLowerCase())){
                filtered_items.add(drink);
            } else if (lowercase_description.contains(keyword.toLowerCase())) {
                filtered_items.add(drink);
            }
        }
        return filtered_items;
    }

}
