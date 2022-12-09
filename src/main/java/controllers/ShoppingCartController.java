package controllers;

import entities.Drink;
import usecases.customerusecases.AddToShoppingCart;
import usecases.customerusecases.MinusFromShoppingCart;
import usecases.shoppingcartusecases.AddQuantityButtonActionPerformed;
import usecases.shoppingcartusecases.CheckoutButtonActionPerformed;
import usecases.shoppingcartusecases.MinusQuantityButtonActionPerformed;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class ShoppingCartController {
    private final Vector<Vector<String >> data;
    private final Vector<String> headers;
    private final HashMap<Drink, Integer> drinks;
    private final Drink selectedDrink;
    private final ArrayList<Float> totalAmount;
    private final Float total;
    private final JFrame frame;
    private final JTable table;

    /**
     * @param data The data in the JTable
     * @param headers The header of the JTable
     * @param drinks The drinks in the shopping cart
     * @param totalAmount The total amount of the drinks
     * @param total The total price of the drinks
     * @param frame The JFrame
     * @param table The JTable
     */

    public ShoppingCartController(Vector<Vector<String>> data, Vector<String> headers, HashMap<Drink, Integer> drinks, Drink selectedDrink,
                                  ArrayList<Float> totalAmount, Float total, JFrame frame, JTable table) {
        this.data = data;
        this.headers = headers;
        this.drinks = drinks;
        this.selectedDrink = selectedDrink;
        this.totalAmount = totalAmount;
        this.total = total;
        this.frame = frame;
        this.table = table;
    }

    public float addItem() {
        AddToShoppingCart.addToShoppingCart(selectedDrink, 1);
        return AddQuantityButtonActionPerformed.addQuantityActionPerformed(headers, table, totalAmount, total);
    }
    public float minusItem() {
        MinusFromShoppingCart.minusFromShoppingCart(selectedDrink, 1);
        return MinusQuantityButtonActionPerformed.minusQuantityActionPerformed(headers ,table, totalAmount, total);
    }
    public void checkOut() {
        CheckoutButtonActionPerformed.checkoutButtonActionPerformed(data, drinks, totalAmount, total, frame);
    }
}
