package com.katrina.staticbluegreenfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jm7463pn on 9/20/16.
 */
public class GreenFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.green_fragment, container, false);

        int random = -1;

        //check to see if arguments have been recived - if so, get random number
        if (getArguments() != null) {
            random = getArguments().getInt(MainActivity.RANDOM_BUNDLE_KEY, -1);     //default for no random number
        }

        TextView showRandomTV = (TextView) view.findViewById(R.id.green_fragment_random_textview);

        if (random == -1) {
            //no random number recived, no arguments or no data for RANDOM_BUNDLE_KEY
            showRandomTV.setText("Not random number recieved.");
        } else {
            showRandomTV.setText("The random number is " + random);
        }

        return view;
    }
}