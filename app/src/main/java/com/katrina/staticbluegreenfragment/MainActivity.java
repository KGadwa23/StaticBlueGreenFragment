package com.katrina.staticbluegreenfragment;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements BlueFragment.RandomNumberGeneratedListener{

    public static final String RANDOM_BUNDLE_KEY = "Your rnadom number";

    //Create instnaces of our two fragments
    private GreenFragment greenFragment = new GreenFragment();
    private BlueFragment blueFragment = new BlueFragment();

    //Used to label the current Fragment diesplayed
    private static final String BLUE_TAG = "BLUE";
    private static final String GREEN_TAG = "GREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBlueFragment(); //need to show something to start with
    }

    private void showBlueFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, blueFragment, BLUE_TAG);
        ft.commit();
    }

    //send the random number to the greenFragment
    public void sendRandomNumber(int rnd) {
        //create a bundle to carry arguments to the fragment
        Bundle arguments = new Bundle();
        //add the random integer
        arguments.putInt(RANDOM_BUNDLE_KEY, rnd);
        //and give the arguments to our GreenFragment
        greenFragment.setArguments(arguments);

        //replace the BlueFragment withb the GreenFragment
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, greenFragment, GREEN_TAG);
        ft.addToBackStack(GREEN_TAG);
        ft.commit();    //Don't forget!
    }
}
