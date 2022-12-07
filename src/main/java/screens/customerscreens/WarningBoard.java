package screens.customerscreens;

import entities.ShoppingCart;
import usecases.orderusecases.GetWarningMessage;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.*;

/**
 * The warning board is the interface to remind the warning ingredient when the customer wants to check out.
 */
public class WarningBoard extends JPanel {
    public WarningBoard() {

        // defining local variables
        JFrame jf = new JFrame();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JButton closeButton = new JButton("I Understand");

        //setting up frame
        jf.setTitle("Warning Board");
        jf.setBounds(460, 300, 500, 120);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setVisible(true);

        // set up panels
        // defining variables
        JLabel warning = new JLabel();
        top.add(warning);
        warning.setOpaque(true);
        bottom.add(closeButton);

        //set up contentpane
        jf.add(bottom, BorderLayout.SOUTH);
        jf.add(top, BorderLayout.NORTH);

        /*Change JLabel to "Drinks in shopping cart contains what".*/
        GetWarningMessage warningMessage = new GetWarningMessage();
        ShoppingCart shoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
        warning.setText(warningMessage.getWarningMessage(shoppingCart.getItemList()));

        /*exit.*/
        closeButton.addActionListener(e -> jf.dispose());
    }
}