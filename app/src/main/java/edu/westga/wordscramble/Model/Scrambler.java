package edu.westga.wordscramble.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Cory on 3/15/2016.
 */
public class Scrambler {

    private String word = "";

    public Scrambler(String aWord) {
        this.word = aWord;
    }

    // No parameter constructor automatically selects a word
    public Scrambler() {
        this(new Wordbank().getWord());
    }

    public String scrambleWord() {
        List<Character> list = new ArrayList<>();
        for(char c :  this.word.toCharArray()) {
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
