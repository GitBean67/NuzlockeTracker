package com.example.nuzlocketracker;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import java.util.ArrayList;
import java.util.List;

public class PokemonViewModel extends AndroidViewModel {

    ArrayList<String> pokemonList;


    public PokemonViewModel(@NonNull Application application) {
        super(application);
        pokemonList = new ArrayList<>();
    }

    public void clearPokemon(Integer itemNum) {
        pokemonList.remove(itemNum);
    }

    public void clearAllPokemon() {pokemonList.clear();}
    public void addPokemon(String item) {
        pokemonList.add(item);
    }

    public String getPokemon(Integer position) {
        return pokemonList.get(position);
    }

    public List<String> getAllPokemon() {return pokemonList;}
}

