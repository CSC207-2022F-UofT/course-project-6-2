package Helpers;

import java.io.*;

public class Deserializer {
    Serializable obj;

    /**
     * deserialize: Extract an object from the given file path
     * @param path A String input indicates the file path to deserialize
     */
    public void deserialize(String path) throws ClassNotFoundException, IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            obj = (Serializable) ois.readObject();
            ois.close();
        } catch (InvalidClassException e) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)); // Clear the file if its corrupted
            oos.writeObject("");
            oos.flush();
            oos.close();
        } catch (EOFException e) {
            // Do nothing
        }
    }

    /**
     * getObject: Returns the deserialized object
     * @return A deserialized object from the file given
     */
    public Serializable getObject() {
        return obj;
    }
}