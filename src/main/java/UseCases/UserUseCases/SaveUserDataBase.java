package UseCases.UserUseCases;

import Helpers.Serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// Use Cases Layer

public class SaveUserDataBase {
    private static final Serializer userSerializer = new Serializer();
    /**
     * saveUserDataBase: Store users HashMap data to database
     */
    public static void saveUserDataBase() throws IOException {
        ArrayList<HashMap> users = new ArrayList<HashMap>(
                Arrays.asList(CreateUserHashMap.sellers, CreateUserHashMap.customers)
        );
        userSerializer.serialize("./data/users", users);
    }
}
