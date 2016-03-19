package edu.westga.wordscramble.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cory on 3/15/2016.
 */
public class Scrambler {

    private String word = "";
    private String scrambled = "";

    /**
     * Create a new Scrambler instance.  It will provide a random word and a
     * scrambled version of it
     */
    public Scrambler() {

        this.word = new Wordbank().getWord();
        this.scrambled = scrambleWord(this.word);
    }

    String getWord() {
        return this.word;
    }
    String getScrambled() {
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

    public boolean compareWord(String otherWord) {
        return this.word.equals(otherWord);
    }
}
