package OrderHistory;

import UI.Button;
import UI.Label;
import UI.TextField;

import javax.swing.*;
import java.awt.*;

public class OrderHistoryView {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    public static void main(String[] args) {

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Order History");
        frame.add(panel);
        panel.setLayout(null);

        TextField orderNumber = new TextField();
        orderNumber.createTextField(frame,25, 25, 225, 30);

        Button search = new Button();
        search.createButton(frame,"Search", 275,25,75,30);

        Button nextPage = new Button();
        nextPage.createButton(frame,"Next Page",500,500,125,30);

        Label order1 = new Label();
        order1.createLabel(frame,"Order 1", Color.BLACK,45, 75, 100,30);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}