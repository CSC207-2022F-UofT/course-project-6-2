package notification_window;

import drink.Drink;
import helpers.Deserializer;

import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;

public class Warn {
    protected static ArrayList<Drink> drinks = new ArrayList<>();
    private static final Deserializer searchDeserializer = new Deserializer();
    public static void constructDrinkDataBase() throws IOException, ClassNotFoundException {
        searchDeserializer.deserialize("./data/drinks");
        drinks = (ArrayList<Drink>) searchDeserializer.getObject();
    }

    public static String warnwhat(HashMap<Drink, String> itemList){
        ArrayList<Drink> cart_items = new ArrayList<>();
        ArrayList<String> dang = new ArrayList<>();
        dang.add("egg");
        dang.add("milk");
        dang.add("peanut");
        dang.add("soybean");
        dang.add("wheat");
        dang.add("alcohol");
        String ans = "Drinks in shopping cart contains";
        for(Drink key: itemList.keySet()){
            cart_items.add(key);
        }
        for (Drink drink : cart_items){
            String lowercase_ingredient = drink.getIngredient().toLowerCase();
            for(String d: dang){
                if (lowercase_ingredient.contains(d)){
                    if (!ans.contains(d)){
                        ans += " "+d+",";
                    }
                }
            }
        }
        return ans;
    }
}