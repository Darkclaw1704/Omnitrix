package com.example.test_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EndScreen extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        // Create images
        Image playAgainImage = new Image("file:playAgainImage.png");
        Image favourite = new Image("file:favourite.png");
        Image leaderboard = new Image("file:leaderboard.png");
        Image home = new Image("file:home.png");

        // Determine the size of the largest image
        double maxWidth = Math.max(Math.max(playAgainImage.getWidth(), favourite.getWidth()), Math.max(leaderboard.getWidth(), home.getWidth()));
        double maxHeight = Math.max(Math.max(playAgainImage.getHeight(), favourite.getHeight()), Math.max(leaderboard.getHeight(), home.getHeight()));

        // Create buttons and set images
        Button playAgainButton = new Button("", new ImageView(playAgainImage));
        Button saveGameButton = new Button("", new ImageView(favourite));
        Button homeButton = new Button("", new ImageView(home));
        Button leaderboardButton = new Button("", new ImageView(leaderboard));

        // Set button size to match the largest image
        playAgainButton.setPrefSize(maxWidth, maxHeight);
        saveGameButton.setPrefSize(maxWidth, maxHeight);
        homeButton.setPrefSize(maxWidth, maxHeight);
        leaderboardButton.setPrefSize(maxWidth, maxHeight);

        Label title = new Label(" GAME \nOVER!!");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");


        // Create a big rectangle
        Rectangle rectangle = new Rectangle(250, 200, Color.LIGHTGRAY);

        Pane spacer = new Pane();
        spacer.setMinHeight(50); // Set the height of the spacer

        Pane spacer2 = new Pane();
        spacer2.setMinHeight(50); // Set the height of the spacer

        // Arrange buttons horizontally and center them
        HBox menuLayout = new HBox(10); // Set horizontal spacing
        menuLayout.getChildren().addAll(homeButton, leaderboardButton, saveGameButton, playAgainButton);
        menuLayout.setAlignment(Pos.CENTER); // Center alignment

        // Create a label for the rectangle
        Label rectangleLabel = new Label("SCORE\n    0  \n BEST\n    3");
        rectangleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
        rectangleLabel.setAlignment(Pos.CENTER);

// Create a StackPane to hold the rectangle and label
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, rectangleLabel);

        // Arrange title, rectangle, spacer, and buttons vertically
        VBox vBox = new VBox();
//        vBox.getChildren().addAll(title, spacer, rectangle, spacer2, menuLayout);
        vBox.getChildren().addAll(title, spacer, stackPane, spacer2, menuLayout);
        vBox.setAlignment(Pos.CENTER);



        // Set the background image of the scene
        Image backgroundImage = new Image("file:endScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(background));

        // Create scene
        Scene scene = new Scene(vBox, 360, 640);

        // Set stage properties
        primaryStage.setTitle("Stick Hero Game Paused");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}