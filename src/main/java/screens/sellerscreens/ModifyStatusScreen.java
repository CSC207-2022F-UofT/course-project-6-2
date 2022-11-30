package screens.sellerscreens;

//import UseCases.ExtractUserFromPhoneNum;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextHorizontalPanel;
import entities.users.Seller;
import usecases.sellerusecases.ModifyOrderStatus;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyStatusScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button modifyButton = new Button();
    Button backButton = new Button();

    JTextField orderNumField = new JTextField(15); //The order number entered
    JTextField statusField = new JTextField(15); //The new order status entered

    public ModifyStatusScreen() {
        // Basic setups

        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("modify order status");
        frame.setResizable(false);

        //Adding the two textFields and two buttons to the panel.
        JPanel panel = new JPanel();

        LabelTextHorizontalPanel orderNumPanel = new LabelTextHorizontalPanel(new JLabel("Order Number: "), orderNumField);
        orderNumPanel.setBounds(244, 270, 300, 40);
        panel.add(orderNumPanel);

        LabelTextHorizontalPanel statusPanel =  new LabelTextHorizontalPanel(new JLabel("Order Status: "), statusField);
        statusPanel.setBounds(270, 320, 280, 40);
        panel.add(statusPanel);

        modifyButton.createButton(panel, "modify status", 325, 450, 150, 40);
        modifyButton.addActionListener(this);

        backButton.createButton(panel, "back", 325, 450, 150, 40);
        backButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        String orderNum = orderNumField.getText();
        String newStatus = statusField.getText();

        if (e.getSource() == backButton.button){
            new OrderStatusScreen();
            frame.setVisible(false);
        }

        Seller seller = UserRuntimeDataBase.getCurrentSeller();
        if (e.getSource() == modifyButton.getButton()){
            //Change the order status of the particular order if the order number is included in the seller's orders.
            boolean inSellerOrder = false;
            for (int i = 0; i < seller.allOrders.size(); i++){
                if (String.valueOf(seller.allOrders.get(i).getOrderNum()) == orderNum){
                    if (seller.allOrders.get(i).getOrderStatus() != newStatus){
                        inSellerOrder = true;
                    }
                }
            }
            if (inSellerOrder) {
                new ModifyOrderStatus().modifyOrderStatus(orderNum, newStatus);
                JOptionPane.showMessageDialog(null, "You have changed the order status.");
            } else {
                JOptionPane.showMessageDialog(null, "The order number does not exist or the order status is the same.");
            }
            //Close the modifyStatusScreen and open the previous order status screen(with changing).
            new OrderStatusScreen();
            frame.setVisible(false);
        }
    }
}
