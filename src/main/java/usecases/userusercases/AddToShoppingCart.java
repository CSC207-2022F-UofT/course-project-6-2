package usecases.userusercases;

import entities.Drink;
import entities.ShoppingCart;
import usecases.drinkusecases.DrinkRuntimeDataBase;

import java.util.HashMap;

public class AddToShoppingCart {

    public static void addToShoppingCart(String drinkName, String storeName, Integer quantity){
        HashMap<String, Drink> allDrinks = DrinkRuntimeDataBase.getDrinks().get(storeName);
        Drink drink = allDrinks.get(drinkName);
        float newPrice = drink.getPrice() * quantity + UserRuntimeDataBase.currentCustomer.getShoppingCart().getTotalPrize();
        HashMap<Drink, Integer> drinkSet = new HashMap<>();
        drinkSet.put(drink, quantity);
        ShoppingCart currentShoppingCart = UserRuntimeDataBase.currentCustomer.getShoppingCart();
        currentShoppingCart.setTotalPrize(newPrice);
        currentShoppingCart.addItem(drink, quantity);
    }

}
