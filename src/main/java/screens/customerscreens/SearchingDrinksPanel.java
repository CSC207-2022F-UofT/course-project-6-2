package screens.customerscreens;

import entities.Drink;
import screens.swingcomponents.LabelTextHorizontalPanel;
import usecases.drinkusecases.SearchDrinks;
import usecases.customerusecases.AddToShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksPanel extends JFrame implements ActionListener {
    private final JPanel panel = new JPanel();
    private final JTextField searchBox = new JTextField(20);
    private final JButton searchButton = new JButton("Search");
    private final JTextField drinkName = new JTextField(8);
    private final JTextField storeName = new JTextField(8);
    private final JTextField drinkQuantity = new JTextField(8);
    private final JButton addButton = new JButton("Add to shopping cart");
    private final SearchingTable myFrameTable = new SearchingTable();
    public SearchingDrinksPanel(){
        JPanel northPanel = new JPanel();
        northPanel.add(searchBox);
        northPanel.add(searchButton);

        panel.add(northPanel, BorderLayout.NORTH);
        layoutCenter(panel);

        LabelTextHorizontalPanel drinkNamePanel = new LabelTextHorizontalPanel(new JLabel("Name:"),drinkName);
        JPanel southPanel = new JPanel();
        southPanel.add(drinkNamePanel);

        LabelTextHorizontalPanel storeNamePanel = new LabelTextHorizontalPanel(new JLabel("Store Name:"),storeName);
        southPanel.add(storeNamePanel);

        LabelTextHorizontalPanel drinkQuantityPanel = new LabelTextHorizontalPanel(new JLabel("Quantity:"), drinkQuantity);
        southPanel.add(drinkQuantityPanel);

        southPanel.add(addButton);
        addButton.addActionListener(this);

        panel.add(southPanel, BorderLayout.SOUTH);
        panel.setSize(800,600);
        panel.setVisible(true);
    }
    private void layoutCenter(Container contentPane){
        Vector<Vector<Drink>> data = SearchDrinks.addToFiltered(searchBox.getText().trim());
        searchButton.addActionListener(new ActionListener() {
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
        if (e.getSource() == addButton){
            AddToShoppingCart.addToShoppingCart(name, store, quantity);
        }
    }
}
