package Screens;

import Entities.Drink;
import UseCases.SearchDrinks;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.Vector;

public class SearchingDrinksScreen extends JFrame {

    JPanel northPanel = new JPanel();
    JTextField search_box = new JTextField(20);
    JButton searchBtn = new JButton("Search");

    JPanel southPanel = new JPanel();
    JTextField drink_name = new JTextField(10);

    JTextField store_name = new JTextField(10);
    JTextField drink_quantity = new JTextField(10);
    JButton addBtn = new JButton("Add to shopping cart");

    SearchingTable myFrameTable = new SearchingTable();

    public SearchingDrinksScreen(){
        super("Main page of searching");
        Container contentPane = getContentPane();
        northPanel.add(search_box);
        northPanel.add(searchBtn);
        contentPane.add(northPanel, BorderLayout.NORTH);
        layoutCenter(contentPane);
        southPanel.add(drink_name);
        drink_name.setText("Input a drink name");
        southPanel.add(store_name);
        store_name.setText("Input the store name of drink");
        southPanel.add(drink_quantity);
        drink_quantity.setText("Input quantity");
        southPanel.add(addBtn);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchingDrinksScreen();
    }

    private void layoutCenter(Container contentPane){
        Vector<Vector<Drink>> data = SearchDrinks.Add_to_Filtered(search_box.getText().trim());
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchingTableModel searchingTableModel = SearchingTableModel.assembleModel(data);
                myFrameTable.setModel(searchingTableModel);
            }
        });


        JScrollPane jScrollPane = new JScrollPane(myFrameTable);
        contentPane.add(jScrollPane,BorderLayout.CENTER);
    }
}
