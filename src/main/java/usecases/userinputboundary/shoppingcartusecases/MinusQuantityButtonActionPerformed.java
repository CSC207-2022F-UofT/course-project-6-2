package usecases.userinputboundary.shoppingcartusecases;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class MinusQuantityButtonActionPerformed {

    public static float minusQuantityActionPerformed(ActionEvent e, Vector<String> headers, JTable table, JButton minusQuantity,
                                                     ArrayList<Float> totalAmount, DecimalFormat df, float total) {


        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();

        if (e.getSource() == minusQuantity) {
            float quantity = Float.parseFloat(table.getValueAt(row, column).toString());
            if (quantity > 0) {
                table.setValueAt(quantity -= 1, row, column);
                total -= totalAmount.get(row);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Sorry, you can not delete anymore drinks");
            }

            totalAmount.add(Float.parseFloat(table.getValueAt(row, 5).toString()));

            for (int i = 0; i < totalAmount.size(); i++) {
                float newVal = quantity * Float.parseFloat(table.getValueAt(row, 5).toString());
                table.setValueAt(df.format(newVal), row, 6);
            }
        }
        return total;

    }
}
