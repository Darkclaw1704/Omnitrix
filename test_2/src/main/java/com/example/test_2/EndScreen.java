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

        Image playAgainImage = new Image("file:playAgainImage.png");
        Image favourite = new Image("file:favourite.png");
        Image leaderboard = new Image("file:leaderboard.png");
        Image home = new Image("file:home.png");

        double maxWidth = Math.max(Math.max(playAgainImage.getWidth(), favourite.getWidth()), Math.max(leaderboard.getWidth(), home.getWidth()));
        double maxHeight = Math.max(Math.max(playAgainImage.getHeight(), favourite.getHeight()), Math.max(leaderboard.getHeight(), home.getHeight()));

        Button playAgainButton = new Button("", new ImageView(playAgainImage));
        Button saveGameButton = new Button("", new ImageView(favourite));
        Button homeButton = new Button("", new ImageView(home));
        Button leaderboardButton = new Button("", new ImageView(leaderboard));

        playAgainButton.setPrefSize(maxWidth, maxHeight);
        saveGameButton.setPrefSize(maxWidth, maxHeight);
        homeButton.setPrefSize(maxWidth, maxHeight);
        leaderboardButton.setPrefSize(maxWidth, maxHeight);

        Label title = new Label(" GAME \nOVER!!");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");

        Rectangle rectangle = new Rectangle(250, 200, Color.LIGHTGRAY);

        Pane spacer = new Pane();
        spacer.setMinHeight(50);

        Pane spacer2 = new Pane();
        spacer2.setMinHeight(50);

        HBox menuLayout = new HBox(10);
        menuLayout.getChildren().addAll(homeButton, leaderboardButton, saveGameButton, playAgainButton);
        menuLayout.setAlignment(Pos.CENTER);

        Label rectangleLabel = new Label("SCORE\n    0  \n BEST\n    3");
        rectangleLabel.setStyle("-fx-font-size: 25px; -fx-font-weight: bold;");
        rectangleLabel.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, rectangleLabel);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(title, spacer, stackPane, spacer2, menuLayout);
        vBox.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("file:endScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(background));

        Scene scene = new Scene(vBox, 360, 640);

        primaryStage.setTitle("Stick Hero Game Paused");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}