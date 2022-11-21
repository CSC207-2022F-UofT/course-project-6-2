package Screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static UseCases.SearchDrinks.Add_to_Filtered;

public class SearchDrinksScreen extends JFrame{
    public static void main(String args[]){
        SearchDrinksScreen frame = new SearchDrinksScreen();
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    JTextField search_box = new JTextField(20);

    public SearchDrinksScreen(){
        super();
        JPanel root = new JPanel();
        this.setContentPane(root);

        root.add(search_box);
        search_box.setText("Input the keywords of drink");
        JButton button = new JButton("OK");
        root.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add_to_Filtered(search_box.getText());
            }
        });
    }

}
