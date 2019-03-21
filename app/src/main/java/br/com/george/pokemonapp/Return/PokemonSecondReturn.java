package br.com.george.pokemonapp.Return;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* Classe que trata o segundo retorno dos Pokemons de um tipo selecionado */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonSecondReturn {
    private PokemonThirdReturn pokemon;

    public PokemonThirdReturn getPokemon() {
        return pokemon;
    }

    public void setPokemon(PokemonThirdReturn pokemonThirdReturn) {
        this.pokemon = pokemonThirdReturn;
    }

    @Override
    public String toString() {
        return "PokemonSecondReturn: " + pokemon;
    }
}

