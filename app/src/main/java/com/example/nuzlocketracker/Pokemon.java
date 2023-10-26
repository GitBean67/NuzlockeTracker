package com.example.nuzlocketracker;

public class Pokemon {
    String species;
    String nickname;
    String location;
    String status;

    public Pokemon(String species, String nickname, String location, String status) {
        this.species = species;
        this.nickname = nickname;
        this.location = location;
        this.status = status;
    }

    public String getSpecies() {
       return species;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus() {
        return status;
    }
}
