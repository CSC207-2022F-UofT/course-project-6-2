package screens.loginregisterscreens;

import javax.swing.*;

/**
 * This is the first screen when user open this project, it set up the interface including all the panels.
 */
public class FirstMainScreen extends JFrame {
    public FirstMainScreen() {
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Drink Delivery Application");
        frame.setResizable(false);

        JTabbedPane mainTabbedPanel = new JTabbedPane();
        JPanel loginTabPanel = new JPanel();
        JPanel customerRegisterTabPanel = new JPanel();
        JPanel sellerRegisterTabPanel = new JPanel();
        JPanel resetPasswordTabPanel = new JPanel();

        // Login panel
        mainTabbedPanel.addTab("Login", loginTabPanel);

        JPanel loginPanel = new LoginScreenPanel(frame).getPanel();

        GroupLayout loginPanelLayout = new GroupLayout(loginTabPanel);
        loginTabPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(loginPanel)
        );
        loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(loginPanel)
        );

        // Customer register panel
        mainTabbedPanel.addTab("Customer Register", customerRegisterTabPanel);

        JPanel customerRegisterPanel = new CustomerRegisterPanel().getPanel();

        GroupLayout customerRegisterTabLayout = new GroupLayout(customerRegisterTabPanel);
        customerRegisterTabPanel.setLayout(customerRegisterTabLayout);
        customerRegisterTabLayout.setHorizontalGroup(
                customerRegisterTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(customerRegisterPanel)
        );
        customerRegisterTabLayout.setVerticalGroup(
                customerRegisterTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(customerRegisterPanel)
        );

        // Seller register panel
        mainTabbedPanel.addTab("Seller Register", sellerRegisterTabPanel);

        JPanel sellerRegisterPanel = new SellerRegisterPanel().getPanel();

        GroupLayout sellerRegisterTabLayout = new GroupLayout(sellerRegisterTabPanel);
        sellerRegisterTabPanel.setLayout(sellerRegisterTabLayout);
        sellerRegisterTabLayout.setHorizontalGroup(
                sellerRegisterTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addComponent(sellerRegisterPanel)
        );
        sellerRegisterTabLayout.setVerticalGroup(
                sellerRegisterTabLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
                        .addComponent(sellerRegisterPanel)
        );

        // Reset Password
        mainTabbedPanel.addTab("Reset Password", resetPasswordTabPanel);

        JPanel resetPasswordPanel = new ResetPasswordPanel().getPanel();

        GroupLayout resetPasswordPanelLayout = new GroupLayout(resetPasswordTabPanel);
        resetPasswordTabPanel.setLayout(resetPasswordPanelLayout);
        resetPasswordPanelLayout.setHorizontalGroup(
                resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addContainerGap(551, Short.MAX_VALUE))
                        .addComponent(resetPasswordPanel)
        );
        resetPasswordPanelLayout.setVerticalGroup(
                resetPasswordPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(resetPasswordPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addContainerGap(449, Short.MAX_VALUE))
                        .addComponent(resetPasswordPanel)
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
    }
}
