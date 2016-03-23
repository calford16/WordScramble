package edu.westga.wordscramble;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import edu.westga.wordscramble.View.MainActivity;

public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testTitleIsDisplayed() {
        MainActivity activity = getActivity();

        final TextView titleText =
                (TextView) activity.findViewById(R.id.titleTextView);
        assertEquals("Scramblemania", titleText.getText());
    }

    public void testAnswerEditTextExists() {
        MainActivity activity = getActivity();

        final EditText answerField =
                (EditText) activity.findViewById(R.id.answer_field);
        assertNotNull(answerField);
    }

    public void testAnswerEditTextDirectsUserToInputAnswerHere() {
        MainActivity activity = getActivity();
        final EditText answerField =
                (EditText) activity.findViewById(R.id.answer_field);
        assertEquals("Answer here!", answerField.getHint());
    }

}