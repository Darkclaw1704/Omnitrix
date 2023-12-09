package com.example.test_2;

import javafx.scene.image.ImageView;

import java.util.Random;

public class Cherry extends ImageView {
    private static int cherryCount = 2;
    Random random = new Random();
    public Cherry() {
        super("file:dragon_fruit.png");
        setY(330);
        setX(random.nextInt(100)+50);

    }
    public static int getCherryCount() {
        return cherryCount;
    }

    public static void setCherryCount(int cherryCount) {
        Cherry.cherryCount = cherryCount;
    }


}
