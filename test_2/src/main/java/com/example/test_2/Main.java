package com.example.test_2;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        MainMenuApp mainMenu = new MainMenuApp();
        mainMenu.createMainMenu(stage);
    }
}
