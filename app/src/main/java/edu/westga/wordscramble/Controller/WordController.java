package edu.westga.wordscramble.Controller;

import edu.westga.wordscramble.Model.Scrambler;

public class WordController {
    private Scrambler scrambler;

    public WordController() {
        this.scrambler = new Scrambler(true);
    }

    public void newFiveLetterGame() {
        this.scrambler = new Scrambler(true);
    }

    public void newSixLetterGame() {
        this.scrambler = new Scrambler(false);
    }

    public String getWord() {
        return this.scrambler.getWord();
    }

    public String getScrambled() {
        return this.scrambler.getScrambled();
    }

    public boolean checkAnswer(String answer) {
        return this.getWord().equals(answer);
    }

    public String getHint(int threshold) {
        String theHint = "";
        for (int i = 0; i < this.getWord().length(); i++) {
            if (i < threshold) {
                theHint += this.getWord().charAt(i);
            } else {
                theHint += "*";
            }
        }
        return theHint;
    }
}
