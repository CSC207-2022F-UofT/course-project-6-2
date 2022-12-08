package screens.sellerscreens;

import entities.Drink;
import presentor.ResponsePresenter;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextHorizontalPanel;
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
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("delete drink");
        frame.setResizable(false);

        //Adding the eight textFields and two buttons to the panel.
        JPanel panel = new JPanel();

        LabelTextHorizontalPanel drinkNamePanel = new LabelTextHorizontalPanel(new JLabel("Name: "), drinkNameField);
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

        if(e.getSource() == cancelButton.button){
            new SellerMainScreen();
            frame.setVisible(false);
            return;
        }

        if(e.getSource() == deleteDrinkButton.button){
            String name = drinkNameField.getText();
            SellerModifyDrink delete = new SellerModifyDrink();
            boolean drinkExist = delete.drinkExist(name);

            if (drinkExist){
                Drink deleteDrink = delete.searchedDrinkToModify(name);
                delete.deleteDrink(deleteDrink);
                new SellerMainScreen();
                frame.setVisible(false);
            } else {
                new ResponsePresenter("No drink named").drinkMessagePresenter(name);
            }
        }
    }
}