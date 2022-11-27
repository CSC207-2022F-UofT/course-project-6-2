package UseCases.UserUseCases;

import Entities.Drink;
import Entities.ShoppingCart;
import UseCases.DrinkUseCases.DrinkRuntimeDataBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddToShoppingCart {

    public static void addToShoppingCart(String drinkName, String storeName, int quantity){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(storeName);
        Drink drink = allDrinks.get(drinkName);
        float newPrice = drink.getPrice() * quantity + UserRuntimeDataBase.currentCustomer.shoppingCart.totalPrize;
        HashMap<Drink, Integer> drinkSet = new HashMap<>();
        drinkSet.put(drink, quantity);
        ShoppingCart currentShoppingCart = UserRuntimeDataBase.currentCustomer.getShoppingCart();
        currentShoppingCart.setTotalPrize(newPrice);
        currentShoppingCart.addItem(drink, quantity);
    }

}
