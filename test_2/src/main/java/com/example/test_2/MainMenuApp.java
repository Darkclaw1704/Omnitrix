package com.example.test_2;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainMenuApp extends Application {

    private static Scene mainMenuScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        createMainMenu(primaryStage);
    }

    public Scene createMainMenu(Stage primaryStage) {
        Button playButton = new Button("Play New Game");
        playButton.setPrefSize(200, 50);
        playButton.setStyle("-fx-font-size: 20px;");

        Label title = new Label("STICK HERO");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");

        Pane spacer = new Pane();
        spacer.setMinHeight(100);

        VBox menuLayout = new VBox(10);
        menuLayout.getChildren().addAll(title, spacer, playButton);
        menuLayout.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("file:mainMenuImage.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        menuLayout.setBackground(new Background(background));

        Scene scene = new Scene(menuLayout, 360, 640);

        addMovingPixelEffect(title);

        playButton.setOnAction(e -> {
            Scene sceneForGame = new Game().createGame(primaryStage, 0);
            primaryStage.setScene(sceneForGame);
        });

        primaryStage.setTitle("Stick Hero Main Menu");
        primaryStage.setScene(scene);
        setMainMenuScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        return scene;
    }

    private void addMovingPixelEffect(Label text) {
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(text.translateXProperty(), -100)),
                new KeyFrame(Duration.seconds(2), new KeyValue(text.translateXProperty(), 100)),
                new KeyFrame(Duration.seconds(4), new KeyValue(text.translateXProperty(), 0)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public static Scene getMainMenuScene() {
        return mainMenuScene;
    }

    public void setMainMenuScene(Scene mainMenuScene) {
        this.mainMenuScene = mainMenuScene;
    }
}