package screens.customerscreens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static usecases.drinkusecases.SearchDrinks.addToFiltered;

public class SearchDrinkPanel extends JFrame implements ActionListener{
    JTextField searchBox = new JTextField(20);

    public SearchDrinkPanel(){
        super();
        JPanel root = new JPanel();
        this.setContentPane(root);

        root.add(searchBox);
        searchBox.setText("Input the keywords of drink");
        JButton button = new JButton("OK");
        root.add(button);
        button.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        addToFiltered(searchBox.getText());
    }
}
