package UseCases.OrderUseCases;

import Helpers.Deserializer;
import Entities.Users.Seller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckTotalOrder {
    public int checkTotalOrder() throws IOException, ClassNotFoundException {
        Deserializer deserializer = new Deserializer();
        deserializer.deserialize("./data/users");
        ArrayList<HashMap> data = (ArrayList<HashMap>) deserializer.getObject();
        if (data != null && data.get(0).size() != 0) {
            Iterator<Map.Entry<String, Seller>> iterator = data.get(0).entrySet().iterator();
            Map.Entry<String, Seller> entry = iterator.next();

            if (entry.getValue().getAllOrders().size() != 0) return entry.getValue().getAllOrders().get(0).getTotalOrder();
            else return 0;
        }
        else {
            return 0;
        }
    }
}
