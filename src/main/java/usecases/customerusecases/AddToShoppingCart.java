package usecases.customerusecases;

import entities.Drink;
import entities.ShoppingCart;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.HashMap;

public class AddToShoppingCart {
    public static void addToShoppingCart(String drinkName, String storeName, Integer quantity){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(storeName);
        Drink drink = allDrinks.get(drinkName);
        float newPrice = drink.getPrice() * quantity + UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getTotalPrize();
        HashMap<Drink, Integer> drinkSet = new HashMap<>();
        drinkSet.put(drink, quantity);
        ShoppingCart currentShoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
        currentShoppingCart.setTotalPrize(newPrice);
        currentShoppingCart.addItem(drink, quantity);
    }

}
