package com.example.test_2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Stick extends Rectangle implements Serializable {

    private StackPane stackPane = new StackPane(this);
    private Timeline timeline;



    public Stick() {
        this.setFill(Color.BLACK);
        this.setStroke(Color.WHITE);
//        this.setHeight(45);
        this.setWidth(5);
        Rotate rt= new Rotate();
        rt.setAngle(180);
        this.getTransforms().add(rt);
        getStackPane().setLayoutX(29);  // Set initial X coordinate
        getStackPane().setLayoutY(320); // Set initial Y coordinate


    }

    public StackPane getStackPane() {
        return stackPane;
    }

    public void startTimer() {

        timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            // Increase the height of the stick based on the timer
            double increase = 1.5; // Adjust this value as needed
            this.setHeight(this.getHeight() + increase);
            this.setLayoutY(this.getY() - 1*increase);


        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void rotate(){
        Rotate rt = new Rotate();
        rt.setAngle(1.0);
        AtomicInteger count = new AtomicInteger(0);
        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(10.0),(event1) -> {
            getTransforms().add(rt);
            count.getAndIncrement();
        }));
        timeline1.setCycleCount(-1);
        timeline1.play();
        (new Timeline(new KeyFrame(Duration.millis(900.0), (event2) -> {
            timeline1.stop();
        }))).play();}

    public void stopTimer() {
        if (timeline != null) {
            timeline.stop();
        }
    }



}