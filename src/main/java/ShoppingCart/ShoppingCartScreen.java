package ShoppingCart;

import UI.Button;
import UI.NumberLabel;
import UI.ScrollPane;
import UI.WordLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartScreen extends JFrame implements ActionListener {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    Button addQuantity = new Button();
    Button minusQuantity = new Button();
    WordLabel shoppingCart = new WordLabel();
    NumberLabel quantity = new NumberLabel();
    WordLabel product = new WordLabel();
    ScrollPane scrollPane = new ScrollPane();
    public ShoppingCartScreen(){

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cart");
        frame.add(panel);



        addQuantity.createButton(panel,"+", 300,100,50,20);

        minusQuantity.createButton(panel,"-",200,100,50,20);

        shoppingCart.createLabel(panel,"Shopping Cart", Color.BLACK,45, 50, 150, 20);

        quantity.createLabel(panel, 1, Color.BLACK, 275, 100, 50, 20);

        product.createLabel(panel, "Product", Color.BLACK, 45, 100, 50, 20);

        //scrollPane.createScrollPane(frame);

        panel.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addQuantity){
            int quantityCount = Integer.parseInt(quantity.getLabel().getText());
            quantityCount += 1;
            System.out.println(quantityCount);
            quantity.setLabel(String.valueOf(quantityCount));
        }
    }
}
