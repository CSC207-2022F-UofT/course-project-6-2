package screens;

import screens.loginregisterscreens.FirstMainScreen;
import usecases.databaseusecases.ConstructDrinkDataBase;
import usecases.databaseusecases.ConstructUserDataBase;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConstructUserDataBase.constructUserDataBase();
        ConstructDrinkDataBase.constructDrinkDataBase();
        new FirstMainScreen();
    }
}
