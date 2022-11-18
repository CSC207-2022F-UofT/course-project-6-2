package OrderHistory;

import UI.Button;
import UI.TextField;
import UI.ScrollPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderHistoryScreen extends JFrame implements ActionListener {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    TextField orderNumber = new TextField();
    Button search = new Button();
    ScrollPane scrollPane = new ScrollPane();

    public OrderHistoryScreen() {

        //creating frame
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Order History");
        frame.getContentPane().add(panel);

        // adding the components onto the panel
        orderNumber.createTextField(panel,25, 25, 225, 30);

        search.createButton(panel,"Search", 275,25,75,30);

        scrollPane.createScrollPane(frame);

        panel.setLayout(null);
        panel.setVisible(true);
        frame.setVisible(true);
    }

    /**
     * Invoked when action occurs
     *
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search){
            //if(orderNumber.getTextField().equals(database.getObject())){

            //}
        }
    }
}