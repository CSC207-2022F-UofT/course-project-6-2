package usecases.shoppingcartusecases;

import entities.Drink;
import presentor.ResponsePresenter;
import screens.customerscreens.ShoppingCartPanel;
import usecases.customerusecases.AddToOrderHistory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class CheckoutButtonActionPerformed {

    public static void checkoutButtonActionPerformed(Vector<Vector<String >> data, HashMap<Drink, Integer> drinks,
                                                      ArrayList<Float> totalAmount, Float total, JFrame frame) {
        AddToOrderHistory.addToOrderHistory(drinks, total);
        frame.setVisible(false);
        drinks.clear();
        data.removeAllElements();
        totalAmount.clear();
        ShoppingCartPanel.totalAmountLabel.setText("$0.00");

        new ResponsePresenter(
                "You have checked out! You can go to your order history to check your items :)"
        ).messagePresenter();
    }
}
