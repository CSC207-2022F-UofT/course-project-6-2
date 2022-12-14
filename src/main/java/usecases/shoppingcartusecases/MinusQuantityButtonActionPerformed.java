package usecases.shoppingcartusecases;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The minus quantity button action performed use case is used when the seller clicks the minus button in the shopping
 * cart panel and wants to decrease the quantity of an item.
 */
public class MinusQuantityButtonActionPerformed {

    public static float minusQuantityActionPerformed(Vector<String> headers, JTable table,
                                                     ArrayList<Float> totalAmount, float total) {

        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();
        DecimalFormat df = new DecimalFormat("0.00");

        float quantity = Float.parseFloat(table.getValueAt(row, column).toString());
        total -= totalAmount.get(row);
        if (quantity == 1) {
            ((DefaultTableModel)table.getModel()).removeRow(row);
            totalAmount.remove(row);
            JOptionPane.showMessageDialog(null, "Sorry, you can not delete anymore drinks");
        } else {
            table.setValueAt(quantity -= 1, row, column);
            totalAmount.add(Float.parseFloat(table.getValueAt(row, 5).toString()));

            for (int i = 0; i < totalAmount.size(); i++) {
                float newVal = quantity * Float.parseFloat(table.getValueAt(row, 5).toString());
                table.setValueAt(df.format(newVal), row, 6);
            }
        }

        return total;
    }
}
