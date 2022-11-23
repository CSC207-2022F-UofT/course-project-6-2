package Screens;

import UseCases.UserUseCases.CustomerButton.*;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CustomerServiceScreen{
    /* setup frame*/
    public static void main(String[] args) {
        JFrame frame = new JFrame("Frequently Asked Questions");
        JPanel panel = new JPanel();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        /* first question & answer*/
        JButton b = new JButton("How can I sell my product in your store?");
        b.setBounds(50, 150, 700, 30);
        frame.add(b);
        ActionListener myButton = new Q0();
        b.addActionListener(myButton);

        /* 2nd question & answer*/
        JButton c = new JButton("Where can I collect reward points with my purchase?");
        c.setBounds(50, 200, 700, 30);
        frame.add(c);
        ActionListener myButtonListener = new Q1();
        c.addActionListener(myButtonListener);


        /* 3rd question & answer*/
        JButton d = new JButton(" Does your store offer birthday specials? ");
        d.setBounds(50, 250, 700, 30);
        frame.add(d);
        ActionListener myButtonListener2 = new Q2();
        d.addActionListener(myButtonListener2);


        /* 4th question & answer*/
        JButton x = new JButton("How do I know if my order is placed?");
        x.setBounds(50, 300, 700, 30);
        frame.add(x);
        ActionListener myButtonListener3 = new Q3();
        x.addActionListener(myButtonListener3);

        /* 5th question & answer*/
        JButton y = new JButton(" How much does it cost to ship items? ");
        y.setBounds(50, 350, 700, 30);
        frame.add(y);
        ActionListener myButtonListener4 = new Q4();
        y.addActionListener(myButtonListener4);

        /* 6th question & answer*/
        JButton z = new JButton(" What items can not be sold in your app? ");
        z.setBounds(50, 400, 700, 30);
        frame.add(z);
        ActionListener myButtonListener5 = new Q5();
        z.addActionListener(myButtonListener5);

        /* 6th question & answer*/
        JButton q = new JButton(" Need More Help? ");
        q.setBounds(50, 450, 700, 30);
        frame.add(q);
        ActionListener myButtonListener6 = new NeedMoreHelp();
        q.addActionListener(myButtonListener6);

        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}


