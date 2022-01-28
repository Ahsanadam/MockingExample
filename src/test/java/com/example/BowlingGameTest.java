package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @Test
    void canCreateABowlingGame(){
        new BowlingGame();

    }

    @Test
    void canBeAbleToRollABowlingBall(){
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(0);
    }

}