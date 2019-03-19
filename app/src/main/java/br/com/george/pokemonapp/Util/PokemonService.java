package br.com.george.pokemonapp.Util;

import br.com.george.pokemonapp.Model.TypeReturn;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonService {

    @GET("type")
    Call<TypeReturn> getTypes();
}
