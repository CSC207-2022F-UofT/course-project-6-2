package usecases.orderusecases;

import entities.Drink;

import java.util.ArrayList;

import java.util.HashMap;

public class GetWarningMessage {
    public String getWarningMessage(HashMap<Drink, Integer> itemList){
        ArrayList<String> allergens = new ArrayList<>();
        /*The possible harmful ingredients, including five allergens and alcohol.*/
        allergens.add("egg");
        allergens.add("milk");
        allergens.add("peanut");
        allergens.add("soybean");
        allergens.add("wheat");
        allergens.add("alcohol");
        StringBuilder ans = new StringBuilder("Drinks in shopping cart contains");

        /*extract all drinks in HashMap*/
        ArrayList<Drink> cart_items = new ArrayList<>(itemList.keySet());
        /*return the harmful ingredients in drinks in HashMap*/
        int numOfAllergens = 0;
        for (Drink drink : cart_items){
            String lowercase_ingredient = drink.getIngredient().toLowerCase();
            for(String d: allergens){
                if (lowercase_ingredient.contains(d)){
                    if (!ans.toString().contains(d)){
                        ans.append(" ").append(d).append(",");
                        numOfAllergens += 1;
                    }
                }
            }
        }
        if (numOfAllergens == 0){
            ans.append(" no common allergens,");
        }
        ans.setCharAt(ans.length() - 1, ' ');
        return ans.toString();
    }
}
