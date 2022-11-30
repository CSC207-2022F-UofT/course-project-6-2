package screens.customerscreens;

import entities.Drink;
import screens.sellerscreens.SellerMainScreen;
import screens.swingcomponents.Button;
import usecases.drinkusecases.DrinkRuntimeDataBase;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The drinks panel that displays random drinks and can be added to shopping cart
 */

public class DrinkPanel extends JFrame implements ActionListener {
    JScrollPane scrollPane;
    JPanel panel = new JPanel();
    JTable drinkTable;
    Drink selectedDrink;
    Button addToCart = new Button();

    public DrinkPanel() {
        panel.setLayout(null);

        Vector<String> headers = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();

        headers.add("Drink name");
        headers.add("Store Name");
        headers.add("Price");
        headers.add("Volume");

        for (Drink drink: DrinkRuntimeDataBase.getDrinkList()) {
            Vector<String > line = new Vector<>();
            line.add(drink.getName());
            line.add(drink.getStoreName());
            line.add("$" + drink.getPrice());
            line.add(drink.getVolume() + "ml");
            data.add(line);
        }

        drinkTable = new JTable(data, headers);
        drinkTable.getTableHeader().setReorderingAllowed(false);
        drinkTable.getTableHeader().setResizingAllowed(false);

        addToCart.createButton(panel, "Add to Cart", 330, 440, 120, 40);
        addToCart.addActionListener(this);

        scrollPane = new JScrollPane(drinkTable);
        scrollPane.setBounds(50,0,700, 400);
        panel.add(scrollPane);

        ListSelectionModel model = drinkTable.getSelectionModel();
        model.addListSelectionListener(e -> {
            if (! model.isSelectionEmpty()) {
                int selectedRow = model.getMinSelectionIndex();
                selectedDrink = DrinkRuntimeDataBase.getDrinkList().get(selectedRow);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().addItem(selectedDrink, 1);
        JOptionPane.showMessageDialog(null, selectedDrink.getName()  + "added to shopping cart!");
        new CustomerMainScreen();
    }
}
