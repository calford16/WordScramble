package edu.westga.wordscramble.View;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import edu.westga.wordscramble.Controller.WordController;
import edu.westga.wordscramble.R;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "KEY";
    private List<WeakReference<Fragment>> fragList;
    private WordController controller;
    private int hintThreshold;
    public final static String WORD_LIST_FILE = "words.txt";
    public final static String WORDLIST_URL = "https://raw.githubusercontent.com/first20hours/google-10000-english/master/20k.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AssetManager assetManager = getAssets();
//        try {
//            InputStream input = assetManager.open(WORD_LIST_FILE);
//            this.controller = new WordController(input);
//        } catch (IOException ex) {
//            // Fallback on using hard-coded words
//            Toast.makeText(MainActivity.this, "Failed to open wordfile. Falling back on hardcoded list", Toast.LENGTH_SHORT).show();
//            this.controller = new WordController();
//        }
//        this.createLetterFragments(this.controller.getScrambled());

        new GetWordsFromURL().execute(WORDLIST_URL);
        this.fragList = new ArrayList<WeakReference<Fragment>>();
        this.hintThreshold = 0;
    }

    public void newWordButtonAction(View view) {
        RadioButton fiveLetterRadioButton = (RadioButton) findViewById(R.id.fiveLetterRadioButton);
        if (fiveLetterRadioButton.isChecked()) {
            this.controller.newFiveLetterGame();
        } else {
            this.controller.newSixLetterGame();
        }

        this.clearLetterFragments();
        this.fragList = new ArrayList<WeakReference<Fragment>>();
        this.createLetterFragments(this.controller.getScrambled());

        TextView answerTextView = (TextView) findViewById(R.id.answer_field);
        answerTextView.setText("");

        this.hintThreshold = 0;
    }

    public void submitAnswerButtonAction(View view) {
        TextView answerTextView = (TextView) findViewById(R.id.answer_field);
        if (this.controller.checkAnswer(answerTextView.getText().toString())) {
            Toast.makeText(MainActivity.this, "Answer correct! Play again!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Wrong! Try again.", Toast.LENGTH_SHORT).show();
        }
    }

    public void hintButtonAction(View view) {
        String hint = this.controller.getHint(++this.hintThreshold);
        Toast.makeText(MainActivity.this, hint, Toast.LENGTH_SHORT).show();
    }

    /**
     * Create a new instance of LetterFragment
     */
    private LetterFragment newLetterFragment(String letter) {
        LetterFragment f = new LetterFragment();
        Bundle args = new Bundle();
        args.putString(KEY, letter);
        f.setArguments(args);
        return f;
    }

    private void clearLetterFragments() {
        List<Fragment> all = this.getActiveFragments();
        if (all == null) {
            // code that handles no existing fragments
        } else {
            for (Fragment frag : all)
            {
                getFragmentManager().beginTransaction().remove(frag).commit();
            }
        }
    }

    private void createLetterFragments(String word) {
        FragmentManager fm = this.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        for (char c : word.toCharArray()) {
            LetterFragment frag = newLetterFragment(String.valueOf(c));
            ft.add(R.id.fragment_container, frag);
        }

        ft.commit();
    }

    @Override
    public void onAttachFragment (Fragment fragment) {
        fragList.add(new WeakReference(fragment));
    }

    public List<Fragment> getActiveFragments() {
        ArrayList<Fragment> ret = new ArrayList<Fragment>();
        for(WeakReference<Fragment> ref : fragList) {
            Fragment f = ref.get();
            if(f != null) {
                if(f.isVisible()) {
                    ret.add(f);
                }
            }
        }
        return ret;
    }


    /**
     * Class to run the network operation on a separate thread.
     * Android does not allow network activity on the main thread that MainActivity is running on
     */
    class GetWordsFromURL extends AsyncTask<String, String, String> {

        /**
         * Work to do in the background thread
         * */
        @Override
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                MainActivity.this.controller = new WordController(input);
            } catch (IOException ex) {
                // Fallback on using hard-coded words
                MainActivity.this.controller = new WordController();
            }
            MainActivity.this.createLetterFragments(MainActivity.this.controller.getScrambled());
            return null;
        }
    }

}
