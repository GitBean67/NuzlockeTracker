package com.example.nuzlocketracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonNewGame;
    Button buttonLoadGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLoadGame = findViewById(R.id.buttonLoadGame);

        setupNewGameButton();
    }

    private void setupNewGameButton() {
        buttonNewGame = findViewById(R.id.buttonNewGame);

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "New Game button clicked");   // log button click for debugging using "CIS 3334" tag
                //Call Tracker Activity
                Intent resultsActIntent = new Intent(MainActivity.this, TrackerActivity.class);

                startActivity(resultsActIntent); //if no result is returned.
            }
        });
    }
}