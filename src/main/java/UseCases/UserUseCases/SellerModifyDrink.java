package UseCases.UserUseCases;

import Entities.Drink;
import UseCases.DrinkRuntimeDataBase;

import java.util.Date;

public class SellerModifyDrink {
    private static String searchedDrinkName;

    public Drink searchDrinkToModify(String name){
        searchedDrinkName = name;
        return DrinkRuntimeDataBase.drinks.get(name);
    }

    public void modifyDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount, String storeName) {
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount, storeName);
        Drink oldDink = DrinkRuntimeDataBase.drinks.get(searchedDrinkName);
        // if seller modified the drink name
        if (name != searchedDrinkName){
            DrinkRuntimeDataBase.drinks.remove(name);
            DrinkRuntimeDataBase.drinks.put(name, currentDrink);
        } else {
            DrinkRuntimeDataBase.drinks.replace(name, currentDrink);
        }
        // need to modify the items(Arraylist of drink that the seller sell) attribute in Seller
        UserRuntimeDataBase.currentSeller.modifyDrink(oldDink, currentDrink);
    }

    public void addDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount, String storeName){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount, storeName);
        DrinkRuntimeDataBase.drinks.put(name, currentDrink);
        UserRuntimeDataBase.currentSeller.modifyDrink(null, currentDrink);
    }

    public void deleteDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount, String storeName){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount, storeName);
        DrinkRuntimeDataBase.drinks.remove(name);
        UserRuntimeDataBase.currentSeller.modifyDrink(currentDrink, null);
    }


}

