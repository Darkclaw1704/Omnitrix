package com.example.test_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class junitTest {
    @Test
    void setCherryCountToFour(){
        Cherry.setCherryCount(4);
        assertEquals(4,Cherry.getCherryCount());
    }

    @Test
    void setCherryCountToZero(){
        Cherry.setCherryCount(0);
        assertEquals(0,Cherry.getCherryCount());
    }

    @Test
    void setXcordOfStickTo10(){
        Stick stick =new Stick();
        stick.setX(10);
        assertEquals(10,stick.getX());
    }
    @Test
    void setYcordOfStickTo50(){
        Stick stick =new Stick();
        stick.setY(50);
        assertEquals(50,stick.getY());
    }




}