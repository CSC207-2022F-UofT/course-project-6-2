package screens.customerscreens;

import entities.ShoppingCart;
import usecases.orderusecases.GetWarningMessage;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningBoard extends JPanel {

    // defining variables
    private final JLabel warning = new JLabel();
    private final GetWarningMessage warningMessage = new GetWarningMessage();
    private final ShoppingCart shoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();

    public WarningBoard() {

        // defining local variables
        JFrame jf = new JFrame();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JButton showWarning = new JButton("Show Warning");
        JButton closeButton = new JButton("I Understand");

        //setting up frame
        jf.setTitle("Warning Board");
        jf.setBounds(460, 300, 500, 120);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);

        // set up panels
        top.add(warning);
        warning.setOpaque(true);
        bottom.add(showWarning);
        bottom.add(closeButton);

        //set up contentpane
        jf.add(bottom, BorderLayout.SOUTH);
        jf.add(top, BorderLayout.NORTH);

        showWarning.addActionListener(new ActionListener() {
            @Override
            /*Change JLabel to "Drinks in shopping cart contains what".*/
            public void actionPerformed(ActionEvent e) {
                warning.setText(warningMessage.getWarningMessage(shoppingCart.getItemList()));
            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            /*exit.*/
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
            }
        });
    }
}