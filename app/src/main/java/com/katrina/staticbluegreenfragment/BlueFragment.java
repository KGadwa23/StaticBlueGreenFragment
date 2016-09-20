package com.katrina.staticbluegreenfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

/**
 * Created by jm7463pn on 9/20/16.
 */


public class BlueFragment extends Fragment {

    //to save a reference to something that can receive a random number, so can call methods to send data
    RandomNumberGeneratedListener randomListener;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blue_fragment, container, false);
        //todo onattach is not working
        if (getActivity() instanceof RandomNumberGeneratedListener) {
            randomListener = (RandomNumberGeneratedListener) getActivity();
        } else {
            throw new RuntimeException(getActivity().getClass().toString() + " should implement RandomNumberGeneratedLIstener");
        }

        Button sendRndToGreen = (Button) view.findViewById(R.id.send_rnd_to_green_fragment);
        sendRndToGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //generate a random number and send it to the activity.
                //the activity will then send it to the green fragment
                //fragments should be independent -
                //this fragment shouldn't know or care what happens to the random number
                Random rng = new Random();
                int rnd = rng.nextInt(100);     //random number between 0-99
                randomListener.sendRandomNumber(rnd);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //typically, the listener is the hosting Activity. it doesn't have to by, but usually is.
        if (getActivity() instanceof RandomNumberGeneratedListener) {
            randomListener = (RandomNumberGeneratedListener) getActivity();
        } else {
            throw new RuntimeException(getActivity().getClass().toString() + " should implement RandomNumberGeneratedLIstener");
        }
    }

    interface RandomNumberGeneratedListener {
        void sendRandomNumber(int rnd);
    }


}

