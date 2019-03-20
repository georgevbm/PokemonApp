package br.com.george.pokemonapp.Util;

import br.com.george.pokemonapp.Return.PokemonReturn;
import br.com.george.pokemonapp.Return.TypeReturn;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {

    @GET("type")
    Call<TypeReturn> getTypes();

    @GET("type/{codType}")
    Call<PokemonReturn> getPokemonTypes(@Path("codType") String codType);

    @GET("pokemon/{codPokemon}")
    Call<PokemonReturn> getPokemon(@Path("codPokemon") String codPokemon);
}
