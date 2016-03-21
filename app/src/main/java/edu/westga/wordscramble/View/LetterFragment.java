package edu.westga.wordscramble.View;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.westga.wordscramble.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LetterFragment extends Fragment {

    public LetterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_letter, container, false);

        TextView textView = (TextView) view.findViewById(R.id.fragmentLetterTextView);
        textView.setText(this.getArguments().getString("KEY"));
        return view;
    }
}
