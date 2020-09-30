package cz.yb.jetpackdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.lifecycle.CustomChronometer;

public class LifeCycleActivity extends AppCompatActivity {

    private CustomChronometer customChronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        customChronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(customChronometer);
    }
}