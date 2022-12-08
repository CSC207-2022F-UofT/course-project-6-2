package screens.sellerscreens;

import controllers.AddModifyDrinkController;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextVerticalPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * The add drink screen that prompt the seller to enter all the attribute of the new drink.
 */
public class AddDrinkScreen extends JFrame implements ActionListener {
    private final JFrame frame = new JFrame();
    private final Button addDrinkButton = new Button();
    private final Button cancelButton = new Button();
    private final JTextField drinkNameField = new JTextField(15); //The drink name entered
    private final JTextField drinkPriceField = new JTextField(15); //The drink price entered
    private final JTextField drinkDescriptionField = new JTextField(15); //The description entered
    private final JTextField drinkIngredientField = new JTextField(15); //The ingredient entered
    private final JTextField drinkVolumeField = new JTextField(15); //The volume entered
    private final JTextField drinkProductionField = new JTextField(15); //The production date entered
    private final JTextField drinkExpirationField = new JTextField(15); //The expiration date entered
    private final JTextField drinkDiscountField = new JTextField(15); //The drink discount entered

    public AddDrinkScreen() {
        // Basic setups
        frame.setSize(500, 520);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("add drink");
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

        addDrinkButton.createButton(panel, "add", 135, 430, 100, 30);
        addDrinkButton.addActionListener(this);

        cancelButton.createButton(panel, "cancel", 255, 430, 100, 30);
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
        String volume =drinkVolumeField.getText();
        String productionDate = drinkProductionField.getText();
        String expirationDate = drinkExpirationField.getText();
        String discount = drinkDiscountField.getText();

        if(e.getSource() == cancelButton.button){
            new SellerMainScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == addDrinkButton.button){
            String addDrinkResult = new AddModifyDrinkController(name, price, description, ingredient,
                    volume, productionDate, expirationDate, discount).addDrink();
            if (Objects.equals(addDrinkResult, "Success")) {
                new SellerMainScreen();
                frame.setVisible(false);
            }
        }
    }
}
