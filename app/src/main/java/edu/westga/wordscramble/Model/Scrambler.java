package edu.westga.wordscramble.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cory on 3/15/2016.
 */
public class Scrambler {

    private String word = "";
    private String scrambled = "";
    private Wordbank bank;

    /**
     * Create a new Scrambler instance using hard coded words.  It will provide a random word and a
     * scrambled version of it
     * @param fiveLetter True for 5 letter words. False for 6 letter words
     */
    public Scrambler(boolean fiveLetter) {
        this.bank = new Wordbank();
        this.word = bank.getWord(fiveLetter);
        this.scrambled = scrambleWord(this.word);
    }

    /**
     * Create a new Scrambler instance using words from given input stream
     * Precondition: inputStream != null
     * @param fiveLetter True for 5 letter words. False for 6 letter words
     * @param inputStream stream to read words from
     * @throws IOException if unable to read from the inputStream
     */
    public Scrambler(boolean fiveLetter, InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("inputStream cannot be null");
        }
        this.bank = new Wordbank(inputStream);
        this.word = bank.getWord(fiveLetter);
        this.scrambled = scrambleWord(this.word);
    }


    public String getWord() {
        return this.word;
    }
    public String getScrambled() {
        return this.scrambled;
    }

    private String scrambleWord(String word) {
        List<Character> list = new ArrayList<>();
        for(char c :  word.toCharArray()) {
            list.add(c);
        }
        Collections.shuffle(list);

        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }

    public void newWord(boolean fiveLetter) {
        this.word = this.bank.getWord(fiveLetter);
        this.scrambled = scrambleWord(this.word);
    }

    public boolean compareWord(String otherWord) {
        return this.word.equals(otherWord);
    }

    public void setCurrentWord(String word, String scrambledWord) {
        if (word == null || scrambled == null) {
            throw new IllegalArgumentException("word and scrambledWord must not be null");
        }
        if (!this.sortString(word.toLowerCase()).equals(this.sortString(scrambledWord.toLowerCase()))) {
            throw new IllegalArgumentException("scrambledWord is not a scrambled version of word");
        }

        this.word = word;
        this.scrambled = scrambledWord;
    }

    private String sortString(String theString) {
        char[] stringAsCharArray = theString.toCharArray();
        Arrays.sort(stringAsCharArray);
        return String.valueOf(stringAsCharArray);
    }
}
