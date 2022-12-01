package screens.customerscreens;

import entities.Drink;
import screens.swingcomponents.Button;
import usecases.drinkusecases.GetOnSaleDrinks;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The sale section panel that displays on sale drinks and can be added to shopping cart
 */

public class SaleSectionPanel extends JFrame implements ActionListener {
    private final JFrame frame;
    private final JPanel panel = new JPanel();
    private Drink selectedDrink;
    private final Button addToCartButton = new Button();
    public SaleSectionPanel(JFrame frame) {
        this.frame = frame;
        panel.setLayout(null);

        Vector<String> headers = new Vector<>();
        Vector<Vector<String>> data = new Vector<>();
        ArrayList<Drink> onSaleDrinks = new GetOnSaleDrinks().onSale();
        DecimalFormat df = new DecimalFormat("0.00");

        headers.add("Drink name");
        headers.add("Original Price");
        headers.add("Discount");
        headers.add("Current Price");

        for (Drink drink: onSaleDrinks) {
            Vector<String> line = new Vector<>();
            line.add(drink.getName());
            line.add("$" + drink.getPrice());
            line.add(df.format((1 - drink.getDiscount()) * 100) + "%");
            line.add("$" + df.format(drink.getPrice() * drink.getDiscount()));
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
                selectedDrink = onSaleDrinks.get(selectedRow);
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
            UserRuntimeDataBase.getCurrentCustomer().getShoppingCart().addItem(selectedDrink, 1);
            JOptionPane.showMessageDialog(null, selectedDrink.getName()  + " added to shopping cart!");
            new CustomerMainScreen();
            frame.setVisible(false);
        }
    }
}
