package edu.westga.wordscramble.Controller;

import edu.westga.wordscramble.Model.Scrambler;

public class WordController {
    private Scrambler scrambler;

    public WordController() {
        this.scrambler = new Scrambler();
    }

    void newGame() {
    }

    String getWord() {
        return null;
    }

    String getScrambled() {
        return null;
    }

    boolean checkAnswer(String answer) {
        return false;
    }

    String getHint() {
        return null;
    }
}
