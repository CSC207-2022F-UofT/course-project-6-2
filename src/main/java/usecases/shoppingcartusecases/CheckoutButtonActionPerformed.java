package usecases.shoppingcartusecases;

import entities.Drink;
import entities.Order;
import entities.users.User;
import screens.customerscreens.CustomerMainScreen;
import screens.customerscreens.ShoppingCartPanel;
import usecases.customerusecases.AddToOrderHistory;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Vector;

public class CheckoutButtonActionPerformed {

    public static void checkoutButtonActionPerformed(ActionEvent e, JButton checkoutButton, Vector data, HashMap<Drink, Integer> drinks,
                                                     JFrame frame, JLabel totalAmountLabel, DecimalFormat df) {
        if (e.getSource() == checkoutButton) {

            AddToOrderHistory.addToOrderHistory(drinks);
            frame.setVisible(false);
            new CustomerMainScreen();
            data.removeAllElements();
            Float total = 0.0f;
            totalAmountLabel.setText("$" + df.format(total));

            JOptionPane.showMessageDialog(null,
                    "You have checked out! You can go to your order history to check your items :)");
        }
    }
}
