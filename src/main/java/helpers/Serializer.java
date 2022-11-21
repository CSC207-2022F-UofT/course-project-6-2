package Helpers;

import java.io.*;

public class Serializer {
    /**
     * serialize: Store an object to a given file path
     * @param filePath A String indicates where to store serialized object at
     * @param obj An serializable object
     */
    public void serialize(String filePath, Serializable obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(obj);
        oos.flush();
        oos.close();
    }
}