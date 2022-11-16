package ShoppingCart;

import UI.Button;
import UI.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartView implements ActionListener {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    public static void main(String[] args) {

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cart");
        frame.add(panel);
        panel.setLayout(null);

        Button addQuantity = new Button();
        addQuantity.createButton(frame,"+", 300,100,50,20);

        Button minusQuantity = new Button();
        minusQuantity.createButton(frame,"-",200,100,50,20);

        Label shoppingCart = new Label();
        shoppingCart.createLabel(frame,"Shopping Cart", Color.BLACK,45, 50, 150,
                20);

        Label quantity = new Label();
        quantity.createLabel(frame, "1", Color.BLACK, 275, 100, 50, 20);

        Label product = new Label();
        product.createLabel(frame, "Product", Color.BLACK, 45, 100, 50, 20);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
