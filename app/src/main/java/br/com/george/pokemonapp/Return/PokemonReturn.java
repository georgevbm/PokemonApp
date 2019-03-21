package br.com.george.pokemonapp.Return;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/* Classe que trata o primeiro retorno dos Pokemons de um tipo selecionado */

@JsonIgnoreProperties(ignoreUnknown = true)
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
