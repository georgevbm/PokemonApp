package br.com.george.pokemonapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.george.pokemonapp.Model.Type;
import br.com.george.pokemonapp.R;

public class TypeAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Type> types;

    public TypeAdapter(@NonNull Context c, @NonNull ArrayList<Type> objects) {
        super(c, 0, objects);
        context = c;
        types = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = null;

        if (types != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.adapter_types, parent, false);

            ImageView iconType1 = (ImageView) view.findViewById(R.id.icon_type);
            TextView nameType1 = (TextView) view.findViewById(R.id.name_type);
            LinearLayout llType1 = (LinearLayout) view.findViewById(R.id.layout_type);

            Type type = types.get(position);

            nameType1.setText(type.getName());
            iconType1.setImageResource(type.getStyle().getIcon());
            llType1.setBackgroundResource(type.getStyle().getBackground());
        }

        return view;
    }
}
