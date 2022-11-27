package UI;

import javax.swing.*;

public class OrderHistoryGrouping {
    public void grouping(JPanel panel, JLabel order, JButton reOrder) {

        GroupLayout groupLayout = new GroupLayout(panel);

        panel.setLayout(groupLayout);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(order)
                        .addGap(10, 20, 100)
                        .addComponent(reOrder));
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(order)
                        .addComponent(reOrder));

        panel.setVisible(true);
    }
}
