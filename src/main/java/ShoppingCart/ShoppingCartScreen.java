package ShoppingCart;

import UI.ShoppingCartGrouping;
import UI.ScrollPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartScreen extends JFrame implements ActionListener {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    JButton addQuantity = new JButton("+");
    JButton minusQuantity = new JButton("-");
    JLabel quantity = new JLabel("1");
    //Label product = new Label();
    ScrollPane scrollPane = new ScrollPane();

    ShoppingCartGrouping productGroup = new ShoppingCartGrouping();
    public ShoppingCartScreen(){

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cart");
        frame.setResizable(false);

        scrollPane.createScrollPane(frame, panel);

        //initialize
        productGroup.createProductLabel(panel, addQuantity, minusQuantity, quantity);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addQuantity){
            int quantityCount = Integer.parseInt(quantity.getText());
            System.out.println(quantityCount);
            quantityCount += 1;
            quantity.setText(String.valueOf(quantityCount));
        }
    }
}
