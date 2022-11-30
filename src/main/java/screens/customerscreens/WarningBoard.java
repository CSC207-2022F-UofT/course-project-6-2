package screens.customerscreens;

import entities.ShoppingCart;
import screens.sellerscreens.SellerMainScreen;
import usecases.orderusecases.GetWarningMessage;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class WarningBoard extends JFrame {
    JPanel panel = new JPanel();
    JPanel bottom = new JPanel();
    JLabel warning = new JLabel();
    /*create a button to show the warning*/
    JButton button = new JButton("show warning");
    /*create a button to close the WarningBoard*/
    JButton close = new JButton("I Understand");
    GetWarningMessage w = new GetWarningMessage();
    ShoppingCart sc = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();

    public WarningBoard() {
        super();
        Container contentpane = getContentPane();
        panel.add(warning);
        bottom.add(button);
        bottom.add(close);
        contentpane.add(bottom, BorderLayout.SOUTH);
        contentpane.add(panel, BorderLayout.NORTH);
        warning.setOpaque(true);
        setTitle("Warning Board");
        setBounds(460, 300, 600, 120);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            /*Change JLabel to "Drinks in shopping cart contains what".*/
            public void actionPerformed(ActionEvent e) {
                warning.setText(w.getWarningMessage(sc.getItemList()));
            }
        });
        close.addActionListener(new ActionListener() {
            @Override
            /*exit.*/
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}