package com.example.test_2;

import javafx.scene.layout.Region;

import java.io.Serializable;

public class GameData implements Serializable {



    private Stick stick = new Stick();
    private int score = 0;
    private Region spacer2 = new Region();

    private Ninja zoro = new Ninja();
    private Cherry cherry =new Cherry();

    public Cherry getCherry() {
        return cherry;
    }

    public Ninja getZoro() {
        return zoro;
    }

    public Stick getStick() {
        return stick;
    }

    public void setStick(Stick stick) {
        this.stick = stick;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Region getSpacer2() {
        return spacer2;
    }

}
