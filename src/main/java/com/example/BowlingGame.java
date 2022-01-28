package com.example;

public class BowlingGame {
       private int score;

    public void roll(int pinsBeingKnockedDown) {
        score = score + pinsBeingKnockedDown;

    }

    public int score() {
        return score;
    }
}
