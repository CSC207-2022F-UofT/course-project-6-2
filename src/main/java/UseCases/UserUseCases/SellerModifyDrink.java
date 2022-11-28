package UseCases.UserUseCases;

import Entities.Drink;
import UseCases.DrinkUseCases.DrinkRuntimeDataBase;

import java.util.Date;
import java.util.HashMap;

public class SellerModifyDrink {
    private static Drink searchedDrink;

    public static Drink getSearchedDrink() {
        return searchedDrink;
    }

    public Drink searchedDrinkToModify(String name){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.currentSeller.getStoreName());
        searchedDrink = allDrinks.get(name);
        return searchedDrink;
    }

    public void modifyDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount) {
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.currentSeller.getStoreName());
        // if seller modified the drink name
        if (name != searchedDrink.getName()){
            allDrinks.remove(searchedDrink.getName());
            allDrinks.put(name, currentDrink);
        } else {
            allDrinks.replace(name, currentDrink);
        }
        // need to modify the items(Arraylist of drink that the seller sell) attribute in Seller
        UserRuntimeDataBase.currentSeller.modifyDrink(searchedDrink, currentDrink);
    }

    public void addDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        currentDrink.setStoreName(UserRuntimeDataBase.currentSeller.getStoreName());
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.currentSeller.getStoreName());
        allDrinks.put(name, currentDrink);
        UserRuntimeDataBase.currentSeller.modifyDrink(null, currentDrink);
    }

    public void deleteDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(UserRuntimeDataBase.currentSeller.getStoreName());
        allDrinks.remove(name);
        UserRuntimeDataBase.currentSeller.modifyDrink(currentDrink, null);
    }


}

