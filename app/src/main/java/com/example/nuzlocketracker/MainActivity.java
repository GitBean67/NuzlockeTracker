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
    String start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        setupNewGameButton();
        setupLoadGameButton();
    }

    private void setupNewGameButton() {
        buttonNewGame = findViewById(R.id.buttonNewGame);

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "New Game button clicked");   // log button click for debugging using "CIS 3334" tag

               start = "new";

                //Call Tracker Activity
                Intent TrackerIntent = new Intent(MainActivity.this, TrackerActivity.class);
                TrackerIntent.putExtra("start", start);
                startActivity(TrackerIntent); //if no result is returned.
            }
        });
    }

    private void setupLoadGameButton() {
        buttonLoadGame = findViewById(R.id.buttonLoadGame);

        buttonLoadGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "Load Game button clicked");   // log button click for debugging using "CIS 3334" tag

                start = "old";

                //Call Tracker Activity
                Intent TrackerIntent = new Intent(MainActivity.this, TrackerActivity.class);
                TrackerIntent.putExtra("start", start);
                startActivity(TrackerIntent); //if no result is returned.
            }
        });
    }
}