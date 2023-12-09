package com.example.test_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

//Singleton Class
public class PauseScreen extends Screen {
    private static PauseScreen instance;
    private Scene scene;
    private PauseScreen() {
        super();
    }

    public static PauseScreen getInstance(){
        if(instance==null){
            instance= new PauseScreen();
        }
        return instance;
    }

    @Override
    public PauseScreen createScreen(Stage primaryStage, Game game) {

        Button continueButton = new Button("Continue");
        Button playAgainButton = new Button("Play Again");
        Button mainMenuButton = new Button("Main Menu");


        continueButton.setPrefSize(200, 50);
        continueButton.setStyle("-fx-font-size: 20px;");
        playAgainButton.setPrefSize(200, 50);
        playAgainButton.setStyle("-fx-font-size: 20px;");
        mainMenuButton.setPrefSize(200, 50);
        mainMenuButton.setStyle("-fx-font-size: 20px;");
//        soundButton.setPrefSize(200, 50);
//        soundButton.setStyle("-fx-font-size: 20px;");
//        helpButton.setPrefSize(200, 50);
//        helpButton.setStyle("-fx-font-size: 20px;");

        Label title = new Label("  GAME \nPAUSED");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");

        Pane spacer = new Pane();
        spacer.setMinHeight(50);

        mainMenuButton.setOnAction(e -> {
            Scene mainMenuScene = MainMenuApp.getMainMenuScene();
            primaryStage.setScene(mainMenuScene);
        });
        continueButton.setOnAction(e -> {
            Scene gameScene = game.getGameScene();
            primaryStage.setScene(gameScene);
        });
        playAgainButton.setOnAction(e -> {
            Game newGame = new Game();
            newGame.createGame(primaryStage,0);
            primaryStage.setScene(newGame.getGameScene());
        });

//        saveGameButton.setOnAction(e -> {
//            try {
//                Main.serialize(game.getGd());
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
        VBox menuLayout = new VBox(10);
        menuLayout.getChildren().addAll(title, spacer, continueButton, playAgainButton, mainMenuButton);//, soundButton, helpButton
        menuLayout.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("file:pauseScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        menuLayout.setBackground(new Background(background));

        scene = new Scene(menuLayout, 360, 640);

        return this;

    }

    public Scene getScene() {
        return scene;
    }
}