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
        bowlingGame.roll(0,0, 0,0, 0,0, 0,0, 0,0 ,0,0, 0,0, 0,0, 0,0, 0,0 );
        assertThat(bowlingGame.score()).isEqualTo(0);

    }


    @Test
    void canBeAbleToGetAScoreOf1EveryRound(){

       bowlingGame.roll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
       assertThat(bowlingGame.score()).isEqualTo(20);

    }

    @Test
    void canBeAbleToGetAScoreOfSpareTheFirstRoundAndScoring3After(){

        bowlingGame.roll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingGame.score()).isEqualTo(16);

    }

    @Test
    void canBeAbleToScoreAStrikeTheFirstRoundAndThenScoring3FollowedBy3AfterThat(){

        bowlingGame.roll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingGame.score()).isEqualTo(22);

    }

    @Test
    void canBeAbleToScoreAStrikeEveryRound(){
        bowlingGame.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertThat(bowlingGame.score()).isEqualTo(300);

    }


}
