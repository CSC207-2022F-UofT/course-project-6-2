package usecases.sellerusecases;

import entities.Drink;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * This use case is used to update the info of drink when the seller add drink, modify drink or delete drink.
 */
public class SellerModifyDrink {
    private static Drink searchedDrink;

    // Keep track of the drink that the seller searched for modify.
    public static Drink getSearchedDrink() {
        return searchedDrink;
    }

    /**
     * Check if the drink name that seller entered is included in the current login seller's drink list.
     * @param name The drink name that the seller has input to modify.
     * @return if the drink is included in the seller's drink list.
     */
    public Boolean drinkExist(String name) {
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        if (allDrinks == null) return false;
        return allDrinks.get(name) != null;
    }

    /**
     * Get the drink that the seller wants to modify.
     * @param name The drink name that the seller has input to modify.
     * @return The drink object that the seller searched.
     */
    public Drink searchedDrinkToModify(String name){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        searchedDrink = allDrinks.get(name);
        return searchedDrink;
    }

    /**
     * Modified the drink with the new attribute.
     * @param name The modified drink name.
     * @param price The modified drink price.
     * @param description The modified description.
     * @param ingredient The modified ingredient.
     * @param volume The modified volume.
     * @param productionData The modified production date.
     * @param expirationDate The modified expiration date.
     * @param discount The modified discount.
     */
    public void modifyDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount) {
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
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
    }

    /**
     * Add a new drink to the database according the attributes that the seller entered.
     * @param name The drink name for the new drink.
     * @param price The price for the new drink.
     * @param description The description for the new drink.
     * @param ingredient The ingredient for the new drink.
     * @param volume The volume for the new drink.
     * @param productionData The production date for the new drink.
     * @param expirationDate The expiration date for the new drink.
     * @param discount The discount for the new drink.
     */
    public void addDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        currentDrink.setStoreName(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        DrinkRuntimeDataBase.getDrinks().computeIfAbsent(UserRuntimeDataBase.getCurrentSeller().getStoreName(), k -> new HashMap<>());

        DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName()).put(name, currentDrink);
        new ModifyDrink().modifyDrink(null, currentDrink);
    }

    /**
     * Updata the database with the deleted drink disappeared.
     * @param drink The drink object the seller wants to delete.
     */
    public void deleteDrink(Drink drink){
        // Delete drink from RTDB
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        allDrinks.remove(drink.getName());

        // Delete one drink from seller drink items
        new ModifyDrink().modifyDrink(drink, null);
    }
}

