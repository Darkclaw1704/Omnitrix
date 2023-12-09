package com.example.test_2;

import java.io.Serializable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game {
    private static int highScore=0;
    private Scene gameScene;
    private static int cherries =1;

    public static int getHighScore() {
        return highScore;
    }

    public static void setHighScore(int highScore) {
        Game.highScore = highScore;
    }

    private GameData gd=new GameData();

    public Scene getGameScene() {
        return gameScene;
    }

    public GameData getGd() {
        return gd;
    }

    public void setGd(GameData gd) {
        this.gd = gd;
    }

    RandomPillarGenerator rpg =new RandomPillarGenerator();
    private Pane topLayerPane = new Pane();

    public Pane getTopLayerPane() {
        return topLayerPane;
    }

    public Scene createGame(Stage stage, int score) {
        gd.setScore(score);
        AtomicBoolean flag = new AtomicBoolean(true);
        StackPane mainStackPane = new StackPane();
        VBox mainVBox = new VBox();
        Image backgroundImage = new Image("file:gameScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        mainStackPane.setBackground(new Background(new BackgroundImage[]{background}));

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.TOP_RIGHT);
        Rectangle transparentRectangle1 = new Rectangle(50.0, 320.0);
        transparentRectangle1.setFill(Color.TRANSPARENT);
        hbox1.getChildren().add(transparentRectangle1);



        Font customFont = Font.loadFont(Game.class.getResourceAsStream("file:Vermin Vibes 1989.ttf"), 12.0);
        Label scoreLabel = new Label(" SCORE \n     " + gd.getScore());
        scoreLabel.setStyle("-fx-text-fill: white; -fx-font-family: 'Vermin Vibes 1989'; -fx-font-size: 25;");
        hbox1.getChildren().add(scoreLabel);
        Image scoreBoard = new Image("file:scoreBoard.png");
        ImageView scoreImage = new ImageView(scoreBoard);
        scoreImage.setFitWidth(200.0);
        scoreImage.setFitHeight(100.0);
        StackPane scoreStackPane = new StackPane();
        scoreStackPane.getChildren().addAll(new Node[]{scoreImage, scoreLabel});
        StackPane.setAlignment(scoreStackPane, Pos.CENTER);
        hbox1.getChildren().add(scoreStackPane);
        Rectangle transparentRectangle2 = new Rectangle(50.0, 320.0);
        transparentRectangle2.setFill(Color.TRANSPARENT);

        Label label = new Label("\n" + Cherry.getCherryCount());
        label.setStyle("-fx-text-fill: white; -fx-font-size: 16; -fx-font-weight: bold;");
        hbox1.getChildren().add(label);
        Image dragon_fruit = new Image("file:dragon_fruit.png");
        ImageView fruit = new ImageView(dragon_fruit);
        fruit.setFitWidth(70.0);
        fruit.setFitHeight(70.0);
        hbox1.getChildren().add(fruit);
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.BOTTOM_LEFT);
        hbox2.getChildren().add(rpg.getFirstPillar().getStackPane());
        gd.getSpacer2().setMinWidth(200.0);
        hbox2.getChildren().add(gd.getSpacer2());

        rpg.createNewPillar();
        hbox2.getChildren().add(rpg.getSecondPillar().getStackPane());
        mainVBox.getChildren().addAll(new Node[]{hbox1, hbox2});
        mainStackPane.getChildren().addAll(new Node[]{mainVBox, topLayerPane});
        Image pauseButtonImage = new Image("file:pause.png");
        Button pauseButton = new Button("", new ImageView(pauseButtonImage));
        pauseButton.setStyle("-fx-text-fill: white; -fx-background-color: #9937bb;");
        pauseButton.setOnAction(e -> {
            ScreenFactory sf = new ScreenFactory();
            stage.setScene(sf.getScreen("PAUSESCREEN",stage,Game.this).getScene());
        });
        pauseButton.setLayoutX(10.0);
        pauseButton.setLayoutY(10.0);
        topLayerPane.getChildren().add(pauseButton);
        topLayerPane.getChildren().add(gd.getStick().getStackPane());
        topLayerPane.getChildren().add(gd.getCherry());
        topLayerPane.getChildren().add(gd.getZoro());
        topLayerPane.setOnMousePressed((event) -> {
            if (flag.get()) {
                gd.getStick().startTimer();
            }

        });
        topLayerPane.setOnMouseReleased((event) -> {
            Timer timer =new Timer();
            Timer timer2 =new Timer();
            TimerTask task =new TimerTask() {
                @Override
                public void run() {
//                    System.out.println("task");
                    gd.getZoro().fall();
                    gd.getStick().rotate();
                }
                };

            TimerTask task2 =new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                        ScreenFactory sf = new ScreenFactory();
                        stage.setScene( sf.getScreen("ENDSCREEN",stage,Game.this).getScene());
                    });

                }
            };

            TimerTask task3 =new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> {
                    Game newGame = new Game();
                        newGame.createGame(stage,gd.getScore()+1);
                        newGame.gd.setScore(gd.getScore()+1);
//                        hbox1.getChildren()
                    stage.setScene(newGame.getGameScene());
                });

                }
            };



            if (flag.get()) {
                gd.getStick().rotate();
//                System.out.println("shift");

                topLayerPane.setOnMousePressed((event1) -> {
                    gd.getZoro().flip();
                });

                if(!gd.getZoro().move(this, stage)){
                    timer.schedule(task, 2500);
                    timer2.schedule(task2, 4500);
                    if(gd.getScore()>Game.highScore){
                        Game.setHighScore(gd.getScore());
                    }
                } else{

                        timer.schedule(task3,3750);

                }


            }

            gd.getStick().stopTimer();


            flag.set(false);
        });

        gameScene =new Scene(mainStackPane, 360.0, 640.0);
        return gameScene;
    }

    private static double generateRandomWidth(double min, double max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}

