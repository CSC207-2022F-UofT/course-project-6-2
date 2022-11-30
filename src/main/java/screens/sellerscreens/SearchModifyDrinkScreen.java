package screens.sellerscreens;

import entities.Drink;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextHorizontalPanel;
import usecases.sellerusecases.SellerModifyDrink;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchModifyDrinkScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button searchDrinkButton = new Button();
    Button cancelButton = new Button();

    JTextField drinkNameField = new JTextField(15); //The drink name entered

    public SearchModifyDrinkScreen() {
        // Basic setups
        frame.setSize(400, 125);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("search drink to modify");
        frame.setResizable(false);

        //Adding the eight textFields and two buttons to the panel.
        JPanel panel = new JPanel();

        LabelTextHorizontalPanel drinkNamePanel = new LabelTextHorizontalPanel(new JLabel("Name: "), drinkNameField);
        drinkNamePanel.setBounds(244, 270, 300, 40);
        panel.add(drinkNamePanel);

        searchDrinkButton.createButton(panel, "search", 325, 450, 150, 40);
        searchDrinkButton.addActionListener(this);

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

        if(e.getSource() == searchDrinkButton.button){
            String name = drinkNameField.getText();
            SellerModifyDrink modify = new SellerModifyDrink();
            boolean drinkExist = modify.drinkExist(name);

            if (drinkExist){
                modify.searchedDrinkToModify(name);
                new ModifyDrinkScreen();
                frame.setVisible(false);
            }else {
                JOptionPane.showMessageDialog(null, "No drink named " + name);
            }
        }

    }
}
