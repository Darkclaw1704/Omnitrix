package com.example.test_2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

public class Ninja extends ImageView implements Serializable {
    private boolean flag =true;
    TranslateTransition tt = new TranslateTransition();

    public Ninja() {
        super(new Image("file:ninja_highlighted.png"));
        setFitWidth(30);
        setFitHeight(40);
        setX(9);
        setY(320-45);
    }

    public void flip(){

        this.setScaleY(-1*this.getScaleY());
        if(flag) {
            this.setTranslateY(this.getFitHeight());

        }
        else{
//            System.out.println("else");
            this.setTranslateY(-1*this.getFitHeight()+45);
        }
        flag=!flag;

    }


    public boolean move(Game game, Stage stage){

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10.0),(event1) -> {
            this.setX(getX()+1);
            if((this.getX()==game.getGd().getCherry().getX())&&(!this.flag)){
                Cherry.setCherryCount(Cherry.getCherryCount()+1);
                game.getTopLayerPane().getChildren().remove(game.getGd().getCherry());
            }

        }));
        timeline1.setCycleCount(-1);
        timeline1.play();
        if((game.getGd().getStick().getHeight()>game.getGd().getSpacer2().getWidth() && game.getGd().getStick().getHeight()<game.getGd().getSpacer2().getWidth()+game.rpg.getSecondPillar().getWidth())){

        (new Timeline(new KeyFrame(Duration.millis((game.getGd().getSpacer2().getWidth()+game.rpg.getSecondPillar().getWidth())*10), (event2) -> {

            timeline1.stop();
        }))).play();

            return true;
        }
        else if (game.getGd().getStick().getHeight()>300) {
            (new Timeline(new KeyFrame(Duration.millis((300)*10), (event2) -> {
                timeline1.stop();
            }))).play();
        } else{
            (new Timeline(new KeyFrame(Duration.millis((game.getGd().getStick().getHeight())*10), (event2) -> {
                timeline1.stop();
            }))).play();

        }
        tt.setDelay(Duration.millis(900));
        tt.play();
        return false;

    }

    public void fall(){
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10.0),(event1) -> {
            this.setY(getY()+2);
//            count.getAndIncrement();
        }));
        timeline1.setCycleCount(-1);
        timeline1.play();
        (new Timeline(new KeyFrame(Duration.millis(3200.0), (event2) -> {
            timeline1.stop();
        }))).play();}

    }
