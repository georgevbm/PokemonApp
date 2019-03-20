package br.com.george.pokemonapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.george.pokemonapp.Adapter.PokemonListAdapter;
import br.com.george.pokemonapp.Model.PokemonListStyle;
import br.com.george.pokemonapp.R;
import br.com.george.pokemonapp.Return.PokemonReturn;
import br.com.george.pokemonapp.Return.PokemonSecondReturn;
import br.com.george.pokemonapp.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonsActivity extends AppCompatActivity {

    private ListView listPokemons;
    private ArrayList<PokemonListStyle> pokemonNames;
    private ArrayAdapter adapter;

    private String nameType = "";
    private int codType = 0;
    private int backgrounType = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemons);

        listPokemons = (ListView) findViewById(R.id.list_pokemons);

        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            nameType = extra.getString("nameType");
            codType = extra.getInt("codType");
            backgrounType = extra.getInt("backgrounType");
        }

        setTitle(nameType);

        pokemonNames = new ArrayList<>();

        Call<PokemonReturn> call = new RetrofitConfig().getPokemonService().getPokemonTypes(String.valueOf(codType));
        call.enqueue(new Callback<PokemonReturn>() {
            @Override
            public void onResponse(Call<PokemonReturn> call, Response<PokemonReturn> response) {
                PokemonReturn pokemonReturn = response.body();
                Log.i("PokemonService   ", pokemonReturn.toString());

                for(PokemonSecondReturn ptr: pokemonReturn.getPokemon()){
                    PokemonListStyle pls = new PokemonListStyle(ptr.getPokemon().getName(), backgrounType);
                    pokemonNames.add(pls);
                }

                adapter = new PokemonListAdapter(PokemonsActivity.this, pokemonNames);
                listPokemons.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<PokemonReturn> call, Throwable t) {
                Log.e("PokemonService   ", "Erro ao buscar os pokemonThirdReturns:" + t.getMessage());
            }
        });
    }
}
