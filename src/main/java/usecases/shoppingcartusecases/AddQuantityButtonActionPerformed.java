package usecases.shoppingcartusecases;

import javax.swing.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class AddQuantityButtonActionPerformed {
    public static float addQuantityActionPerformed(Vector<String> headers, JTable table,
                                                   ArrayList<Float> totalAmount, float total) {

        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();
        DecimalFormat df = new DecimalFormat("0.00");

        float quantity = Float.parseFloat(table.getValueAt(row, column).toString());
        table.setValueAt(quantity += 1, row, column);

        for (int i = 0; i < totalAmount.size(); i++) {
            float newVal = quantity * Float.parseFloat(table.getValueAt(row, 5).toString());

            table.setValueAt(df.format(newVal), row, 6);
        }
        total += totalAmount.get(row);

        return total;
    }
}
