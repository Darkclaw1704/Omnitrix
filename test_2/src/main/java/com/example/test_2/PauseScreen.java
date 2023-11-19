package com.example.test_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class PauseScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
        @Override
    public void start(Stage primaryStage) {

        Button continueButton = new Button("Continue");
        Button playAgainButton = new Button("Play Again");
        Button saveGameButton = new Button("Save Game");
        Button mainMenuButton = new Button("Main Menu");
        Button soundButton = new Button("Sound");
        Button helpButton = new Button("Help");

        continueButton.setPrefSize(200, 50);
        continueButton.setStyle("-fx-font-size: 20px;");
        playAgainButton.setPrefSize(200, 50);
        playAgainButton.setStyle("-fx-font-size: 20px;");
        saveGameButton.setPrefSize(200, 50);
        saveGameButton.setStyle("-fx-font-size: 20px;");
        mainMenuButton.setPrefSize(200, 50);
        mainMenuButton.setStyle("-fx-font-size: 20px;");
        soundButton.setPrefSize(200, 50);
        soundButton.setStyle("-fx-font-size: 20px;");
        helpButton.setPrefSize(200, 50);
        helpButton.setStyle("-fx-font-size: 20px;");

        Label title = new Label("  GAME \nPAUSED");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");

        Pane spacer = new Pane();
        spacer.setMinHeight(50);

        VBox menuLayout = new VBox(10);
        menuLayout.getChildren().addAll(title, spacer, continueButton, playAgainButton, saveGameButton, mainMenuButton, soundButton, helpButton);
        menuLayout.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("file:pauseScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        menuLayout.setBackground(new Background(background));

        Scene scene = new Scene(menuLayout, 360, 640);

        primaryStage.setTitle("Stick Hero Game Paused");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
