package screens;

import screens.loginregisterscreens.LoginScreen;
import usecases.drinkusecases.ConstructDrinkDataBase;
import usecases.userusercases.ConstructUserDataBase;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConstructUserDataBase.constructUserDataBase();
        ConstructDrinkDataBase.constructDrinkDataBase();
        new LoginScreen();
    }
}
