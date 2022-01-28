package com.example;

public class BowlingGame {

    private int roll = 0;
    private int[] rolls = new int[21];

    public void roll(int ...rolls) {
        for(int pinsBeingKnockedDown : rolls){
            roll(pinsBeingKnockedDown);

        }
    }


    public void roll(int pinsBeingKnockedDown) {
        rolls[roll++] = pinsBeingKnockedDown;

    }

    public int score() {
        int score = 0;
        int pointer = 0;
        for (int setting = 0; setting < 10; setting++) {
            if(getsAStrike(rolls[pointer])){                                             //Ifall man får strike
                score = score + 10 + rolls[pointer+1] + rolls[pointer+2];
                pointer++;

            }
            else if(getsASpare(pointer)){                       //Ifall man får spärr

                score = score + 10 + rolls[pointer+2];
                pointer = pointer + 2;


            }else{

            score = score + rolls[pointer] + rolls[pointer+1];
            pointer += 2;

            }
        }

        return score;

        }

    private boolean getsAStrike(int roll1) {
        return roll1 == 10;
    }

    private boolean getsASpare(int pointer) {
        return rolls[pointer] + rolls[pointer +1]==10;      //Metoden för spärr
    }



}

