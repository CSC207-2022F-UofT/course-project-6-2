package UI;

import Controller.GetCustomerController;
import users.Customer;

import javax.swing.*;
import java.util.ArrayList;

public class orderLabel{

    GetCustomerController phoneNum = new GetCustomerController("Sancia","12345","1234567890",
            19, "123 Happy Street", new ArrayList());
    Customer currentCustomer = phoneNum.getCustomer(phoneNum.getPhoneNumber());
    ArrayList<String> orderHistory = currentCustomer.getOrderHistory();

    public void createOrderLabel(JPanel panel, JLabel order){

        // creating labels for each order in order history
        if (orderHistory.size() != 0){
            for(int i = 0; i < orderHistory.size(); i++){
                for(int y = 0; y < orderHistory.size(); y+=50) {
                    order.setBounds( 200, y, 80, 100);
                    order.setText(orderHistory.get(i));
                    panel.add(order);
                }
            }
        }
        else
        {
            panel.setVisible(true);
        }
    }
}
