package screens.customerscreens;

import entities.Drink;
import screens.swingcomponents.LabelTextPanel;
import usecases.drinkusecases.SearchDrinks;
import usecases.customerusecases.AddToShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksPanel extends JFrame implements ActionListener {
    private final JPanel panel = new JPanel();
    JPanel northPanel = new JPanel();
    JTextField searchBox = new JTextField(20);
    JButton searchBtn = new JButton("Search");

    JPanel southPanel = new JPanel();
    JTextField drinkName = new JTextField(8);

    JTextField storeName = new JTextField(8);
    JTextField drinkQuantity = new JTextField(8);
    JButton addBtn = new JButton("Add to shopping cart");
    SearchingTable myFrameTable = new SearchingTable();

    public SearchingDrinksPanel(){
        northPanel.add(searchBox);
        northPanel.add(searchBtn);

        panel.add(northPanel, BorderLayout.NORTH);
        layoutCenter(panel);

        LabelTextPanel drinkNamePanel = new LabelTextPanel(new JLabel("Name:"),drinkName);
        southPanel.add(drinkNamePanel);

        LabelTextPanel storeNamePanel = new LabelTextPanel(new JLabel("Store Name:"),storeName);
        southPanel.add(storeNamePanel);

        LabelTextPanel drinkQuantityPanel = new LabelTextPanel(new JLabel("Quantity:"), drinkQuantity);
        southPanel.add(drinkQuantityPanel);

        southPanel.add(addBtn);
        addBtn.addActionListener(this);

        panel.add(southPanel, BorderLayout.SOUTH);
        panel.setSize(800,600);
        panel.setVisible(true);
    }
    private void layoutCenter(Container contentPane){
        Vector<Vector<Drink>> data = SearchDrinks.addToFiltered(searchBox.getText().trim());
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
        Integer quantity = Integer.parseInt(drinkQuantity.getText());
        if (e.getSource() == addBtn){
            AddToShoppingCart.addToShoppingCart(name, store, quantity);
        }

    }

}
