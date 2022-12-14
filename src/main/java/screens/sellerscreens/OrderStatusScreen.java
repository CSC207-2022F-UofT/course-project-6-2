package screens.sellerscreens;

import entities.users.Seller;
import screens.swingcomponents.Button;
import usecases.databaseusecases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;
import java.util.Vector;

/**
 * The order status screen display all the order that customer has checked out from this store.
 * This screen also has the button to let seller modify the order status of particular order.
 */
public class OrderStatusScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    public Button modifyButton = new Button();
    public Button backButton = new Button();
    Vector<String> headers = new Vector<>();
    Vector<Vector<String>> data = new Vector<>();

    public OrderStatusScreen() {
        // Basic setups for the Jtable.
        headers.add("order number");
        headers.add("order status");

        //Get the phone number from login and extract the corresponding seller object.
        Seller seller = UserRuntimeDataBase.getCurrentSeller();
        if (seller.allOrders != null) {
            for (int i = 0; i < seller.allOrders.size(); i++) {
                Vector<String> line = new Vector<>();
                line.add(Integer.toString(seller.allOrders.get(i).getOrderNum()));
                line.add(seller.allOrders.get(i).getOrderStatus());
                data.add(line);
            }
        }

        //Basic set up for the frame.
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("order history");
        frame.setResizable(false);

        //Setting up the two panels.
        JPanel panel = new JPanel();
        JTable orderTable = new JTable(data, headers);
        JScrollPane scrollPane = new JScrollPane(orderTable);
        Container contentPane = frame.getContentPane();

        //Adding the two Buttons.
        modifyButton.createButton(panel, "Modify status", 250, 400, 150, 40);
        modifyButton.addActionListener(this);
        backButton.createButton(panel, "Previous Page", 400, 400, 150, 40);
        backButton.addActionListener(this);

        //Adding the two panels to the contentPane.
        contentPane.add(panel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == modifyButton.getButton()){
            new ModifyStatusScreen();
            frame.setVisible(false);
        }
        if(e.getSource() == backButton.getButton()){
            new SellerMainScreen();
            frame.setVisible(false);
        }

    }
}
