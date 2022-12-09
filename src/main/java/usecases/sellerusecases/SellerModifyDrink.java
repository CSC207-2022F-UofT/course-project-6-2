package usecases.sellerusecases;

import entities.Drink;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Date;
import java.util.HashMap;
public class SellerModifyDrink {
    private static Drink searchedDrink;

    public static Drink getSearchedDrink() {
        return searchedDrink;
    }

    /**
     * Check if the drink exist in the seller's drink list.
     * @param name the drink name that seller wants to modify or delete
     * @return if the drink exist.
     */
    public Boolean drinkExist(String name) {
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        if (allDrinks == null) return false;
        return allDrinks.get(name) != null;
    }

    /**
     * Get the drink object that the seller wants to modify
     * @param name the drink name that seller wants to modify
     * @return searched drink object
     */
    public Drink searchedDrinkToModify(String name){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        searchedDrink = allDrinks.get(name);
        return searchedDrink;
    }

    /**
     * Modify the drink with the providing drink attribute.
     */
    public String modifyDrink(String name, float price, String description, String ingredient, int volume, Date productionDate, Date expirationDate, float discount) {
        if (price == -1.0f) {
            return "Price not float";
        } else if (volume == -1) {
            return "Volume not integer";
        } else if (productionDate == null) {
            return "Production not Date";
        } else if (expirationDate == null) {
            return "Expiration not Date";
        } else if (discount == -1.0f) {
            return "Discount not float";
        } else {
            Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionDate, expirationDate, discount);
            HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());

            // if seller modified the drink name
            if (!name.equals(searchedDrink.getName())){
                allDrinks.remove(searchedDrink.getName());
                allDrinks.put(name, currentDrink);
            } else {
                allDrinks.replace(name, currentDrink);
            }
            // need to modify the items(Arraylist of drink that the seller sell) attribute in Seller
            new ModifyDrink().modifyDrink(searchedDrink, currentDrink);
            return "Success";
        }
    }

    /**
     * Add the new drink with the providing drink attribute.
     */
    public String addDrink(String name, float price, String description, String ingredient, int volume, Date productionDate, Date expirationDate, float discount){
        if (price == -1.0f) {
            return "Price not float";
        } else if (volume == -1) {
           return "Volume not integer";
        } else if (productionDate == null) {
            return "Production not Date";
        } else if (expirationDate == null) {
            return "Expiration not Date";
        } else if (discount == -1.0f) {
            return "Discount not float";
        } else {
            Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionDate, expirationDate, discount);
            currentDrink.setStoreName(UserRuntimeDataBase.getCurrentSeller().getStoreName());
            DrinkRuntimeDataBase.getDrinks().computeIfAbsent(UserRuntimeDataBase.getCurrentSeller().getStoreName(), k -> new HashMap<>());

            DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName()).put(name, currentDrink);
            new ModifyDrink().modifyDrink(null, currentDrink);
            return "Success";
        }
    }

    /**
     * Delete the drink that seller wants to delete.
     * @param drink drink object that seller wants to delete.
     */
    public void deleteDrink(Drink drink){
        // Delete drink from RTDB
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        allDrinks.remove(drink.getName());

        // Delete one drink from seller drink items
        new ModifyDrink().modifyDrink(drink, null);
    }
}

