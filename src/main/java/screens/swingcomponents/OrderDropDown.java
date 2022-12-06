package screens.swingcomponents;

import entities.Drink;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.util.Set;

public class OrderDropDown {
    public Object createOrderDropDownMenu(JTable table, Set<Drink> drinks) {
        TableColumn drinkColumn = table.getColumnModel().getColumn(0);

        JComboBox comboBox = new JComboBox();
        for (Drink drink : drinks) {
            comboBox.addItem(drink);
        }

        drinkColumn.setCellEditor(new DefaultCellEditor(comboBox));
        return comboBox;
    }
}
