package usecases.userusercases;

import helpers.Deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

// Use Cases Layer

public class ConstructUserDataBase {
    private static final Deserializer userDeserializer = new Deserializer();

    /**
     * constructUserDataBase: Extract data from database and store to users HashMap
     */

    @SuppressWarnings("unchecked")
    public static void constructUserDataBase() throws IOException, ClassNotFoundException {
        userDeserializer.deserialize("./data/users");
        ArrayList<HashMap> data = (ArrayList<HashMap>) userDeserializer.getObject();
        if (data != null) {
            UserRuntimeDataBase.sellers = data.get(0);
            UserRuntimeDataBase.customers = data.get(1);
        }
    }
}
