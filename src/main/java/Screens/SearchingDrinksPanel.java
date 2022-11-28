package Screens;

import Entities.Drink;
import Screens.CustomerScreens.CustomerMainScreen;
import UseCases.SearchDrinks;
import UseCases.UserUseCases.AddToShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksPanel extends JFrame{
    JFrame jFrame = new JFrame();
    JPanel northPanel = new JPanel();
    JTextField searchBox = new JTextField(20);
    JButton searchBtn = new JButton("Search");

    JPanel southPanel = new JPanel();
    JTextField drinkName = new JTextField(10);

    JTextField storeName = new JTextField(10);
    JTextField drinkQuantity = new JTextField(10);
    JButton addBtn = new JButton("Add to shopping cart");
    JButton preBtn = new JButton("Previous");
    SearchingTable myFrameTable = new SearchingTable();

    public SearchingDrinksPanel(){

        Container contentPane = getContentPane();
        northPanel.add(searchBox);
        northPanel.add(searchBtn);
        jFrame.add(northPanel, BorderLayout.NORTH);
        layoutCenter(jFrame);
        southPanel.add(drinkName);
        drinkName.setText("Input a drink name");
        southPanel.add(storeName);
        storeName.setText("Input the store name of drink");
        southPanel.add(drinkQuantity);
        drinkQuantity.setText("Input quantity");
        southPanel.add(addBtn);
        southPanel.add(preBtn);
        jFrame.add(southPanel, BorderLayout.SOUTH);
        jFrame.setSize(800,600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
    private void layoutCenter(Container contentPane){
        Vector<Vector<Drink>> data = SearchDrinks.Add_to_Filtered(searchBox.getText().trim());
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchingTableModel searchingTableModel = SearchingTableModel.assembleModel(data);
                myFrameTable.setModel(searchingTableModel);
            }
        });


        JScrollPane jScrollPane = new JScrollPane(myFrameTable);
        contentPane.add(jScrollPane,BorderLayout.CENTER);
    }

    public void add_and_back(){
        String name = drinkName.getText();
        String store = storeName.getText();
        int quantity = Integer.parseInt(drinkQuantity.getText());
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddToShoppingCart.addToShoppingCart(name, store, quantity);
            }
        });
        preBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerMainScreen();
                jFrame.setVisible(false);
            }
        });
    }

}
