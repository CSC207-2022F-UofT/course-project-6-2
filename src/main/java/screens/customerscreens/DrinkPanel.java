package screens.customerscreens;

import entities.Drink;
import presentor.ResponsePresenter;
import screens.swingcomponents.Button;
import usecases.databaseusecases.DrinkRuntimeDataBase;
import usecases.customerusecases.AddToShoppingCart;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Vector;

/**
 * The drinks panel that displays random drinks and can be added to shopping cart
 */

public class DrinkPanel extends JFrame implements ActionListener {
    private final JFrame frame;
    private final JPanel panel = new JPanel();
    private final Button addToCartButton = new Button();
    private Drink selectedDrink;

    public DrinkPanel(JFrame frame) {

        this.frame = frame;
        panel.setLayout(null);

        Vector<String> headers = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();
        DecimalFormat df = new DecimalFormat("0.00");

        headers.add("Drink name");
        headers.add("Store Name");
        headers.add("Price");
        headers.add("Volume");

        for (Drink drink: DrinkRuntimeDataBase.getDrinkList()) {
            Vector<String > line = new Vector<>();
            line.add(drink.getName());
            line.add(drink.getStoreName());
            line.add("$" + df.format(drink.getPrice() * drink.getDiscount()));
            line.add(drink.getVolume() + "ml");
            data.add(line);
        }

        JTable drinkTable = new JTable(data, headers);
        drinkTable.getTableHeader().setReorderingAllowed(false);
        drinkTable.getTableHeader().setResizingAllowed(false);

        addToCartButton.createButton(panel, "Add to Cart", 330, 440, 120, 40);
        addToCartButton.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane(drinkTable);
        scrollPane.setBounds(50,20,700, 400);
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
        if (e.getSource() == addToCartButton.button) {
            AddToShoppingCart.addToShoppingCart(selectedDrink, 1);
            new ResponsePresenter(" added to shopping cart!").drinkMessagePresenter(selectedDrink.getName());
            new CustomerMainScreen();
            frame.setVisible(false);
        }
    }
}
