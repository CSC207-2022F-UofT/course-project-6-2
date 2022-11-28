package Screens;

import javax.swing.*;

public class ShoppingCartPanel {

    public void createShoppingCartPanel(GroupLayout panelLayout, JScrollPane innerScrollPane, JButton addQuantity, JButton checkoutButton,
                                  JButton minusQuantity, JLabel totalLabel, JLabel totalAmountLabel){
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(innerScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(addQuantity)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(checkoutButton)
                                                .addGap(35, 35, 35))
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(minusQuantity)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalAmountLabel)
                                                .addGap(50, 50, 50))))
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelLayout.createSequentialGroup()
                                                .addComponent(innerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(totalLabel)
                                                        .addComponent(totalAmountLabel)))
                                        .addComponent(minusQuantity, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkoutButton)
                                        .addComponent(addQuantity))
                                .addContainerGap(97, Short.MAX_VALUE))
        );
    }
}
