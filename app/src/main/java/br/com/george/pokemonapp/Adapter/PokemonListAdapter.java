package br.com.george.pokemonapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.george.pokemonapp.R;
import br.com.george.pokemonapp.Style.PokemonListStyle;

/* Adapter criado para a apresentação dos Pokemons de um tipo selecionado
 * na tela de listagens de Pokemons. Este adapter é setado em um List. */

public class PokemonListAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<PokemonListStyle> pokemons;

    public PokemonListAdapter(@NonNull Context c, @NonNull ArrayList<PokemonListStyle> objects) {
        super(c, 0, objects);
        context = c;
        pokemons = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (pokemons != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_list_pokemon, parent, false);

            TextView namePokemon = (TextView) view.findViewById(R.id.name_pokemon);
            LinearLayout llPokemon = (LinearLayout) view.findViewById(R.id.layout_pokemon);

            PokemonListStyle pokemon = pokemons.get(position);

            String n = pokemon.getName().substring(0, 1).toUpperCase().concat(pokemon.getName().substring(1)).replace("-", " ");
            String[] partes = n.split(" ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < partes.length; i++) {
                String word = partes[i];
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
                sb.append(" ").append(word);
            }

            namePokemon.setText(sb.toString());
            llPokemon.setBackgroundResource(pokemon.getBackground());
        }

        return view;
    }
}
