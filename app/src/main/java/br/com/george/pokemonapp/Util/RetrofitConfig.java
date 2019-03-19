package br.com.george.pokemonapp.Util;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public PokemonService getPokemonService() {
        return this.retrofit.create(PokemonService.class);
    }
}
