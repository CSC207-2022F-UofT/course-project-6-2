package filtersearch;

import java.io.IOException;
import java.util.ArrayList;


import drink.Drink;
import helpers.Deserializer;

public class Searching {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    protected static ArrayList filtered_items = new ArrayList<>();
    private static final Deserializer searchDeserializer = new Deserializer();
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        drinks = (ArrayList<Drink>) searchDeserializer.getObject();
    }

    public static ArrayList Add_to_Filtered( String keyword){
        for (int i = 0; i < drinks.size(); i++){
            String lowercase_name = drinks.get(i).getName().toLowerCase();
            String lowercase_description = drinks.get(i).getDescription().toLowerCase();
            if (lowercase_name.equals(keyword.toLowerCase())){
                filtered_items.add(drinks.get(i));
            } else if (lowercase_description.contains(keyword.toLowerCase())) {
                filtered_items.add(drinks.get(i));
            }
        }
        return filtered_items;
    }

}
