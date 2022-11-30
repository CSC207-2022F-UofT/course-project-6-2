package usecases.orderusecases;

import entities.Drink;

import java.util.ArrayList;

import java.util.HashMap;

public class GetWarningMessage {
    public String getWarningMessage(HashMap<Drink, Integer> itemList){
        ArrayList<String> dang = new ArrayList<>();
        /*The possible harmful ingredients, including five allergens and alcohol.*/
        dang.add("egg");
        dang.add("milk");
        dang.add("peanut");
        dang.add("soybean");
        dang.add("wheat");
        dang.add("alcohol");
        StringBuilder ans = new StringBuilder("Drinks in shopping cart contains");

        /*extract all drinks in HashMap*/
        ArrayList<Drink> cart_items = new ArrayList<>(itemList.keySet());
        /*return the harmful ingredients in drinks in HashMap*/

        for (Drink drink : cart_items){
            String lowercase_ingredient = drink.getIngredient().toLowerCase();
            int no = 0;
            for(String d: dang){
                if (lowercase_ingredient.contains(d)){
                    if (!ans.toString().contains(d)){
                        ans.append(" ").append(d).append(" ");
                        no += 1;
                    }
                }
            }
            if (no == 0){
                ans.append(" no common allergens");
            }
        }
        return ans.toString();
    }
}