package Screens.SellerScreens;

import Entities.Drink;
import Entities.Users.Seller;
import Screens.Button;
import Screens.LabelTextPanel;
import UseCases.UserUseCases.SellerModifyDrink;
import UseCases.UserUseCases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifyDrinkScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    UseCases.UserUseCases.SellerModifyDrink modify = new SellerModifyDrink();
    Drink currDrink = modify.getSearchedDrink();
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String strProduction = format.format(currDrink.getProductionData());
    String strExpiration = format.format(currDrink.getExpirationDate());

    Button modifyDrinkButton = new Button();
    Button cancelButton = new Button();

    JTextField drinkNameField = new JTextField(currDrink.getName(), 15); //The order number entered
    JTextField drinkPriceField = new JTextField(Float.toString(currDrink.getPrice()), 15); //The order number entered
    JTextField drinkDescriptionField = new JTextField(currDrink.getDescription(), 15); //The order number entered
    JTextField drinkIngredientField = new JTextField(currDrink.getIngredient(), 15); //The order number entered
    JTextField drinkVolumeField = new JTextField(Integer.toString(currDrink.getVolume()), 15); //The order number entered
    JTextField drinkProductionField = new JTextField(strProduction, 15); //The order number entered
    JTextField drinkExpirationField = new JTextField(strExpiration, 15); //The order number entered
    JTextField drinkDiscountField = new JTextField(Float.toString(currDrink.getDiscount()), 15); //The order number entered


    public ModifyDrinkScreen() {
        // Basic setups
        frame.setSize(400, 425);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("modify drink");
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

        LabelTextPanel drinkProductionPanel = new LabelTextPanel(new JLabel("Production Date: "), drinkProductionField);
        drinkProductionPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkProductionPanel);

        LabelTextPanel drinkExpirationPanel = new LabelTextPanel(new JLabel("Expiration Date: "), drinkExpirationField);
        drinkExpirationPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkExpirationPanel);

        LabelTextPanel drinkDiscountPanel = new LabelTextPanel(new JLabel("Discount: "), drinkDiscountField);
        drinkDiscountPanel.setBounds(244, 270, 300, 40);
        panel.add(drinkDiscountPanel);

        modifyDrinkButton.createButton(panel, "modify", 325, 450, 150, 40);
        modifyDrinkButton.addActionListener(this);

        cancelButton.createButton(panel, "cancel", 325, 450, 150, 40);
        cancelButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String name = drinkNameField.getText();
        String price = drinkPriceField.getText();
        String description = drinkDescriptionField.getText();
        String ingredient = drinkIngredientField.getText();
        String volume = drinkVolumeField.getText();
        String productionDate = drinkProductionField.getText();
        String expirationDate = drinkExpirationField.getText();
        String discount = drinkDiscountField.getText();

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
            new SearchModifyDrinkScreen();
            frame.setVisible(false);
        }

        if (e.getSource() == modifyDrinkButton.button){
            modify.modifyDrink(name, Float.valueOf(price), description, ingredient, Integer.valueOf(volume), production, expiration,Float.valueOf(discount));
            new SellerMainScreen();
            frame.setVisible(false);
        }
    }
}