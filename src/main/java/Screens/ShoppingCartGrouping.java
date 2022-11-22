package Screens;

import javax.swing.*;
public class ShoppingCartGrouping {

    public void createProductLabel(JPanel panel, JButton addQuantity, JButton minusQuantity, JLabel quantity){

        GroupLayout groupLayout = new GroupLayout(panel);

        panel.setLayout(groupLayout);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(minusQuantity)
                        .addGap(10, 20, 100)
                        .addComponent(quantity)
                        .addGap(10,20,100)
                        .addComponent(addQuantity));
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(minusQuantity)
                        .addComponent(quantity)
                        .addComponent(addQuantity));

        panel.setVisible(true);

    }
}
