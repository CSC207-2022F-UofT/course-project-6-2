package OrderHistory;
import Controller.GetCustomerController;
import UI.*;
import UI.Button;
import UI.ScrollPane;
import UI.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderHistoryScreen extends JFrame implements ActionListener {

    static JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    TextField orderNumber = new TextField();
    Button search = new Button();
    JButton reOrder = new JButton();
    JLabel order = new JLabel();
    ScrollPane scrollPane = new ScrollPane();
    OrderHistoryGrouping orderGroup = new OrderHistoryGrouping();
    //orderLabel orders = new orderLabel();
    GetCustomerController customerController = new GetCustomerController("Sancia","12345","1234567890",
            19, "123 Happy Street", new ArrayList());

    public OrderHistoryScreen() {

        //creating frame
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Order History");
        panel.setSize(frame.getSize());
        scrollPane.createScrollPane(frame, panel);

        // adding the components onto the panel
        orderNumber.createTextField(panel,25, 25, 300, 30);

        search.createButton(panel,"Search", 375,25,75,30);

        orderGroup.grouping(panel, order, reOrder);

        //orders.createOrderLabel(panel, order);

        frame.setVisible(true);
    }
    /**
     * Invoked when action occurs
     *
     * @param e the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}