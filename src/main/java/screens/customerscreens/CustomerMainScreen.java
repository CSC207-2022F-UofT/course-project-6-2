package screens.customerscreens;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The customer main screen containing the drinks, search drinks, sale board,
 * shopping cart, order history and customer service panels and features.
 */

public class CustomerMainScreen extends JFrame {
    public CustomerMainScreen() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Main Page");
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);

        JTabbedPane mainTabbedPanel = new JTabbedPane();
        JPanel drinksTabPanel = new JPanel();
        JPanel searchDrinkTabPanel = new JPanel();
        JPanel saleSectionTabPanel = new JPanel();
        JPanel shoppingCartTabPanel = new JPanel();
        JPanel orderHistoryTabPanel = new JPanel();
        JPanel customerServiceTabPanel = new JPanel();

        // Drinks panel
        mainTabbedPanel.addTab("Drinks", drinksTabPanel);

        JPanel drinksPanel = new DrinkPanel().getPanel();

        GroupLayout DrinksPanelLayout = new GroupLayout(drinksTabPanel);
        drinksTabPanel.setLayout(DrinksPanelLayout);
        DrinksPanelLayout.setHorizontalGroup(
                DrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(drinksPanel)
        );
        DrinksPanelLayout.setVerticalGroup(
                DrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(drinksPanel)
        );

        // Search drinks panel
        mainTabbedPanel.addTab("Search Drinks", searchDrinkTabPanel);

        JPanel searchDrinksPanel = new SearchingDrinksPanel().getPanel();

        GroupLayout SearchDrinksPanelLayout = new GroupLayout(searchDrinkTabPanel);
        searchDrinkTabPanel.setLayout(SearchDrinksPanelLayout);
        SearchDrinksPanelLayout.setHorizontalGroup(
                SearchDrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(SearchDrinksPanelLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addContainerGap(512, Short.MAX_VALUE))
                        .addComponent(searchDrinksPanel)
        );
        SearchDrinksPanelLayout.setVerticalGroup(
                SearchDrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(SearchDrinksPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addContainerGap(493, Short.MAX_VALUE))
                        .addComponent(searchDrinksPanel)
        );

        // Sale section panel
        mainTabbedPanel.addTab("Sale Section", saleSectionTabPanel);

        JPanel saleSectionPanel = new SaleSectionPanel().getPanel();

        GroupLayout SaleSectionPanelLayout = new GroupLayout(saleSectionTabPanel);
        saleSectionTabPanel.setLayout(SaleSectionPanelLayout);
        SaleSectionPanelLayout.setHorizontalGroup(
                SaleSectionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(saleSectionPanel)
        );
        SaleSectionPanelLayout.setVerticalGroup(
                SaleSectionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(saleSectionPanel)
        );

        // Shopping cart panel
        mainTabbedPanel.addTab("Shopping Cart", shoppingCartTabPanel);

        JPanel shoppingCartPanel = new ShoppingCartPanel().getPanel();

        GroupLayout ShoppingCartPanelLayout = new GroupLayout(shoppingCartTabPanel);
        shoppingCartTabPanel.setLayout(ShoppingCartPanelLayout);
        ShoppingCartPanelLayout.setHorizontalGroup(
                ShoppingCartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(shoppingCartPanel)
        );
        ShoppingCartPanelLayout.setVerticalGroup(
                ShoppingCartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(shoppingCartPanel)
        );

        // Order history panel
        mainTabbedPanel.addTab("Order History", orderHistoryTabPanel);

        JPanel orderHistoryPanel = new OrderHistoryPanel().getPanel();

        GroupLayout OrderHistoryPanelLayout = new GroupLayout(orderHistoryTabPanel);
        orderHistoryTabPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
                OrderHistoryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(orderHistoryPanel)
        );
        OrderHistoryPanelLayout.setVerticalGroup(
                OrderHistoryPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(orderHistoryPanel)
        );

        // Customer service panel
        mainTabbedPanel.addTab("Customer Service", customerServiceTabPanel);

        JPanel customerServicePanel = new CustomerServicePanel().getPanel();

        GroupLayout CustomerServicePanelLayout = new GroupLayout(customerServiceTabPanel);
        customerServiceTabPanel.setLayout(CustomerServicePanelLayout);
        CustomerServicePanelLayout.setHorizontalGroup(
                CustomerServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(customerServicePanel)
        );
        CustomerServicePanelLayout.setVerticalGroup(
                CustomerServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(customerServicePanel)
        );

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

        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                if (sourceTabbedPane.getTitleAt(index) == "Order History") {
                    // Refresh the order history panel with updated data
                } else if (sourceTabbedPane.getTitleAt(index) == "Shopping Cart") {
                    // Refresh the shopping cart panel with updated data
                }
            }
        };
        mainTabbedPanel.addChangeListener(changeListener);

        pack();
        frame.add(mainTabbedPanel);
        frame.setVisible(true);
    }
}

