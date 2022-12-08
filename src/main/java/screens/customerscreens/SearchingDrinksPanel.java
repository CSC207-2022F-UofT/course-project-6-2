package screens.customerscreens;

import entities.Drink;
import presentor.ResponsePresenter;
import usecases.customerusecases.AddToShoppingCart;
import usecases.drinkusecases.SearchDrinks;
import screens.swingcomponents.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksPanel extends JFrame implements ActionListener {
    private final JFrame frame;
    private final JPanel panel = new JPanel();
    private final JTextField searchBox = new JTextField(20);
    private final Button searchButton = new Button();
    private final Button addToCartButton = new Button();
    private final JTable drinkTable = new JTable();
    private Drink selectedDrink;
    private Vector<Drink> drinks = null;

    public SearchingDrinksPanel(JFrame frame){
        this.frame = frame;
        panel.setLayout(null);

        searchButton.createButton(panel, "search", 510, 10, 80, 30);
        searchButton.addActionListener(this);

        addToCartButton.createButton(panel, "Add to Cart", 330, 470, 120, 40);
        addToCartButton.addActionListener(this);

        searchBox.setBounds(200, 10, 300, 30);
        panel.add(searchBox);

        layoutCenter(panel);
        panel.setVisible(true);
    }
    private void layoutCenter(Container contentPane){
        JScrollPane jScrollPane = new JScrollPane(drinkTable);
        jScrollPane.setBounds(50,50,700, 400);
        contentPane.add(jScrollPane,BorderLayout.CENTER);

        System.out.println(drinks);

        ListSelectionModel model = drinkTable.getSelectionModel();
        model.addListSelectionListener(e -> {
            if (! model.isSelectionEmpty()) {
                int selectedRow = model.getMinSelectionIndex();
                selectedDrink = drinks.get(selectedRow);
            }
        });

        SearchDrinks.clearFilteredItems();
    }
    public JPanel getPanel(){
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton.button) {
            AddToShoppingCart.addToShoppingCart(selectedDrink, 1);
            new ResponsePresenter(" added to shopping cart!").drinkMessagePresenter(selectedDrink.getName());
            new CustomerMainScreen();
            frame.setVisible(false);
        }
        if (e.getSource() == searchButton.button) {
            Vector<Vector<String>> data = SearchDrinks.addToFiltered(searchBox.getText().trim());
            drinks = SearchDrinks.getDrinks();
            SearchingTableModel searchingTableModel = SearchingTableModel.assembleModel(data);
            drinkTable.setModel(searchingTableModel);
        }
    }
}