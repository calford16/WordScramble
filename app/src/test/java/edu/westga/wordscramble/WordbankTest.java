package edu.westga.wordscramble;

import org.junit.Test;

import edu.westga.wordscramble.Model.Wordbank;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class WordbankTest {
    @Test
    public void testGetFiveWordDoesNotReturnNull() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            assertNotNull(bank.getWord(true));
        }
    }

    @Test
    public void testGetSixWordDoesNotReturnNull() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            assertNotNull(bank.getWord(false));
        }
    }

    @Test
    public void testGetFiveWordDoesNotReturnEmptyString() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            assertFalse(bank.getWord(true).equals(""));
        }
    }

    @Test
    public void testGetSixWordDoesNotReturnEmptyString() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            assertFalse(bank.getWord(false).equals(""));
        }
    }

    @Test
    public void testGetFiveWordSometimesReturnsTheFirstWord() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            if (bank.getWord(true).equals("avoid")) {
                return;
            };
        }
        fail("Did not return first word in dictionary 'avoid'");
    }

    @Test
    public void testGetWordSometimesReturnsAMiddleWord() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            if (bank.getWord(true).equals("hyena")) {
                return;
            };
        }
        fail("Did not return middle word in dictionary 'hyena'");
    }

    @Test
    public void testGetWordSometimesReturnsTheLastWord() throws Exception {
        Wordbank bank = new Wordbank();
        for (int count = 0; count < 1000; count++) {
            if (bank.getWord(false).equals("rueful")) {
                return;
            };
        }
        fail("Did not return last word in dictionary 'rueful'");
    }


    @Test
    public void testGetWordDoesNotReturnTheSameWordAllTheTime() throws Exception {
        Wordbank bank = new Wordbank();
        String firstWord = bank.getWord(true);
        for (int count = 0; count < 1000; count++) {
            if (!bank.getWord(true).equals(firstWord)) {
                return;
            };
        }
        fail("getWord returned the same word each call");
    }
}