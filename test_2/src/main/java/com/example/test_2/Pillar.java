package com.example.test_2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pillar extends Rectangle {
    private static Image rectangleImage1 = new Image("file:pillar.png");
    private ImageView imageView = new ImageView(rectangleImage1);
    private StackPane stackPane = new StackPane(imageView, this);

    public Pillar(double x_cord, double width) {
        this.setX(x_cord);
        this.setWidth(width);
        this.setHeight(320);
        this.setFill(Color.TRANSPARENT);
        this.setStroke(Color.WHITE);
        imageView.setFitWidth(width);
        imageView.setFitHeight(320);
    }

    public StackPane getStackPane() {
        return stackPane;
    }
}
