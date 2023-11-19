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

        Button playButton = new Button("Play New");
        Button newButton = new Button("Saved Games");
        Button noAdsButton = new Button("Sound");
        Button settingsButton = new Button("Settings");
        Button helpButton = new Button("Help");

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

        Label title = new Label("STICK HERO");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");

        Pane spacer = new Pane();
        spacer.setMinHeight(100);

        VBox menuLayout = new VBox(10);
        menuLayout.getChildren().addAll(title, spacer, playButton, newButton, noAdsButton, settingsButton, helpButton);
        menuLayout.setAlignment(Pos.CENTER); // Center alignment

        Image backgroundImage = new Image("file:mainMenuImage.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        menuLayout.setBackground(new Background(background));

        Scene scene = new Scene(menuLayout, 360, 640);

        primaryStage.setTitle("Stick Hero Main Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}