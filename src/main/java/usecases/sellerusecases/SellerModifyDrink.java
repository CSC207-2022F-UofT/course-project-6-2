package usecases.sellerusecases;

import entities.Drink;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class SellerModifyDrink {
    private static Drink searchedDrink;

    public static Drink getSearchedDrink() {
        return searchedDrink;
    }

    public Boolean drinkExist(String name) {
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        if (allDrinks == null) return false;
        return allDrinks.get(name) != null;
    }

    public Drink searchedDrinkToModify(String name){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        searchedDrink = allDrinks.get(name);
        return searchedDrink;
    }

    public void modifyDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount) {
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        // if seller modified the drink name
        if (!Objects.equals(name, searchedDrink.getName())){
            allDrinks.remove(searchedDrink.getName());
            allDrinks.put(name, currentDrink);
        } else {
            allDrinks.replace(name, currentDrink);
        }
        // need to modify the items(Arraylist of drink that the seller sell) attribute in Seller
        new ModifyDrink().modifyDrink(searchedDrink, currentDrink);
    }

    public void addDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        currentDrink.setStoreName(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        DrinkRuntimeDataBase.getDrinks().computeIfAbsent(UserRuntimeDataBase.getCurrentSeller().getStoreName(), k -> new HashMap<>());

        DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName()).put(name, currentDrink);
        new ModifyDrink().modifyDrink(null, currentDrink);
    }

    public void deleteDrink(Drink drink){
        // Delete drink from RTDB
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.getCurrentSeller().getStoreName());
        allDrinks.remove(drink.getName());

        // Delete one drink from seller drink items
        new ModifyDrink().modifyDrink(drink, null);
    }
}

