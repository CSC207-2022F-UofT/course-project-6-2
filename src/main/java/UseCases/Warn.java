package UseCases;

import Entities.Drink;

import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;

public class Warn {

    public String warnwhat(HashMap<Drink, Integer> itemList){
        ArrayList<Drink> cart_items = new ArrayList<>();
        ArrayList<String> dang = new ArrayList<>();
        /*The possible harmful ingredients, including five allergens and alcohol.*/
        dang.add("egg");
        dang.add("milk");
        dang.add("peanut");
        dang.add("soybean");
        dang.add("wheat");
        dang.add("alcohol");
        String ans = "Drinks in shopping cart contains";
        /*extract all drinks in HashMap*/
        for(Drink key: itemList.keySet()){
            cart_items.add(key);
        }
        /*return the harmful ingredients in drinks in HashMap*/
        for (Drink drink : cart_items){
            String lowercase_ingredient = drink.getIngredient().toLowerCase();
            for(String d: dang){
                int no = 0;
                if (lowercase_ingredient.contains(d)){
                    if (!ans.contains(d)){
                        ans += " "+d+" ";
                        no += 1;
                    }
                }
                if (no == 0){
                    ans += "nothing dangerous";
                }
            }
        }
        return ans;
    }
}