package com.example.test_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ThreeDExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Rectangle rect1 = createRectangle(100, 100, Color.BLUE);
        Rectangle rect2 = createRectangle(100, 100, Color.RED);
        Rectangle rect3 = createRectangle(100, 100, Color.GREEN);

        // Set different scale factors to simulate a 3D effect
        rect2.setScaleX(0.9);
        rect2.setScaleY(0.9);

        rect3.setScaleX(0.8);
        rect3.setScaleY(0.8);

        root.getChildren().addAll(rect1, rect2, rect3);

        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Rectangle createRectangle(double width, double height, Color color) {
        Rectangle rectangle = new Rectangle(width, height, color);
        rectangle.setTranslateX(100); // Set X position
        rectangle.setTranslateY(100); // Set Y position
        return rectangle;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
