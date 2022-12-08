package usecases.shoppingcartusecases;

import presentor.ResponsePresenter;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

public class MinusQuantityButtonActionPerformed {

    public static float minusQuantityActionPerformed(Vector<String> headers, JTable table,
                                                     ArrayList<Float> totalAmount, float total) {


        int column = headers.indexOf("Quantity");
        int row = table.getSelectedRow();
        DecimalFormat df = new DecimalFormat("0.00");

        float quantity = Float.parseFloat(table.getValueAt(row, column).toString());
        if (quantity > 0) {
            table.setValueAt(quantity -= 1, row, column);
            total -= totalAmount.get(row);
        } else {
            new ResponsePresenter("Sorry, you can not delete anymore drinks").messagePresenter();
        }

        totalAmount.add(Float.parseFloat(table.getValueAt(row, 5).toString()));

        for (int i = 0; i < totalAmount.size(); i++) {
            float newVal = quantity * Float.parseFloat(table.getValueAt(row, 5).toString());
            table.setValueAt(df.format(newVal), row, 6);
        }

        return total;

    }
}
