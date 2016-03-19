package edu.westga.wordscramble;

import org.junit.Test;

import edu.westga.wordscramble.Model.Wordbank;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class WordbankTest {
    @Test
    public void testGetWordDoesNotReturnNull() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            assertNotNull(bank.getWord());
        }
    }

    @Test
    public void testGetWordDoesNotReturnEmptyString() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            assertFalse(bank.getWord().equals(""));
        }
    }

    @Test
    public void testGetWordSometimesReturnsTheFirstWord() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            if (bank.getWord().equals("avoid")) {
                return;
            };
        }
        fail("Did not return first word in dictionary 'avoid'");
    }

    @Test
    public void testGetWordSometimesReturnsAMiddleWord() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            if (bank.getWord().equals("hyena")) {
                return;
            };
        }
        fail("Did not return middle word in dictionary 'hyena'");
    }

    @Test
    public void testGetWordSometimesReturnsTheLastWord() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            if (bank.getWord().equals("rueful")) {
                return;
            };
        }
        fail("Did not return last word in dictionary 'rueful'");
    }


    @Test
    public void testGetWordDoesNotReturnTheSameWordAllThetime() throws Exception {
        Wordbank bank = new Wordbank();
        String firstWord = bank.getWord();
        for (int count = 0; count < 1000; count++) {
            if (!bank.getWord().equals(firstWord)) {
                return;
            };
        }
        fail("getWord returned the same word each call");
    }
}