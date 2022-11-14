package CustomerService;

import javax.swing.*;

public class CustomerService {
    public static void main(String[] args) {
    JFrame f=new JFrame("Frequently Asked Questions");
    JTextField tf=new JTextField();
    tf.setBounds(50,50, 2000,30);
    JButton b=new JButton("How can I sell my product in your store");
    b.setBounds(50,100,1000,30);
    b.addActionListener(e -> tf.setText("Register on our web for the flexibility to sell one item or thousands.\n" +
            "Fulfill orders quickly when customers make a purchase."));
    JButton c=new JButton("Where can I collect reward points with my purchase?");
    c.setBounds(50,150,1000,30);
    c.addActionListener(e -> tf.setText("Sorry, currently we do not offer any reward points"));
    JButton d =new JButton(" Does your store offer birthday specials? ");
    d.setBounds(50,200,1000,30);
    d.addActionListener(e -> tf.setText("Sorry, currently we do not offer " +
            "any birthday special or reward programs. "));
    JButton x =new JButton("How do I know if my order is placed?");
    x.setBounds(50,250,1000,30);
    x.addActionListener(e -> tf.setText("Once you place an order on the website, you'll shortly "));
    JButton y =new JButton(" How much does it cost to ship items? ");
    y.setBounds(50,300,1000,30);
    y.addActionListener(e -> tf.setText("Shipping fees depend on whether you plan to fulfill orders yourself," +
            " use a combination of shipping options. "));

    JButton z =new JButton(" What items can not be sold in your store? ");
    z.setBounds(50,350,1000,30);
    z.addActionListener(e -> tf.setText("Some products may not be listed as a matter of " +
            "compliance with legal or regulatory restrictions (for example, prescription drugs). "));
    f.add(b);f.add(c);f.add(d);f.add(x);f.add(y);f.add(z);
    f.add(tf);
    f.setSize(400,400);
    f.setLayout(null);
    f.setVisible(true);
}
}



