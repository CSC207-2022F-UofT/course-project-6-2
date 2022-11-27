package UseCases.UserUseCases;

import Entities.Drink;
import UseCases.DrinkUseCases.DrinkRuntimeDataBase;

import java.util.Date;

public class SellerModifyDrink {
    private static String searchedDrinkName;

    public Drink searchDrinkToModify(String name){
        searchedDrinkName = name;
        return DrinkRuntimeDataBase.getDrinks().get(name);
    }

    public void modifyDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount, String storeName) {
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        Drink oldDink = DrinkRuntimeDataBase.getDrinks().get(searchedDrinkName);
        // if seller modified the drink name
        if (name != searchedDrinkName){
            DrinkRuntimeDataBase.getDrinks().remove(name);
            DrinkRuntimeDataBase.getDrinks().put(name, currentDrink);
        } else {
            DrinkRuntimeDataBase.getDrinks().replace(name, currentDrink);
        }
        // need to modify the items(Arraylist of drink that the seller sell) attribute in Seller
        UserRuntimeDataBase.currentSeller.modifyDrink(oldDink, currentDrink);
    }

    public void addDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount, String storeName){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        DrinkRuntimeDataBase.getDrinks().put(name, currentDrink);
        UserRuntimeDataBase.currentSeller.modifyDrink(null, currentDrink);
    }

    public void deleteDrink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount, String storeName){
        Drink currentDrink = new Drink(name, price, description, ingredient, volume, productionData, expirationDate, discount);
        DrinkRuntimeDataBase.getDrinks().remove(name);
        UserRuntimeDataBase.currentSeller.modifyDrink(currentDrink, null);
    }


}

