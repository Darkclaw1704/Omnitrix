package com.example.test_2;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Random;

public class RandomPillarGenerator {

     Random random = new Random();
    private  Pillar firstPillar= new Pillar(0,29);
    private  Pillar secondPillar =null;
    static TranslateTransition tt = new TranslateTransition();
    public  void createNewPillar(){
        int width = random.nextInt(100) + 30;
        int x_cord=random.nextInt(100)+100;
        System.out.println(width);
        System.out.println(x_cord);
        if (secondPillar != null) {
            firstPillar = secondPillar;
        }
        secondPillar= new Pillar(x_cord, width);
    }

    public  void shift(Game game){
        System.out.println("shift");
        tt.setDuration(Duration.seconds(1.5));
        tt.setNode(secondPillar);
            tt.setToX(firstPillar.getX());
            tt.setDelay(Duration.millis(4500));
            tt.play();
//            return true;
//
////        tt.setDelay(Duration.millis(900));
//        tt.play();
//        return false;
    }

    public  Pillar getFirstPillar() {
        return firstPillar;
    }

    public  Pillar getSecondPillar() {
        return secondPillar;
    }

}
