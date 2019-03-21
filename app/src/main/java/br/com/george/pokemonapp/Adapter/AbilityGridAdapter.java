package br.com.george.pokemonapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import br.com.george.pokemonapp.R;
import br.com.george.pokemonapp.Return.AbilitiesReturn;

/* Adapter criado para a apresentação das habilidades de dos Pokemons na tela
 * de apresentação dos Pokemons. Este adapter é setado em um Grid para uma
 * melhor vizualização das habilidades */

public class AbilityGridAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<AbilitiesReturn> abilities;

    public AbilityGridAdapter(@NonNull Context c, @NonNull ArrayList<AbilitiesReturn> objects) {
        super(c, 0, objects);
        context = c;
        abilities = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (abilities != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_grid_abilities, parent, false);

            TextView nameAbility = (TextView) view.findViewById(R.id.name_ability);

            AbilitiesReturn ability = abilities.get(position);

            String n = ability.getAbility().getName().substring(0, 1).toUpperCase().concat(ability.getAbility().getName().substring(1)).replace("-", " ");
            String[] partes = n.split(" ");

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < partes.length; j++) {
                String word = partes[j];
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
                sb.append(" ").append(word);
            }

            nameAbility.setText(sb.toString());
        }

        return view;
    }
}
