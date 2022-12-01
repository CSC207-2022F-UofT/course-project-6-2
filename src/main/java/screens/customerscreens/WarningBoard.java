package screens.customerscreens;

import entities.ShoppingCart;
import usecases.orderusecases.GetWarningMessage;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningBoard extends JFrame {

    // defining variables
    private final JLabel warning = new JLabel();
    private final GetWarningMessage warningMessage = new GetWarningMessage();
    private final ShoppingCart shoppingCart = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();

    public WarningBoard() {

        // defining local variables
        Container contentpane = getContentPane();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JButton showWarning = new JButton("Show Warning");
        JButton closeButton = new JButton("I Understand");

        //setting up frame
        setTitle("Warning Board");
        setBounds(460, 300, 500, 120);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // set up panels
        top.add(warning);
        warning.setOpaque(true);
        bottom.add(showWarning);
        bottom.add(closeButton);

        //set up contentpane
        contentpane.add(bottom, BorderLayout.SOUTH);
        contentpane.add(top, BorderLayout.NORTH);

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
                dispose();
            }
        });
    }
}