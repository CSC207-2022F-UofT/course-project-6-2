package usecases.drinkusecases;

import javax.swing.*;
import java.util.ArrayList;

public class GetSumOfDrinks {
    public static float getSumOfDrinks(JTable table, ArrayList<Float> totalAmount, float total){
        for (int i = 0; i < table.getRowCount(); i++) {

            float newVal = Float.parseFloat(table.getValueAt(i, 3).toString()) *
                    Float.parseFloat(table.getValueAt(i, 5).toString());
            table.setValueAt((newVal * 100) / 100, i, 6);

            totalAmount.add((float) table.getValueAt(i, 6));
            total += totalAmount.get(i);
        }
        return total;
    }
}