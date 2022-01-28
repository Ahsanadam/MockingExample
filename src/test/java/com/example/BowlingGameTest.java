package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

   private BowlingGame bowlingGame;

    @BeforeEach
    public void setUp(){

        bowlingGame = new BowlingGame();
    }


    @Test
    void canBeAbleToGetAGutterBowlingGame(){
        roll(20, 0);
        assertThat(bowlingGame.score()).isEqualTo(0);

    }


    @Test
    void canBeAbleToGetAScoreOf1EveryRound(){

       roll(20,1);
       assertThat(bowlingGame.score()).isEqualTo(20);

    }

    private void roll(int times, int pinsBeingKnockedDown) {
        for(int i = 0; i < times; i++){
            bowlingGame.roll(pinsBeingKnockedDown);

        }
    }


}
