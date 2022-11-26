package UseCases.UserUseCases;

import Helpers.Deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// Use Cases Layer

public class ConstructUserDataBase {
    private static final Deserializer userDeserializer = new Deserializer();

    /**
     * constructUserDataBase: Extract data from database and store to users HashMap
     */

    public static void constructUserDataBase() throws IOException, ClassNotFoundException {
        userDeserializer.deserialize("./data/users");
        ArrayList<HashMap> data = (ArrayList<HashMap>) userDeserializer.getObject();
        if (data != null) {
            CreateUserHashMap.sellers = data.get(0);
            CreateUserHashMap.customers = data.get(1);
        }
    }
}
