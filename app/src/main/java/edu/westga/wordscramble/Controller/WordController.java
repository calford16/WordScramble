package edu.westga.wordscramble.Controller;

import java.io.IOException;
import java.io.InputStream;

import edu.westga.wordscramble.Model.Scrambler;
import edu.westga.wordscramble.Model.Wordbank;

public class WordController {
    private Scrambler scrambler;

    /**
     * Create a WordController that will use hard-coded words
     */
    public WordController() {
        this.scrambler = new Scrambler(Wordbank.FIVE_LETTER_WORD);
    }

    /**
     * Create a WordController that will get its words from given input stream
     * Precondition: inputStream != null
     * @param inputStream stream to use to get words from
     * @throws IOException if unable to read from the inputStream
     */
    public WordController(InputStream inputStream)  throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.scrambler = new Scrambler(true, inputStream);
    }

    public void newFiveLetterGame() {
        this.scrambler.newWord(Wordbank.FIVE_LETTER_WORD);
    }

    public void newSixLetterGame() {
        this.scrambler.newWord(Wordbank.SIX_LETTER_WORD);
    }

    public String getWord() {
        return this.scrambler.getWord();
    }

    public String getScrambled() {
        return this.scrambler.getScrambled();
    }

    public boolean checkAnswer(String answer) {
        return this.getWord().toLowerCase().equals(answer.toLowerCase());
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

    /**
     * Sets the current word and scrambled version of the word
     * If scrambledWord does not have the same characters as word it does nothing
     * @param word The new word to use
     * @param scrambledWord Scrambled version of the word
     * @return Whether or not it set the new word
     */
    public boolean setWord(String word, String scrambledWord) {
        try {
            this.scrambler.setCurrentWord(word, scrambledWord);
            return true;
        } catch (IllegalArgumentException ex) {
            // Scrambler.setCurrentWord() throws IllegalArgumentException if scrambledWord
            // is not valid.  Don't do anything in this case
            return false;
        }
    }

}
