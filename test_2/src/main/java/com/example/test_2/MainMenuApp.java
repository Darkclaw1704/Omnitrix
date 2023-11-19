package com.example.test_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainMenuApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create buttons
        Button playButton = new Button("Play New");
        Button newButton = new Button("Saved Games");
        Button noAdsButton = new Button("Sound");
        Button settingsButton = new Button("Settings");
        Button helpButton = new Button("Help");

        // Set button size and font size
        playButton.setPrefSize(200, 50);
        playButton.setStyle("-fx-font-size: 20px;");
        newButton.setPrefSize(200, 50);
        newButton.setStyle("-fx-font-size: 20px;");
        noAdsButton.setPrefSize(200, 50);
        noAdsButton.setStyle("-fx-font-size: 20px;");
        settingsButton.setPrefSize(200, 50);
        settingsButton.setStyle("-fx-font-size: 20px;");
        helpButton.setPrefSize(200, 50);
        helpButton.setStyle("-fx-font-size: 20px;");

        // Create title
        Label title = new Label("STICK HERO");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");



        // Create a spacer
        Pane spacer = new Pane();
        spacer.setMinHeight(100); // Set the height of the spacer

        // Arrange buttons vertically and center them
        VBox menuLayout = new VBox(10); // Set vertical spacing
        menuLayout.getChildren().addAll(title, spacer, playButton, newButton, noAdsButton, settingsButton, helpButton);
        menuLayout.setAlignment(Pos.CENTER); // Center alignment

        // Set the background image of the scene
        Image backgroundImage = new Image("file:mainMenuImage.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        menuLayout.setBackground(new Background(background));

        // Create scene
        Scene scene = new Scene(menuLayout, 360, 640);

        // Set stage properties
        primaryStage.setTitle("Stick Hero Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}