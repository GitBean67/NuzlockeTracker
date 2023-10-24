package com.example.nuzlocketracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TrackerActivity extends AppCompatActivity {

    Button buttonNew;
    Button buttonSave;
    Button buttonDelete;
    EditText editTextSpecies;
    EditText editTextNickname;
    EditText editTextLocation;
    EditText editTextStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        setupNewButton();
        setupSaveButton();
        setupDeleteButton();
    }

    private void setupNewButton() {
        buttonNew = findViewById(R.id.buttonNew);
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "New Game button clicked");   // log button click for debugging using "CIS 3334" tag

                String species = editTextSpecies.getText().toString();
                String nickname = editTextNickname.getText().toString();
                String location = editTextLocation.getText().toString();
                String status = editTextStatus.getText().toString();
            }
        });
    }

    private void setupSaveButton() {
        buttonSave = findViewById(R.id.buttonSave);
    }
    private void setupDeleteButton() {
        buttonDelete = findViewById(R.id.buttonDelete);
    }
}