package screens.customerscreens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerServicePanel extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    public CustomerServicePanel() {

        JTextField ShowAnswerText = new JTextField();
        ShowAnswerText.setBounds(50,50, 700,80);

        /* first question & answer*/
        JButton b = new JButton("How can I sell my product in your store?");
        b.setBounds(50,150,700,30);
        b.addActionListener(e -> ShowAnswerText.setText("Register on our app for the flexibility to sell one item or thousands.\n" +
                "Fulfill orders quickly when customers make a purchase."));

        /* 2nd question & answer*/
        JButton c=new JButton("Where can I collect reward points with my purchase?");
        c.setBounds(50,200,700,30);
        c.addActionListener(e -> ShowAnswerText.setText("Sorry, currently we do not offer any reward points"));

        /* 3rd question & answer*/
        JButton d =new JButton(" Does your store offer birthday specials? ");
        d.setBounds(50,250,700,30);
        d.addActionListener(e -> ShowAnswerText.setText("Sorry, currently we do not offer " +
                "any birthday special or reward programs. "));

        /* 4th question & answer*/
        JButton x =new JButton("How do I know if my order is placed?");
        x.setBounds(50,300,700,30);
        x.addActionListener(e -> ShowAnswerText.setText("Once you place an order on the website, you'll find the record from " +
                "Get Order Status shortly"));

        /* 5th question & answer*/
        JButton y =new JButton(" How much does it cost to ship items? ");
        y.setBounds(50,350,700,30);
        y.addActionListener(e -> ShowAnswerText.setText("Shipping fees depend on whether you plan to fulfill orders yourself." +
                " Generally speaking: Air express > Air freight > sea freight "));

        /* 6th question & answer*/
        JButton z =new JButton(" What items can not be sold in your app? ");
        z.setBounds(50,400,700,30);
        z.addActionListener(e -> ShowAnswerText.setText("Some products may not be listed as a matter of " +
                "compliance with legal or regulatory restrictions (for example, prescription drugs). "));

        /* 6th question & answer*/
        JButton q =new JButton(" Need More Help? ");
        q.setBounds(50,450,700,30);
        q.addActionListener(e -> ShowAnswerText.setText("Further concerns please contact our customer support. Phone: 416-978-3384." +
                " Email: ask.6+2@utoronto.ca  | Follow us on Twitter."));

        panel.add(b);
        panel.add(c);
        panel.add(d);
        panel.add(x);
        panel.add(y);
        panel.add(z);
        panel.add(q);
    }

    public JPanel getPanel(){
        return panel;
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



