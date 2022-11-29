package screens;

import usecases.Warn;
import entities.ShoppingCart;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningBoard extends JFrame{
    JPanel panel = new JPanel();
    JLabel warning = new JLabel();
    /*create a button to show the warning*/
    JButton button = new JButton("show warning");
    /*create a button to close the WarningBoard*/
    JButton close = new JButton("I Understand");
    Warn w = new Warn();
    ShoppingCart sc = UserRuntimeDataBase.getCurrentCustomer().getShoppingCart();
    public WarningBoard() {
        super();
        Container contentpane = getContentPane();
        panel.add(warning);
        panel.add(button);
        panel.add(close);
        contentpane.add(panel);
        contentpane.setBackground(Color.red);
        warning.setBackground(Color.yellow);
        warning.setOpaque(true);
        setTitle("Warning Board");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBounds(460, 300, 800, 100);
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
                System.exit(0);
            }
        });
    }
}