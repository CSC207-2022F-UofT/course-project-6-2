package screens.customerscreens;

import screens.swingcomponents.Button;
import usecases.userresponsemodel.QuestionResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The customer service panel containing question buttons that would provide answers
 */

public class CustomerServicePanel extends JFrame implements ActionListener{
    private final JPanel panel = new JPanel();
    Button question1Button = new Button();
    Button question2Button = new Button();
    Button question3Button = new Button();
    Button question4Button = new Button();
    Button question5Button = new Button();
    Button question6Button = new Button();
    Button question7Button = new Button();

    Button question0Button = new Button();


    public CustomerServicePanel() {
        panel.setLayout(null);

        /* search seller's phone number*/
        question0Button.createButton(panel, "Search sellers phone number",
                50, 50, 700, 30);
        question0Button.addActionListener(this);


        /* first question & answer*/
        question1Button.createButton(panel, "How can I sell my product in your store?",
                50, 100, 700, 30);
        question1Button.addActionListener(this);


        /* 2nd question & answer*/
        question2Button.createButton(panel, "Where can I collect reward points with my purchase?",
                50, 150, 700, 30);
        question2Button.addActionListener(this);

        /* 3rd question & answer*/
        question3Button.createButton(panel, "Does your store offer birthday specials?",
                50, 200, 700, 30);
        question3Button.addActionListener(this);

        /* 4th question & answer*/
        question4Button.createButton(panel, "How do I know if my order is placed?",
                50, 250, 700, 30);
        question4Button.addActionListener(this);

        /* 5th question & answer*/
        question5Button.createButton(panel, "How much does it cost to ship items?",
                50, 300, 700, 30);
        question5Button.addActionListener(this);

        /* 6th question & answer*/
        question6Button.createButton(panel, "What items can not be sold in your app?",
                50, 350, 700, 30);
        question6Button.addActionListener(this);

        /* 7th question & answer*/
        question7Button.createButton(panel, "Need More Help?",
                50, 400, 700, 30);
        question7Button.addActionListener(this);
    }

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == question1Button.button) {
            new QuestionResponseModel(1);
        }
        if (e.getSource() == question2Button.button) {
            new QuestionResponseModel(2);
        }
        if (e.getSource() == question3Button.button) {
            new QuestionResponseModel(3);
        }
        if (e.getSource() == question4Button.button) {
            new QuestionResponseModel(4);
        }
        if (e.getSource() == question5Button.button) {
            new QuestionResponseModel(5);
        }
        if (e.getSource() == question6Button.button) {
            new QuestionResponseModel(6);
        }
        if (e.getSource() == question7Button.button) {
            new QuestionResponseModel(7);
        }
        if (e.getSource() == question0Button.button) {
            new QuestionResponseModel(0);
        }
    }
}


