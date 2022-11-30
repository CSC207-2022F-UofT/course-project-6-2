package screens.sellerscreens;

import entities.users.Seller;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextPanel;
import usecases.sellerusecases.SellerModifyDrink;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddDrinkScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button addDrinkButton = new Button();
    Button cancelButton = new Button();

    JTextField drinkNameField = new JTextField(15); //The drink name entered
    JTextField drinkPriceField = new JTextField(15); //The drink price entered
    JTextField drinkDescriptionField = new JTextField(15); //The description entered
    JTextField drinkIngredientField = new JTextField(15); //The ingredient entered
    JTextField drinkVolumeField = new JTextField(15); //The volume entered
    JTextField drinkProductionField = new JTextField(15); //The production date entered
    JTextField drinkExpirationField = new JTextField(15); //The expiration date entered
    JTextField drinkDiscountField = new JTextField(15); //The drink discount entered


    public AddDrinkScreen() {
        // Basic setups
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("add drink");
        frame.setResizable(false);

        //Adding the eight textFields and two buttons to the panel.
        JPanel panel = new JPanel();

        LabelTextPanel drinkNamePanel = new LabelTextPanel(new JLabel("Name: "), drinkNameField);
        drinkNamePanel.setBounds(244, 270, 300, 40);
        panel.add(drinkNamePanel);

        LabelTextPanel drinkPricePanel =  new LabelTextPanel(new JLabel("Price: "), drinkPriceField);
        drinkPricePanel.setBounds(270, 320, 280, 40);
        panel.add(drinkPricePanel);

        LabelTextPanel drinkDescriptionPanel = new LabelTextPanel(new JLabel("Description: "), drinkDescriptionField);
        drinkDescriptionPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkDescriptionPanel);

        LabelTextPanel drinkIngredientPanel = new LabelTextPanel(new JLabel("Ingredient: "), drinkIngredientField);
        drinkIngredientPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkIngredientPanel);

        LabelTextPanel drinkVolumePanel = new LabelTextPanel(new JLabel("Volume: "), drinkVolumeField);
        drinkVolumePanel.setBounds(244, 270, 300, 40);
        panel.add(drinkVolumePanel);

        LabelTextPanel drinkProductionPanel = new LabelTextPanel(new JLabel("Production Date(e.g. 2020-04-11): "), drinkProductionField);
        drinkProductionPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkProductionPanel);

        LabelTextPanel drinkExpirationPanel = new LabelTextPanel(new JLabel("Expiration Date(e.g. 2021-05-11): "), drinkExpirationField);
        drinkExpirationPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkExpirationPanel);

        LabelTextPanel drinkDiscountPanel = new LabelTextPanel(new JLabel("Discount(e.g. 0.8[20% off]): "), drinkDiscountField);
        drinkDiscountPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkDiscountPanel);

        addDrinkButton.createButton(panel, "add", 325, 450, 150, 40);
        addDrinkButton.addActionListener(this);

        cancelButton.createButton(panel, "cancel", 325, 450, 150, 40);
        cancelButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == cancelButton.button){
            new SellerMainScreen();
            frame.setVisible(false);
            return;
        }

        String name = drinkNameField.getText();
        String price = drinkPriceField.getText();
        String description = drinkDescriptionField.getText();
        String ingredient = drinkIngredientField.getText();
        String volume = drinkVolumeField.getText();
        String productionDate = drinkProductionField.getText();
        String expirationDate = drinkExpirationField.getText();
        String discount = drinkDiscountField.getText();

        SellerModifyDrink add = new SellerModifyDrink();
        Seller curSeller = UserRuntimeDataBase.getCurrentSeller();

        //Change the format of the two date.
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date production = null;
        try {
            production = format.parse(productionDate);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        Date expiration = null;
        try {
            expiration = format.parse(expirationDate);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }

        if(e.getSource() == cancelButton.button){
            new SellerMainScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == addDrinkButton.button){
            add.addDrink(name, Float.valueOf(price), description, ingredient, Integer.valueOf(volume), production, expiration, Float.valueOf(discount));
            new SellerMainScreen();
            frame.setVisible(false);
        }
    }
}
