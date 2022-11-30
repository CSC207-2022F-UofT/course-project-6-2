package usecases.shoppingcartusecases;

import entities.Drink;
import screens.customerscreens.CustomerMainScreen;
import screens.customerscreens.ShoppingCartPanel;
import usecases.customerusecases.AddToOrderHistory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class CheckoutButtonActionPerformed {

    public static void checkoutButtonActionPerformed(ActionEvent e, JButton checkoutButton, Vector data, HashMap<Drink, Integer> drinks,
                                                      JFrame frame, ArrayList<Float> totalAmount, Float total) {
        if (e.getSource() == checkoutButton) {

            AddToOrderHistory.addToOrderHistory(drinks, total);
            new CustomerMainScreen();
            frame.setVisible(false);
            data.removeAllElements();
            totalAmount.clear();
            ShoppingCartPanel.totalAmountLabel.setText("$0.00");

            JOptionPane.showMessageDialog(null,
                    "You have checked out! You can go to your order history to check your items :)");
        }
    }
}
