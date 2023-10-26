package com.example.nuzlocketracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class TrackerActivity extends AppCompatActivity {

    Button buttonNew;
    Button buttonSave;
    Button buttonDelete;
    EditText editTextSpecies;
    EditText editTextNickname;
    EditText editTextLocation;
    EditText editTextStatus;
    FirebaseDatabase database;
    DatabaseReference myRef;
    PokemonViewModel pokemonViewModel;
    RecyclerView recyclerPokemon, spinnerCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        pokemonViewModel = new PokemonViewModel(this.getApplication());
        Intent TrackerIntent = getIntent();
        String start = TrackerIntent.getDataString();

        setupFirebase();

        if (start == "new") {
            pokemonViewModel.clearAllPokemon();
            setupNewButton();
            setupSaveButton();
            setupDeleteButton();
        } else if (start == "old") {
            setupNewButton();
            setupSaveButton();
            setupDeleteButton();
            setupPokemonSpinner();
        } else {
            setupNewButton();
            setupSaveButton();
            setupDeleteButton();
            setupPokemonSpinner();
        }

    }

    private void setupFirebase() {

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Pokemon");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //pokemonViewModel.clearPokemon();
                Map<String, Object> mapItems = (Map<String, Object>) dataSnapshot.getValue();
                for (Object pokemon : mapItems.values()) {
                    Log.d("CIS 3334", "Pokemon is: " + pokemon);
                    pokemonViewModel.addPokemon(pokemon.toString());
                }

                //pokemonViewModel.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("CIS 3334", "Failed to read value.", error.toException());
            }
        });

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

        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CIS 3334", "New Game button clicked");   // log button click for debugging using "CIS 3334" tag

            }
        });
    }

    private void setupPokemonSpinner() {
        recyclerPokemon = findViewById(R.id.recylerViewPokemon);
        // Read the pokemon names from the strings.xml file
        //String pokemonNicknames[] = getResources().getStringArray(R.array.pokemonList);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokemonViewModel.getAllPokemon());
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_list_item_2);
        // Apply the adapter to the spinner
        recyclerPokemon.setAdapter(itemsAdapter);
        //-------------------------------------
//        recyclerPokemon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                //Another interface callback
//            }
//        });
    }
}