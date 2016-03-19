package edu.westga.wordscramble;

import org.junit.Test;

import java.util.Arrays;

import edu.westga.wordscramble.Model.Scrambler;

import static org.junit.Assert.*;

public class ScramblerTest {

    @Test
    public void testGetWordNeverReturnsNull() throws Exception {
        Scrambler scrambler = new Scrambler();
        for (int count = 0; count < 1000; count++) {
            assertNotNull(scrambler.getWord());
        }
    }

    @Test
    public void testGetWordNeverReturnsAnEmptyString() throws Exception {
        Scrambler scrambler = new Scrambler();
        for (int count = 0; count < 1000; count++) {
            assertFalse(scrambler.getWord().equals(""));
        }
    }

    @Test
    public void testGetScrambledNeverReturnsNull() throws Exception {
        Scrambler scrambler = new Scrambler();
        for (int count = 0; count < 1000; count++) {
            assertNotNull(scrambler.getScrambled());
        }
    }

    @Test
    public void testGetScrambledNeverReturnsAnEmptyString() throws Exception {
        Scrambler scrambler = new Scrambler();
        for (int count = 0; count < 1000; count++) {
            assertFalse(scrambler.getScrambled().equals(""));
        }
    }

    @Test
    public void testGetScrambledAlwaysHasTheSameCharactersAsGetWord() throws Exception {
        Scrambler scrambler;
        String word;
        String scrambled;
        for (int count = 0; count < 1000; count++) {
            scrambler = new Scrambler();
            word = scrambler.getWord();
            scrambled = scrambler.getScrambled();
            assertEquals(sortString(word), sortString(scrambled));
        }
    }

    @Test
    public void testGetScrambledIsNotTheSameAsGetWord() throws Exception {
        Scrambler scrambler = new Scrambler();
        String word = scrambler.getWord();
        String scrambled = scrambler.getScrambled();
        assertNotEquals(word, scrambled);
    }

    private String sortString(String theString) {
        char[] stringAsCharArray = theString.toCharArray();
        Arrays.sort(stringAsCharArray);
        return String.valueOf(stringAsCharArray);
    }


}
