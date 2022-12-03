package usecases.userresponsemodel;

import javax.swing.*;
import java.util.Date;

public class DrinkResponseModel {
    public DrinkResponseModel(Float price, Integer volume, Date productionDate,
                              Date expirationDate, Float discount) {
        String message;
        if (price == -1.0f) {
            message = "Price must be a float!";
        } else if (volume == -1) {
            message = "Volume must be an integer!";
        } else if (productionDate == null) {
            message = "Production date is not in the correct format!";
        } else if (expirationDate == null) {
            message = "Expiration date is not in the correct format!";
        } else if (discount == -1.0f) {
            message = "Discount must be a float!";
        } else {
            message = "Drink added successfully!";
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
