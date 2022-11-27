package UseCases.UserUseCases;

import Entities.Drink;
import Entities.ShoppingCart;
import UseCases.DrinkUseCases.DrinkRuntimeDataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddToShoppingCart {

    public static void addToShoppingCart(String drinkName, String storeName, String quantity){
        for (Map.Entry<String, HashMap<String, Drink>> drink: DrinkRuntimeDataBase.getDrinks().entrySet()){
            if (drinkName == drink.getKey() && storeName == drink.getKey()){

            }
        }
    }

}
