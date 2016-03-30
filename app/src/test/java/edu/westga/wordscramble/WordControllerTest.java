package edu.westga.wordscramble;

import org.junit.Test;

import java.util.Arrays;

import edu.westga.wordscramble.Controller.WordController;
import edu.westga.wordscramble.Model.Wordbank;

import static org.junit.Assert.*;

public class WordControllerTest {

    @Test
    public void testNewControllerGetWordIsNeverNull() {
        WordController controller = new WordController();
        for (int count = 0; count < 1000; count++) {
            assertNotNull(controller.getWord());
        }
    }

    @Test
    public void testNewControllerGetWordIsNeverAnEmptyString() {
        WordController controller = new WordController();
        for (int count = 0; count < 1000; count++) {
            assertNotEquals("", controller.getWord());
        }
    }

    @Test
    public void testGetScrambledAlwaysHasTheSameCharactersAsGetWord() throws Exception {
        WordController controller = new WordController();
        String word;
        String scrambled;
        for (int count = 0; count < 1000; count++) {
            controller = new WordController();
            word = controller.getWord();
            scrambled = controller.getScrambled();
            assertEquals(sortString(word), sortString(scrambled));
        }
    }

    @Test
    public void testNewFiveLetterGameGetsANewWord() {
        WordController controller = new WordController();
        String oldWord = controller.getWord();
        //Try 5 times since it is possible to get the same word in a row by coincidence
        for (int count = 0; count < 5; count++) {
            controller.newFiveLetterGame();
            String newWord = controller.getWord();
            if (! newWord.equals(oldWord)) {
                return;
            }
        }
        fail("newFiveLetterGame keeps getting the same word");
    }

    @Test
    public void testNewSixLetterGameGetsANewWord() {
        WordController controller = new WordController();
        String oldWord = controller.getWord();
        //Try 5 times since it is possible to get the same word in a row by coincidence
        for (int count = 0; count < 5; count++) {
            controller.newSixLetterGame();
            String newWord = controller.getWord();
            if (! newWord.equals(oldWord)) {
                return;
            }
        }
        fail("newSixLetterGame keeps getting the same word");
    }

    @Test
    public void testNewFiveLetterGameGetsAFiveLetterWordEveryTime() {
        WordController controller = new WordController();
        for (int count = 0; count < 1000; count++) {
            controller.newFiveLetterGame();
            assertEquals(5, controller.getWord().length());
        }
    }

    @Test
    public void testNewSixLetterGameGetsASixLetterWordEveryTime() {
        WordController controller = new WordController();
        for (int count = 0; count < 1000; count++) {
            controller.newSixLetterGame();
            assertEquals(6, controller.getWord().length());
        }
    }

    @Test
    public void testSetWordSetsTheWord() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("apple", controller.getWord());
    }

    @Test
    public void testSetWordReturnsTrueWhenSuccessful() {
        WordController controller = new WordController();
        assertTrue(controller.setWord("apple", "elppa"));
        assertEquals("apple", controller.getWord());
    }

    @Test
    public void testSetWordSetsTheScrambledWord() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("elppa", controller.getScrambled());
    }

    @Test
    public void testSetWordDoesNotChangeAnythingWhenInvalidParameters(){
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        controller.setWord("orange", "abc");
        assertEquals("apple", controller.getWord());
        assertEquals("elppa", controller.getScrambled());
    }

    @Test
    public void testSetWordReturnsFalseWhenWhenInvalidParameters(){
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertFalse(controller.setWord("orange", "abc"));
    }

    @Test
    public void testCheckAnswerWhenCorrectAnswer() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals(true, controller.checkAnswer("apple"));
    }

    @Test
    public void testCheckAnswerWhenIncorrectAnswer() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals(false, controller.checkAnswer("orange"));
    }

    @Test
    public void testGetHintWithOne() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("a****", controller.getHint(1));
    }

    @Test
    public void testGetHintWithThree() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("app**", controller.getHint(3));
    }

    @Test
    public void testGetHintWithFive() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("apple", controller.getHint(5));
    }

    @Test
    public void testGetHintWhenThresholdLongerThanWord() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("apple", controller.getHint(10));
    }

    @Test
    public void testGetHintWithZero() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("*****", controller.getHint(0));
    }

    @Test
    public void testGetHintWithNegativeNumber() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("*****", controller.getHint(-1));
    }

    @Test
    public void testGetHintWithlargeNegativeNumber() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals("*****", controller.getHint(-9999));
    }

    @Test
    public void testCheckAnswerIgnoresCase() {
        WordController controller = new WordController();
        controller.setWord("apple", "elppa");
        assertEquals(true, controller.checkAnswer("Apple"));
    }


    private String sortString(String theString) {
        char[] stringAsCharArray = theString.toCharArray();
        Arrays.sort(stringAsCharArray);
        return String.valueOf(stringAsCharArray);
    }
}
