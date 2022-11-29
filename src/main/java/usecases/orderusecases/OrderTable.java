package usecases.orderusecases;

import controller.LoginController;
import entities.Order;
import entities.users.Customer;
import usecases.userusercases.UserRuntimeDataBase;

import javax.swing.*;
import java.util.ArrayList;

public class OrderTable {

    public void createOrderTable(JTable table, LoginController loginController) {

        Customer customer = UserRuntimeDataBase.getCurrentCustomer();
        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < customer.getOrderHistory().size(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setModel(new javax.swing.table.DefaultTableModel(
                        new Object[][]{
                                {String.valueOf(i), customer.getOrderHistory().get(i).getTotalOrder(),
                                        customer.getOrderHistory().get(i).getOrderStatus(), "Re-Order"}
                        }, new String[]{
                        "Order", "Order Price", "Order Status", "Re-Order"
                }) {
                    // making the columns uneditable
                    final boolean[] canEdit = new boolean[]{
                            false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });
            }
        }
    }
}
