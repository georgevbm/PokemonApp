package br.com.george.pokemonapp.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

import br.com.george.pokemonapp.Adapter.AbilityGridAdapter;
import br.com.george.pokemonapp.Model.Pokemon;
import br.com.george.pokemonapp.R;
import br.com.george.pokemonapp.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailsActivity extends AppCompatActivity {

    private String codPokemon = "";
    private String namePokemon = "";
    private TextView namePokemonDetails;
    private TextView weightPokemonDetails;
    private TextView heightPokemonDetails;
    private GridView gridAbilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);

        /* Recebendo dados mandados pela tela de listagem de Pokemons */
        Bundle extra = getIntent().getExtras();
        if (extra != null) {
            codPokemon = extra.getString("codPokemon");
            namePokemon = extra.getString("namePokemon");
        }

        /* Setando título da tela com o nome do Pokemon selecionado */
        setTitle(namePokemon);

        /* Captura uma instância de PokemonService e chama o método que retorna
         *  os dados do Pokemon selecionado */
        Call<Pokemon> call = new RetrofitConfig().getPokemonService().getPokemon(String.valueOf(codPokemon));
        call.enqueue(new Callback<Pokemon>() {
            /* Trata as respostas da requisição à PokeAPI */
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                /* Captura os resultados da PokeAPI e guarna em uma variável de retorno */
                Pokemon pokemon = response.body();

                /* Capturando elementos da tela de detalhes do Pokemon */
                gridAbilities = (GridView) findViewById(R.id.grid_abilities_pokemon);
                namePokemonDetails = (TextView) findViewById(R.id.name_pokemon_details);
                weightPokemonDetails = (TextView) findViewById(R.id.weight_pokemon_details);
                heightPokemonDetails = (TextView) findViewById(R.id.height_pokemon_details);

                /* Deixando as primeiras letras dos nomes maiúsculas */
                String n = pokemon.getName().substring(0, 1).toUpperCase().concat(pokemon.getName().substring(1)).replace("-", " ");
                String[] partes = n.split(" ");

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < partes.length; j++) {
                    String word = partes[j];
                    word = word.substring(0, 1).toUpperCase() + word.substring(1);
                    sb.append(" ").append(word);
                }

                /* Setando os valores nos componentes da tela de detalhes do Pokemon */
                namePokemonDetails.setText(sb.toString());
                weightPokemonDetails.setText(String.valueOf(pokemon.getWeight() / 10) + "kg");
                heightPokemonDetails.setText(String.valueOf(pokemon.getHeight() / 10) + "m");
                gridAbilities.setAdapter(new AbilityGridAdapter(PokemonDetailsActivity.this, pokemon.getAbilities()));
                new DownloadImageTask((ImageView) findViewById(R.id.image_pokemon_details))
                        .execute(pokemon.getSprites().getFront_default());
            }

            /* Método que trata as falhas da requisição a PokeAPI */
            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Log.e("PokemonService   ", "Erro ao buscar os pokemonThirdReturns:" + t.getMessage());
            }
        });
    }

    /* Método para setar as fotos no ImageView da tela de detalhes do Pokemon */
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
