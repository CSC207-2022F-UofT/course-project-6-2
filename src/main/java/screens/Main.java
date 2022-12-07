package screens;

import screens.loginregisterscreens.FirstMainScreen;
import usecases.databaseusecases.*;

import java.io.IOException;

/**
 * This main method is used to run the project can generate the first screen of the project.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConstructUserDataBase.constructUserDataBase();
        ConstructDrinkDataBase.constructDrinkDataBase();

        new FirstMainScreen();

        Thread saveToDatabase = new Thread(() -> {
            try {
                SaveUserDataBase.saveUserDataBase();
                SaveDrinkDataBase.saveDrinkDataBase();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Runtime.getRuntime().addShutdownHook(saveToDatabase);
    }
}
