package br.com.george.pokemonapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* Definição da classe Ability */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ability {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n";
    }
}
