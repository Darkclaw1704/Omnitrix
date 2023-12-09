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

public class EndScreen extends Screen{
    private static EndScreen instance;

    private EndScreen() {
    }

    public static EndScreen getInstance(){
        if(instance==null){
            instance= new EndScreen();
        }

        return instance;
    }

    @Override
    public EndScreen createScreen(Stage primaryStage, Game game) {

        Image playAgainImage = new Image("file:playAgainImage.png");
        Image revive = new Image("file:favourite.png");
        Image home = new Image("file:home.png");

        double maxWidth = Math.max(Math.max(playAgainImage.getWidth(), revive.getWidth()),  home.getWidth());
        double maxHeight = Math.max(Math.max(playAgainImage.getHeight(), revive.getHeight()), home.getHeight());

        Button playAgainButton = new Button("", new ImageView(playAgainImage));
        Button reviveButton = new Button("", new ImageView(revive));
        Button mainMenuButton = new Button("", new ImageView(home));

        playAgainButton.setPrefSize(maxWidth, maxHeight);
        reviveButton.setPrefSize(maxWidth, maxHeight);
        mainMenuButton.setPrefSize(maxWidth, maxHeight);

        mainMenuButton.setOnAction(e -> {
            Scene mainMenuScene = MainMenuApp.getMainMenuScene();
            primaryStage.setScene(mainMenuScene);
        });
        reviveButton.setOnAction(e -> {
            if(Cherry.getCherryCount() >=1 ) {
                Cherry.setCherryCount(Cherry.getCherryCount()-1);
                Game newGame = new Game();
                newGame.createGame(primaryStage,game.getGd().getScore());
                primaryStage.setScene(newGame.getGameScene());
            }
        });
        playAgainButton.setOnAction(e -> {

            Game newGame = new Game();
            newGame.createGame(primaryStage,0);
            primaryStage.setScene(newGame.getGameScene());

        });

        Label title = new Label(" GAME \nOVER!!");
        title.setStyle("-fx-font-size: 50px; -fx-font-weight: bold; -fx-text-fill: white; -fx-stroke: black; -fx-stroke-width: 2;");

        Rectangle rectangle = new Rectangle(250, 200, Color.TRANSPARENT);

        Pane spacer = new Pane();
        spacer.setMinHeight(50);

        Pane spacer2 = new Pane();
        spacer2.setMinHeight(50);

        HBox menuLayout = new HBox(10);
        menuLayout.getChildren().addAll(mainMenuButton, reviveButton, playAgainButton);//, leaderboardButton
        menuLayout.setAlignment(Pos.CENTER);

        Label rectangleLabel = new Label("     YOUR SCORE\n                "+game.getGd().getScore()
                +"  \n YOUR BEST SCORE\n                "+Game.getHighScore()
                +"\n      LAST SCORE\n                "+Game.getLastScore());
        Game.setLastScore(game.getGd().getScore());
        rectangleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: white;");
        rectangleLabel.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, rectangleLabel);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(title, spacer, stackPane, spacer2, menuLayout);
        vBox.setAlignment(Pos.CENTER);

        Image backgroundImage = new Image("file:endScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vBox.setBackground(new Background(background));

        this.setScene(new Scene(vBox, 360, 640));
        return this;

    }

}