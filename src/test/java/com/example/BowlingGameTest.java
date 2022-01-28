package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    @Test
    void canBeAbleToGetAGutterBowlingGame(){
        BowlingGame bowlingGame = new BowlingGame();
        for(int i = 0; i < 20;i++){
            bowlingGame.roll(0);

        }

        assertThat(bowlingGame.score()).isEqualTo(0);

    }

}