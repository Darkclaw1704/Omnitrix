package com.example.test_2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox pane = new VBox();
        pane.setAlignment(Pos.BOTTOM_CENTER);

        Scene scene = new Scene(pane, 360, 640);

        Image backgroundImage = new Image("file:gameScreen.png");
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        pane.setBackground(new Background(background));

        Region spacer1 = new Region();
        spacer1.setPrefWidth(10);

        Image rectangleImage1 = new Image("file:pillar.png");
        ImageView imageView1 = new ImageView(rectangleImage1);
        imageView1.setFitWidth(30);
        imageView1.setFitHeight(300);
        Rectangle rectangle1 = new Rectangle(30, 300);
        rectangle1.setFill(Color.TRANSPARENT);
        rectangle1.setStroke(Color.RED);
        StackPane stackPane1 = new StackPane(imageView1, rectangle1);

        Region spacer2 = new Region();
        spacer2.setPrefWidth(175);

        Image rectangleImage2 = new Image("file:pillar.png");
        ImageView imageView2 = new ImageView(rectangleImage2);
        imageView2.setFitWidth(45);
        imageView2.setFitHeight(300);
        Rectangle rectangle2 = new Rectangle(45, 300);
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStroke(Color.RED);
        StackPane stackPane2 = new StackPane(imageView2, rectangle2);

        HBox hbox = new HBox(spacer1, stackPane1, spacer2, stackPane2);
        hbox.setAlignment(Pos.BOTTOM_CENTER);

        pane.getChildren().add(hbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
