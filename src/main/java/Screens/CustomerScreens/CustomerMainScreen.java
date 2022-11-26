package Screens.CustomerScreens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMainScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    public CustomerMainScreen() {
        JPanel panel = new JPanel();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Drink Application");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        JTabbedPane mainTabbedPanel = new JTabbedPane();
        JPanel drinksPanel = new JPanel();
        JPanel searchDrinksPanel = new JPanel();
        JPanel saleSectionPanel = new JPanel();
        JPanel shoppingCartPanel = new JPanel();
        JPanel orderHistoryPanel = new JPanel();
        JPanel customerServicePanel = new JPanel();

        GroupLayout DrinksPanelLayout = new GroupLayout(drinksPanel);
        drinksPanel.setLayout(DrinksPanelLayout);
        DrinksPanelLayout.setHorizontalGroup(
                DrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        DrinksPanelLayout.setVerticalGroup(
                DrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );

        mainTabbedPanel.addTab("Drinks", drinksPanel);

        GroupLayout SearchDrinksPanelLayout = new GroupLayout(searchDrinksPanel);
        searchDrinksPanel.setLayout(SearchDrinksPanelLayout);
        SearchDrinksPanelLayout.setHorizontalGroup(
                SearchDrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(SearchDrinksPanelLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addContainerGap(512, Short.MAX_VALUE))
        );
        SearchDrinksPanelLayout.setVerticalGroup(
                SearchDrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(SearchDrinksPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addContainerGap(493, Short.MAX_VALUE))
        );

        mainTabbedPanel.addTab("Search Drinks", searchDrinksPanel);

        GroupLayout SaleSectionPanelLayout = new GroupLayout(saleSectionPanel);
        saleSectionPanel.setLayout(SaleSectionPanelLayout);
        SaleSectionPanelLayout.setHorizontalGroup(
                SaleSectionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        SaleSectionPanelLayout.setVerticalGroup(
                SaleSectionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );

        mainTabbedPanel.addTab("Sale Section", saleSectionPanel);

        GroupLayout ShoppingCartPanelLayout = new GroupLayout(shoppingCartPanel);
        shoppingCartPanel.setLayout(ShoppingCartPanelLayout);
        ShoppingCartPanelLayout.setHorizontalGroup(
                ShoppingCartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        ShoppingCartPanelLayout.setVerticalGroup(
                ShoppingCartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );

        mainTabbedPanel.addTab("Shopping Cart", shoppingCartPanel);

        GroupLayout OrderHistoryPanelLayout = new GroupLayout(orderHistoryPanel);
        orderHistoryPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
                OrderHistoryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        OrderHistoryPanelLayout.setVerticalGroup(
                OrderHistoryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );

        mainTabbedPanel.addTab("Order History", orderHistoryPanel);

        GroupLayout CustomerServicePanelLayout = new GroupLayout(customerServicePanel);
        customerServicePanel.setLayout(CustomerServicePanelLayout);
        CustomerServicePanelLayout.setHorizontalGroup(
                CustomerServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
        );
        CustomerServicePanelLayout.setVerticalGroup(
                CustomerServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );

        mainTabbedPanel.addTab("Customer Service", customerServicePanel);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainTabbedPanel)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainTabbedPanel, GroupLayout.Alignment.TRAILING)
        );

        pack();
        frame.add(mainTabbedPanel);
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new CustomerMainScreen().setVisible(true));
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}