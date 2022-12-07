package screens.sellerscreens;

import entities.Drink;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextVerticalPanel;
import usecases.sellerusecases.SellerModifyDrink;
import usecases.userinputboundary.DrinkInputBoundary;
import usecases.userresponsemodel.DrinkResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The modify drink screen display the current info for the drink that the seller has searched to modified, and the seller
 * can modify any attribute that he/she wants.
 */
public class ModifyDrinkScreen extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    private final SellerModifyDrink modify = new SellerModifyDrink();
    private final Drink currDrink = modify.getSearchedDrink();
    private final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private final String strProduction = format.format(currDrink.getProductionData());
    private final String strExpiration = format.format(currDrink.getExpirationDate());
    private final Button modifyDrinkButton = new Button();
    private final Button cancelButton = new Button();
    private final JTextField drinkNameField = new JTextField(currDrink.getName(), 15); //The drink name entered
    private final JTextField drinkPriceField = new JTextField(Float.toString(currDrink.getPrice()), 15); //The price entered
    private final JTextField drinkDescriptionField = new JTextField(currDrink.getDescription(), 15); //The description entered
    private final JTextField drinkIngredientField = new JTextField(currDrink.getIngredient(), 15); //The ingredient entered
    private final JTextField drinkVolumeField = new JTextField(Integer.toString(currDrink.getVolume()), 15); //The volume entered
    private final JTextField drinkProductionField = new JTextField(strProduction, 15); //The production date entered
    private final JTextField drinkExpirationField = new JTextField(strExpiration, 15); //The expiration date entered
    private final JTextField drinkDiscountField = new JTextField(Float.toString(currDrink.getDiscount()), 15); //The discount entered
    public ModifyDrinkScreen() {
        // Basic setups
        frame.setSize(500, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("modify drink");
        frame.setResizable(false);

        //Adding the eight textFields and two buttons to the panel.
        JPanel panel = new JPanel();
        panel.setLayout(null);

        LabelTextVerticalPanel drinkNamePanel = new LabelTextVerticalPanel();
        drinkNamePanel.createLabelTextPanel(panel, new JLabel("Name: "), drinkNameField,
                100, 10, 300, 30);

        LabelTextVerticalPanel drinkPricePanel =  new LabelTextVerticalPanel();
        drinkPricePanel.createLabelTextPanel(panel, new JLabel("Price: "), drinkPriceField,
                100, 60, 300, 30);

        LabelTextVerticalPanel drinkDescriptionPanel = new LabelTextVerticalPanel();
        drinkDescriptionPanel.createLabelTextPanel(panel, new JLabel("Description: "), drinkDescriptionField,
                100, 110, 300, 30);

        LabelTextVerticalPanel drinkIngredientPanel = new LabelTextVerticalPanel();
        drinkIngredientPanel.createLabelTextPanel(panel, new JLabel("Ingredient: "), drinkIngredientField,
                100, 160, 300, 30);

        LabelTextVerticalPanel drinkVolumePanel = new LabelTextVerticalPanel();
        drinkVolumePanel.createLabelTextPanel(panel, new JLabel("Volume: "), drinkVolumeField,
                100, 210, 300, 30);

        LabelTextVerticalPanel drinkProductionPanel = new LabelTextVerticalPanel();
        drinkProductionPanel.createLabelTextPanel(panel, new JLabel("Production Date(e.g. 2020-04-11): "), drinkProductionField,
                100, 260, 300, 30);

        LabelTextVerticalPanel drinkExpirationPanel = new LabelTextVerticalPanel();
        drinkExpirationPanel.createLabelTextPanel(panel, new JLabel("Expiration Date(e.g. 2021-05-11): "), drinkExpirationField,
                100, 310, 300, 30);

        LabelTextVerticalPanel drinkDiscountPanel = new LabelTextVerticalPanel();
        drinkDiscountPanel.createLabelTextPanel(panel, new JLabel("Discount(e.g. 0.8[20% off]): "), drinkDiscountField,
                100, 360, 300, 30);

        modifyDrinkButton.createButton(panel, "modify", 135, 430, 100, 30);
        modifyDrinkButton.addActionListener(this);

        cancelButton.createButton(panel, "cancel", 255, 430, 100, 30);
        cancelButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cancelButton.button){
            new SearchModifyDrinkScreen();
            frame.setVisible(false);
        }

        String name = drinkNameField.getText();
        Float price = new DrinkInputBoundary().getPrice(drinkPriceField.getText());
        String description = drinkDescriptionField.getText();
        String ingredient = drinkIngredientField.getText();
        Integer volume = new DrinkInputBoundary().getVolume(drinkVolumeField.getText());
        Date productionDate = new DrinkInputBoundary().getDate(drinkProductionField.getText());
        Date expirationDate = new DrinkInputBoundary().getDate(drinkExpirationField.getText());
        Float discount =  new DrinkInputBoundary().getDiscount(drinkDiscountField.getText());

        if (e.getSource() == modifyDrinkButton.button){
            new DrinkResponseModel(price, volume, productionDate, expirationDate, discount);
            if (price != -1.0f && volume != -1 && productionDate != null && expirationDate != null
                    && discount != -1.0f) {
                modify.modifyDrink(name, price, description, ingredient, volume, productionDate, expirationDate, discount);
                new SellerMainScreen();
                frame.setVisible(false);
            }
        }
    }
}