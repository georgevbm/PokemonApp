package br.com.george.pokemonapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import br.com.george.pokemonapp.Model.Pokemon;
import br.com.george.pokemonapp.R;
import br.com.george.pokemonapp.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailsActivity extends AppCompatActivity {

    private String codPokemon = "";
    private String namePokemon = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            codPokemon = extra.getString("codPokemon");
            namePokemon = extra.getString("namePokemon");
        }

        setTitle(namePokemon);

        Call<Pokemon> call = new RetrofitConfig().getPokemonService().getPokemon(String.valueOf(codPokemon));
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon pokemon = response.body();

                Log.i("Pokemon", pokemon.toString());
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("PokemonService   ", "Erro ao buscar os pokemonThirdReturns:" + t.getMessage());
            }
        });


    }
}
