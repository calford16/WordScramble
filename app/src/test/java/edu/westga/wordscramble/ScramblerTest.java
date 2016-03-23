package edu.westga.wordscramble;

import org.junit.Test;

import java.util.Arrays;

import edu.westga.wordscramble.Model.Scrambler;

import static org.junit.Assert.*;

public class ScramblerTest {

    @Test
    public void testGetFiveWordNeverReturnsNull() throws Exception {
        Scrambler scrambler = new Scrambler(true);
        for (int count = 0; count < 1000; count++) {
            assertNotNull(scrambler.getWord());
        }
    }

    @Test
    public void testGetSixWordNeverReturnsNull() throws Exception {
        Scrambler scrambler = new Scrambler(false);
        for (int count = 0; count < 1000; count++) {
            assertNotNull(scrambler.getWord());
        }
    }

    @Test
    public void testGetFiveWordNeverReturnsAnEmptyString() throws Exception {
        Scrambler scrambler = new Scrambler(true);
        for (int count = 0; count < 1000; count++) {
            assertFalse(scrambler.getWord().equals(""));
        }
    }

    @Test
    public void testGetSixWordNeverReturnsAnEmptyString() throws Exception {
        Scrambler scrambler = new Scrambler(false);
        for (int count = 0; count < 1000; count++) {
            assertFalse(scrambler.getWord().equals(""));
        }
    }

    @Test
    public void testGetFiveScrambledNeverReturnsNull() throws Exception {
        Scrambler scrambler = new Scrambler(true);
        for (int count = 0; count < 1000; count++) {
            assertNotNull(scrambler.getScrambled());
        }
    }

    @Test
    public void testGetSixScrambledNeverReturnsNull() throws Exception {
        Scrambler scrambler = new Scrambler(false);
        for (int count = 0; count < 1000; count++) {
            assertNotNull(scrambler.getScrambled());
        }
    }

    @Test
    public void testGetFiveScrambledNeverReturnsAnEmptyString() throws Exception {
        Scrambler scrambler = new Scrambler(true);
        for (int count = 0; count < 1000; count++) {
            assertFalse(scrambler.getScrambled().equals(""));
        }
    }

    @Test
    public void testGetSixScrambledNeverReturnsAnEmptyString() throws Exception {
        Scrambler scrambler = new Scrambler(false);
        for (int count = 0; count < 1000; count++) {
            assertFalse(scrambler.getScrambled().equals(""));
        }
    }

    @Test
    public void testGetFiveScrambledAlwaysHasTheSameCharactersAsGetWord() throws Exception {
        Scrambler scrambler;
        String word;
        String scrambled;
        for (int count = 0; count < 1000; count++) {
            scrambler = new Scrambler(true);
            word = scrambler.getWord();
            scrambled = scrambler.getScrambled();
            assertEquals(sortString(word), sortString(scrambled));
        }
    }

    @Test
    public void testGetSixScrambledAlwaysHasTheSameCharactersAsGetWord() throws Exception {
        Scrambler scrambler;
        String word;
        String scrambled;
        for (int count = 0; count < 1000; count++) {
            scrambler = new Scrambler(false);
            word = scrambler.getWord();
            scrambled = scrambler.getScrambled();
            assertEquals(sortString(word), sortString(scrambled));
        }
    }

    @Test
    public void testGetFiveScrambledIsNotTheSameAsGetWord() throws Exception {
        Scrambler scrambler = new Scrambler(true);
        String word = scrambler.getWord();
        String scrambled = scrambler.getScrambled();
        assertNotEquals(word, scrambled);
    }

    @Test
    public void testGetSixScrambledIsNotTheSameAsGetWord() throws Exception {
        Scrambler scrambler = new Scrambler(false);
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
