package UseCases;

import javax.swing.*;
import java.util.ArrayList;

public class GetSumOfDrinks {

    public Double getSumOfDrinks(JTable table, Double discountedVal, Double newVal, ArrayList<Double> totalAmount,
                                 Double total){

        for (int i = 0; i < table.getRowCount(); i++) {
            discountedVal = ((Double) table.getValueAt(i, 1) * (Double) table.getValueAt(i, 2));
            table.setValueAt((discountedVal *100)/100, i, 4);

            newVal = ((Double)table.getValueAt(i, 3) * (Double)table.getValueAt(i, 4));
            table.setValueAt((newVal*100)/100, i, 5);

            totalAmount.add((Double)table.getValueAt(i, 5));
            total += totalAmount.get(i);
        }

        return total;
    }
}
