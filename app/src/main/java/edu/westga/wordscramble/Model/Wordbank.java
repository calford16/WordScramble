package edu.westga.wordscramble.Model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Cory on 3/15/2016.
 */
public class Wordbank {

    private ArrayList<String> dictionary;

    public Wordbank() {
        this.dictionary = new ArrayList<String>();

        this.dictionary.add("avoid");
        this.dictionary.add("bloom");
        this.dictionary.add("clogs");
        this.dictionary.add("dogma");
        this.dictionary.add("evict");
        this.dictionary.add("froth");
        this.dictionary.add("gluon");
        this.dictionary.add("hyena");

        this.dictionary.add("ingots");
        this.dictionary.add("kobold");
        this.dictionary.add("lipids");
        this.dictionary.add("motley");
        this.dictionary.add("normal");
        this.dictionary.add("oolong");
        this.dictionary.add("phylum");
        this.dictionary.add("rueful");
    }

    public String getWord(int index) {
        return this.dictionary.get(index);
    }

    public String getWord(boolean fiveLetter){
        boolean correctLetterCount = false;
        String word = "";
        Random generator;
        do {
            generator = new Random();
            word = this.dictionary.get(generator.nextInt(this.dictionary.size()));

            if (fiveLetter && word.length() == 5) {
                correctLetterCount = true;
            }

            if (!fiveLetter && word.length() == 6) {
                correctLetterCount = true;
            }
        } while (correctLetterCount);
        return word;
    }
}
