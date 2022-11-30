package screens.sellerscreens;

import entities.users.Seller;
import screens.swingcomponents.Button;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class SellerMainScreen extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    Button deleteDrinkButton = new Button();
    Button modifyDrinkButton = new Button();
    Button addDrinkButton = new Button();
    Button orderHistoryButton = new Button();
    Vector headers = new Vector();
    Vector data = new Vector();

    public SellerMainScreen() {
        // Basic setups for the Jtable.
        headers.add("drink name");
        headers.add("price");
        headers.add("description");
        headers.add("ingredient");
        headers.add("volume");
        headers.add("production Date");
        headers.add("expiration Date");
        headers.add("discount");

        //Get the phone number from login and extract the corresponding seller object.
        Seller seller = UserRuntimeDataBase.getCurrentSeller();

        if (seller.items != null) {
            for (int i = 0; i < seller.items.size(); i++) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String strProduction = format.format(seller.items.get(i).getProductionData());
                String strExpiration = format.format(seller.items.get(i).getExpirationDate());

                Vector line = new Vector();
                line.add(seller.items.get(i).getName());
                line.add(Float.toString(seller.items.get(i).getPrice()));
                line.add(seller.items.get(i).getDescription());
                line.add(seller.items.get(i).getIngredient());
                line.add(Integer.toString(seller.items.get(i).getVolume()));
                line.add(strProduction);
                line.add(strExpiration);
                line.add(Float.toString(seller.items.get(i).getDiscount()));
                data.add(line);
            }
        }

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Seller main page");
        frame.setResizable(false);

        //Setting up the two panels.
        JPanel panel = new JPanel();
        JTable orderTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        Container contentPane = frame.getContentPane();

        //Adding the two Buttons.
        addDrinkButton.createButton(panel, "Add Drink", 250, 400, 150, 40);
        addDrinkButton.addActionListener(this);

        modifyDrinkButton.createButton(panel, "Modify Drink", 100, 400, 150, 40);
        modifyDrinkButton.addActionListener(this);

        deleteDrinkButton.createButton(panel, "Delete Drink", 100, 400, 150, 40);
        deleteDrinkButton.addActionListener(this);

        orderHistoryButton.createButton(panel, "Order History", 550, 400, 150, 40);
        orderHistoryButton.addActionListener(this);

        //Adding the two panels to the contentPane.
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        //Action of the buttons.
        if(e.getSource() == deleteDrinkButton.button){
            new DeleteDrinkScreen();
            frame.setVisible(false);
         }

        if(e.getSource() == addDrinkButton.button){
            new AddDrinkScreen();
            frame.setVisible(false);
         }

        if(e.getSource() == modifyDrinkButton.button){
            new SearchModifyDrinkScreen();
            frame.setVisible(false);
        }

        if(e.getSource() == orderHistoryButton.button){
            new OrderStatusScreen();
            frame.setVisible(false);
        }

    }
    public static void main(String[] args){
        new SellerMainScreen();
    }
}
