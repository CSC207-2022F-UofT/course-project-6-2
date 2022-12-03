package usecases.shoppingcartusecases;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class AddQuantityButtonActionPerformed {
    public static float addQuantityActionPerformed(ActionEvent e, Vector<String> headers, JTable table, JButton addQuantity,
                                                   ArrayList<Float> totalAmount, DecimalFormat df,
                                                  float total) {

        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();

        if (e.getSource() == addQuantity) {
            float quantity = Float.parseFloat(table.getValueAt(row, column).toString());
            table.setValueAt(quantity += 1, row, column);

            for (int i = 0; i < totalAmount.size(); i++) {
                float newVal = quantity * Float.parseFloat(table.getValueAt(row, 4).toString());
                table.setValueAt(df.format(newVal), row, 5);
            }
            total += totalAmount.get(row);
        }

        return total;
    }
}
