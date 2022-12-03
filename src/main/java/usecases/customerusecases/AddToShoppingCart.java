package usecases.customerusecases;

import entities.Drink;
import entities.ShoppingCart;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.HashMap;

public class AddToShoppingCart {
    public static void addToShoppingCart(Drink drink, Integer quantity){
        float newPrice = drink.getPrice() * quantity + UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().getTotalPrize();
        HashMap<Drink, Integer> drinkSet = new HashMap<>();
        drinkSet.put(drink, quantity);
        ShoppingCart currentShoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
        currentShoppingCart.setTotalPrize(newPrice);
        currentShoppingCart.addItem(drink, quantity);
    }

}
