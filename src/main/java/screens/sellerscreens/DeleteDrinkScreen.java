package screens.sellerscreens;

import entities.Drink;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextPanel;
import usecases.sellerusecases.SellerModifyDrink;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDrinkScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button deleteDrinkButton = new Button();
    Button cancelButton = new Button();

    JTextField drinkNameField = new JTextField(15); //The drink name entered

    public DeleteDrinkScreen() {
        // Basic setups
        frame.setSize(400, 125);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("delete drink");
        frame.setResizable(false);

        //Adding the eight textFields and two buttons to the panel.
        JPanel panel = new JPanel();

        LabelTextPanel drinkNamePanel = new LabelTextPanel(new JLabel("Name: "), drinkNameField);
        drinkNamePanel.setBounds(244, 270, 300, 40);
        panel.add(drinkNamePanel);

        deleteDrinkButton.createButton(panel, "delete", 325, 450, 150, 40);
        deleteDrinkButton.addActionListener(this);

        cancelButton.createButton(panel, "cancel", 325, 450, 150, 40);
        cancelButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String name = drinkNameField.getText();
        SellerModifyDrink delete = new SellerModifyDrink();
        Drink deleteDrink = delete.searchedDrinkToModify(name);

        if(e.getSource() == cancelButton.button){
            new SellerMainScreen();
            frame.setVisible(false);
        }

        if(e.getSource() == deleteDrinkButton.button){
            if (deleteDrink != null){
                delete.deleteDrink(name, deleteDrink.getPrice(), deleteDrink.getDescription(), deleteDrink.getIngredient(),
                        deleteDrink.getVolume(), deleteDrink.getProductionDate(), deleteDrink.getExpirationDate(), deleteDrink.getDiscount());
                new SellerMainScreen();
                frame.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Drink name not match.");
            }
        }
    }
}