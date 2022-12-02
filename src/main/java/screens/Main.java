package screens;

import screens.loginregisterscreens.FirstMainScreen;
import usecases.databaseusecases.*;

import java.io.IOException;

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
