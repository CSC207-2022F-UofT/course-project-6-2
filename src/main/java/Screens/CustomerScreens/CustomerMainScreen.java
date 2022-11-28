package Screens.CustomerScreens;

import UseCases.DetectWindowClose;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The customer main screen containing the drinks, search drinks, sale board,
 * shopping cart, order history and customer service panels and features.
 */

public class CustomerMainScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    public CustomerMainScreen() {
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Customer Main Page");
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

        // Drinks panel
        mainTabbedPanel.addTab("Drinks", drinksPanel);

        JPanel DrinkPanel = new DrinkPanel().getPanel();

        GroupLayout DrinksPanelLayout = new GroupLayout(drinksPanel);
        drinksPanel.setLayout(DrinksPanelLayout);
        DrinksPanelLayout.setHorizontalGroup(
                DrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(DrinkPanel)
        );
        DrinksPanelLayout.setVerticalGroup(
                DrinksPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(DrinkPanel)
        );

        // Search drinks panel
        mainTabbedPanel.addTab("Search Drinks", searchDrinksPanel);

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

        // Sale section panel
        mainTabbedPanel.addTab("Sale Section", saleSectionPanel);

        JPanel SaleSectionPanel = new SaleSectionPanel().getPanel();

        GroupLayout SaleSectionPanelLayout = new GroupLayout(saleSectionPanel);
        saleSectionPanel.setLayout(SaleSectionPanelLayout);
        SaleSectionPanelLayout.setHorizontalGroup(
                SaleSectionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(SaleSectionPanel)
        );
        SaleSectionPanelLayout.setVerticalGroup(
                SaleSectionPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(SaleSectionPanel)
        );

        // Shopping cart panel
        mainTabbedPanel.addTab("Shopping Cart", shoppingCartPanel);

        JPanel ShoppingCartPanel = new ShoppingCartPanel().getPanel();

        GroupLayout ShoppingCartPanelLayout = new GroupLayout(shoppingCartPanel);
        shoppingCartPanel.setLayout(ShoppingCartPanelLayout);
        ShoppingCartPanelLayout.setHorizontalGroup(
                ShoppingCartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(ShoppingCartPanel)
        );
        ShoppingCartPanelLayout.setVerticalGroup(
                ShoppingCartPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(ShoppingCartPanel)
        );

        // Order history panel
        mainTabbedPanel.addTab("Order History", orderHistoryPanel);

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

        // Customer service panel
        mainTabbedPanel.addTab("Customer Service", customerServicePanel);

        JPanel CustomerServicePanel = new CustomerServicePanel().getPanel();

        GroupLayout CustomerServicePanelLayout = new GroupLayout(customerServicePanel);
        customerServicePanel.setLayout(CustomerServicePanelLayout);
        CustomerServicePanelLayout.setHorizontalGroup(
                CustomerServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(CustomerServicePanel)
        );
        CustomerServicePanelLayout.setVerticalGroup(
                CustomerServicePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(CustomerServicePanel)
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

        pack();
        frame.add(mainTabbedPanel);
        frame.setVisible(true);

        new DetectWindowClose(frame);
    }

    public static void main(String[] args) {
        new CustomerMainScreen();
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

