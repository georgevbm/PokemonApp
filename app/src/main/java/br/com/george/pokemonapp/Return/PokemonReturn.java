package br.com.george.pokemonapp.Return;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties({"damage_relations", "game_indices", "generation", "id", "move_damage_class", "moves", "name", "names"})
public class PokemonReturn {
    private ArrayList<PokemonSecondReturn> pokemon;

    public ArrayList<PokemonSecondReturn> getPokemon() {
        return pokemon;
    }
    public void setPokemon(ArrayList<PokemonSecondReturn> pokemon) {
        this.pokemon = pokemon;
    }

    @Override
    public String toString() {
        return "PokemonReturn: " + pokemon;
    }
}
