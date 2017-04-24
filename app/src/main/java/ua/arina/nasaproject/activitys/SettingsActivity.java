package ua.arina.nasaproject.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ua.arina.nasaproject.fragments.SettingsFragment;

/**
 * Created by Arina on 24.04.2017
 */

public class SettingsActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

    }
}
