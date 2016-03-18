package edu.westga.wordscramble.View;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import edu.westga.wordscramble.Controller.WordController;
import edu.westga.wordscramble.R;

public class MainActivity extends AppCompatActivity {

    private static final String KEY = "KEY";
    private WordController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.controller = new WordController();

        FragmentManager fm = this.getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        LetterFragment frag = newLetterFragment("M");
        ft.add(R.id.fragment_container, frag);

        LetterFragment frag2 = newLetterFragment("L");
        ft.add(R.id.fragment_container, frag2);

        LetterFragment frag3 = newLetterFragment("I");
        ft.add(R.id.fragment_container, frag3);

        LetterFragment frag4 = newLetterFragment("K");
        ft.add(R.id.fragment_container, frag4);

        LetterFragment frag5 = newLetterFragment("J");
        ft.add(R.id.fragment_container, frag5);

        LetterFragment frag6 = newLetterFragment("L");
        ft.add(R.id.fragment_container, frag6);

        ft.commit();
    }

    /**
     * Create a new instance of LetterFragment, initialized to
     * show the text at 'index'.
     */
    private static LetterFragment newLetterFragment(String letter) {
        LetterFragment f = new LetterFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString(KEY, letter);
        f.setArguments(args);
        return f;
    }
}
