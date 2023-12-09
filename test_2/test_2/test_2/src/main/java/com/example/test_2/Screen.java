package com.example.test_2;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Screen {
    private static Screen instance;
    private Scene scene;

    protected Screen() {
    }

    public static Screen getInstance(){
        if(instance==null){
            throw new RuntimeException("Instance should be initialized in subclass");
        }
        return instance;
    }

    public abstract Screen createScreen(Stage primaryStage, Game game);

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }
}