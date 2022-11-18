package notification_window;

import shopping_cart.ShoppingCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static notification_window.Warn.warnwhat;


public class WarningBoard extends JFrame{
    public static void main(String[] args){
        JFrame w = new JFrame("Warning Board");
        w.setLayout(new FlowLayout(FlowLayout.LEFT));
        w.setBounds(460, 300, 300, 200);
        w.setVisible(true);

    }
    JTextField warning = new JTextField(20);
    public WarningBoard(){
        super();
        JPanel root = new JPanel();
        this.setContentPane(root);

        root.add(warning);
        JButton button = new JButton("show warning");
        root.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                warning.setText(warnwhat(ShoppingCart.getItemList()));
            }
        });
    }

}