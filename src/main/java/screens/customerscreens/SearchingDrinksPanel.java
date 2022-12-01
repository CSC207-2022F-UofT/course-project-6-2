package screens.customerscreens;

import entities.Drink;
import usecases.drinkusecases.SearchDrinks;
import screens.swingcomponents.Button;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksPanel extends JFrame implements ActionListener {
    private final JPanel panel = new JPanel();
    private final JTextField searchBox = new JTextField(20);
    private final Button searchButton = new Button();
    private final Button addToCartButton = new Button();
    private final JTable drinkTable = new JTable();
    private Drink selectedDrink;

    public SearchingDrinksPanel(){
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
        Vector<Vector<Drink>> data = SearchDrinks.addToFiltered(searchBox.getText().trim());
        SearchingTableModel searchingTableModel = SearchingTableModel.assembleModel(data);
        searchButton.addActionListener(e -> drinkTable.setModel(searchingTableModel));

        JScrollPane jScrollPane = new JScrollPane(drinkTable);
        jScrollPane.setBounds(50,50,700, 400);
        contentPane.add(jScrollPane,BorderLayout.CENTER);

        ListSelectionModel model = drinkTable.getSelectionModel();
        model.addListSelectionListener(e -> {
            if (! model.isSelectionEmpty()) {
                int selectedRow = model.getMinSelectionIndex();
                selectedDrink = SearchDrinks.getDrinks().get(selectedRow);
            }
        });
    }
    public JPanel getPanel(){
        return panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addToCartButton.button) {
            UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().addItem(selectedDrink, 1);
            JOptionPane.showMessageDialog(null, selectedDrink.getName()  + " added to shopping cart!");
            new CustomerMainScreen();
        }
    }

}