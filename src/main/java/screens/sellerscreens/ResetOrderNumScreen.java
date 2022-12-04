package screens.sellerscreens;

import entities.users.Seller;
import screens.swingcomponents.Button;
import screens.swingcomponents.LabelTextHorizontalPanel;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.sellerusecases.DeleteOrder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ResetOrderNumScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    Button modifyButton = new Button();
    Button backButton = new Button();

    JTextField orderNumField = new JTextField(15); //The order number entered

    public ResetOrderNumScreen() {
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


        modifyButton.createButton(panel, "modify status", 325, 450, 150, 40);
        modifyButton.addActionListener(this);

        backButton.createButton(panel, "back", 325, 450, 150, 40);
        backButton.addActionListener(this);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == backButton.button){
            new OrderStatusScreen();
            frame.setVisible(false);
        }

        if (e.getSource() == modifyButton.getButton()){
            Seller seller = UserRuntimeDataBase.getCurrentSeller();


            String orderNum = orderNumField.getText();

            new DeleteOrder().deleteOrder(orderNum);
            //Close the modifyStatusScreen and open the previous order status screen(with changing).
            new OrderStatusScreen();
            frame.setVisible(false);
        }
    }
}
