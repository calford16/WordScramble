package edu.westga.wordscramble.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Cory on 3/15/2016.
 */
public class Wordbank {

    private ArrayList<String> dictionary;
    public static final boolean FIVE_LETTER_WORD = true;
    public static final boolean SIX_LETTER_WORD = false;

    /**
     * Create a new WordBank instance using the class's hard-coded words
     */
    public Wordbank() {
        this.dictionary = new ArrayList<String>();
        this.addHardCodedWords();
    }

    /**
     * Create a new WordBank instance using words from given input stream
     * Precondition: inputStream != null
     * @param inputStream stream to read words from
     * @throws IOException if unable to read from the inputStream
     */
    public Wordbank(InputStream inputStream) throws IOException {
        this.dictionary = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        boolean fiveLetterWordFound = false;
        boolean sixLetterWordFound = false;
        while ((line=reader.readLine()) != null) {
            if (!fiveLetterWordFound && line.length() == 5) {
                fiveLetterWordFound = true;
            }
            if (!sixLetterWordFound && line.length() == 6) {
                sixLetterWordFound = true;
            }
            this.dictionary.add(line);
            // If we don't have both 5 and 6 letter words add hard-coded ones
        }
        if (!fiveLetterWordFound && !sixLetterWordFound) {
            this.addHardCodedWords();
        }
    }

    public String getWord(boolean fiveLetter){
        boolean correctLetterCount = true;
        String word = "";
        Random generator = new Random();
        do {
            word = this.dictionary.get(generator.nextInt(this.dictionary.size()));

            if (fiveLetter && word.length() == 5) {
                correctLetterCount = false;
            }

            if (!fiveLetter && word.length() == 6) {
                correctLetterCount = false;
            }
        } while (correctLetterCount);
        return word;
    }

    private void addHardCodedWords() {
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
}
