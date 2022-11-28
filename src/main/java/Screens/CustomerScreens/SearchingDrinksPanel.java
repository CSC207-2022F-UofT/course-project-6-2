package Screens.CustomerScreens;

import Entities.Drink;
import Screens.CustomerScreens.CustomerMainScreen;
import Screens.LabelTextPanel;
import Screens.SearchingTable;
import Screens.SearchingTableModel;
import UseCases.SearchDrinks;
import UseCases.UserUseCases.AddToShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksPanel extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JPanel northPanel = new JPanel();
    JTextField searchBox = new JTextField(20);
    JButton searchBtn = new JButton("Search");

    JPanel southPanel = new JPanel();
    JTextField drinkName = new JTextField(10);

    JTextField storeName = new JTextField(10);
    JTextField drinkQuantity = new JTextField(10);
    JButton addBtn = new JButton("Add to shopping cart");
    SearchingTable myFrameTable = new SearchingTable();

    public SearchingDrinksPanel(){
        northPanel.add(searchBox);
        northPanel.add(searchBtn);

        panel.add(northPanel, BorderLayout.NORTH);
        layoutCenter(panel);

        LabelTextPanel drinkNamePanel = new LabelTextPanel(new JLabel("Name:"),drinkName);
        southPanel.add(drinkNamePanel);
        drinkName.setText("Input a drink name");

        LabelTextPanel storeNamePanel = new LabelTextPanel(new JLabel("Store Name:"),storeName);
        southPanel.add(storeNamePanel);
        storeName.setText("Input the store name of drink");

        LabelTextPanel drinkQuantityPanel = new LabelTextPanel(new JLabel("Quantity:"), drinkQuantity);
        southPanel.add(drinkQuantityPanel);
        drinkQuantity.setText("Input quantity");

        southPanel.add(addBtn);
        addBtn.addActionListener(this);

        panel.add(southPanel, BorderLayout.SOUTH);
        panel.setSize(800,600);
        panel.setVisible(true);
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
    public JPanel getPanel(){
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = drinkName.getText();
        String store = storeName.getText();
        int quantity = Integer.parseInt(drinkQuantity.getText());
        if (e.getSource() == addBtn){
            AddToShoppingCart.addToShoppingCart(name, store, quantity);
        }

    }

}
