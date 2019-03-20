package br.com.george.pokemonapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import br.com.george.pokemonapp.Adapter.TypeAdapter;
import br.com.george.pokemonapp.Model.Type;
import br.com.george.pokemonapp.Model.TypeStyle;
import br.com.george.pokemonapp.R;
import br.com.george.pokemonapp.Return.PokemonThirdReturn;
import br.com.george.pokemonapp.Return.TypeReturn;
import br.com.george.pokemonapp.Util.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GridView gridTypes;
    private TypeAdapter adapter;
    private ArrayList<Type> types;
    private ArrayList<TypeStyle> styles;
    private ArrayList<PokemonThirdReturn> pokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gridTypes = (GridView) findViewById(R.id.grid_types);
        types = new ArrayList<>();
        pokemons = new ArrayList<>();

        populateStylesType();

        Call<TypeReturn> call = new RetrofitConfig().getPokemonService().getTypes();
        call.enqueue(new Callback<TypeReturn>() {
            @Override
            public void onResponse(Call<TypeReturn> call, Response<TypeReturn> response) {
                TypeReturn typeReturn = response.body();

                types = typeReturn.getResults();

                types.remove(types.size() - 1);
                types.remove(types.size() - 1);

                for (Type t : types) {
                    t.setCod(Integer.parseInt(t.getUrl().substring(t.getUrl().length() - 3).replace("/", "")));

                    String n = t.getName().substring(0, 1).toUpperCase().concat(t.getName().substring(1));
                    t.setName(n);

                    for (TypeStyle ts : styles) {
                        if (t.getCod() == ts.getCod()) {
                            t.setStyle(ts);
                        }
                    }
                }

                adapter = new TypeAdapter(MainActivity.this, types);
                gridTypes.setAdapter(adapter);

                gridTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        for (Type type : types) {
                            if (position + 1 == type.getCod()) {
                                int backgroundColor = backgroundListPokemons(type.getCod());

                                Intent intent = new Intent(MainActivity.this, PokemonsActivity.class);
                                intent.putExtra("nameType", type.getName());
                                intent.putExtra("codType", type.getCod());
                                intent.putExtra("backgrounType", backgroundColor);
                                startActivity(intent);
                            }
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<TypeReturn> call, Throwable t) {
                Log.e("PokemonService   ", "Erro ao buscar os types:" + t.getMessage());
            }
        });
    }

    private int backgroundListPokemons(int cod) {
        switch (cod) {
            case 1:
                return R.color.colorNormal;
            case 2:
                return R.color.colorFighting;
            case 3:
                return R.color.colorFlying;
            case 4:
                return R.color.colorPoison;
            case 5:
                return R.color.colorGround;
            case 6:
                return R.color.colorRock;
            case 7:
                return R.color.colorBug;
            case 8:
                return R.color.colorGhost;
            case 9:
                return R.color.colorSteel;
            case 10:
                return R.color.colorFire;
            case 11:
                return R.color.colorWater;
            case 12:
                return R.color.colorGrass;
            case 13:
                return R.color.colorEletric;
            case 14:
                return R.color.colorPsychic;
            case 15:
                return R.color.colorIce;
            case 16:
                return R.color.colorDragon;
            case 17:
                return R.color.colorDark;
            case 18:
                return R.color.colorFairy;
            default:
                return 0;
        }
    }

    private void populateStylesType() {
        styles = new ArrayList<>();

        TypeStyle styleNormal = new TypeStyle(1, R.drawable.icon_normal, R.drawable.medal_normal, R.drawable.background_normal);
        TypeStyle styleFighting = new TypeStyle(2, R.drawable.icon_fighting, R.drawable.medal_fighting, R.drawable.background_fighting);
        TypeStyle styleFlying = new TypeStyle(3, R.drawable.icon_flying, R.drawable.medal_flying, R.drawable.background_flying);
        TypeStyle stylePoison = new TypeStyle(4, R.drawable.icon_poison, R.drawable.medal_poison, R.drawable.background_poison);
        TypeStyle styleGround = new TypeStyle(5, R.drawable.icon_ground, R.drawable.medal_ground, R.drawable.background_ground);
        TypeStyle styleRock = new TypeStyle(6, R.drawable.icon_rock, R.drawable.medal_rock, R.drawable.background_rock);
        TypeStyle styleBug = new TypeStyle(7, R.drawable.icon_bug, R.drawable.medal_bug, R.drawable.background_bug);
        TypeStyle styleGhost = new TypeStyle(8, R.drawable.icon_ghost, R.drawable.medal_ghost, R.drawable.background_ghost);
        TypeStyle styleSteel = new TypeStyle(9, R.drawable.icon_steel, R.drawable.medal_steel, R.drawable.background_steel);
        TypeStyle styleFire = new TypeStyle(10, R.drawable.icon_fire, R.drawable.medal_fire, R.drawable.background_fire);
        TypeStyle styleWater = new TypeStyle(11, R.drawable.icon_water, R.drawable.medal_water, R.drawable.background_water);
        TypeStyle styleGrass = new TypeStyle(12, R.drawable.icon_grass, R.drawable.medal_grass, R.drawable.background_grass);
        TypeStyle styleEletric = new TypeStyle(13, R.drawable.icon_electric, R.drawable.medal_electric, R.drawable.background_electric);
        TypeStyle stylePsychic = new TypeStyle(14, R.drawable.icon_psychic, R.drawable.medal_psychic, R.drawable.background_psychic);
        TypeStyle styleIce = new TypeStyle(15, R.drawable.icon_ice, R.drawable.medal_ice, R.drawable.background_ice);
        TypeStyle styleDragon = new TypeStyle(16, R.drawable.icon_dragon, R.drawable.medal_dragon, R.drawable.background_dragon);
        TypeStyle styleDark = new TypeStyle(17, R.drawable.icon_dark, R.drawable.medal_dark, R.drawable.background_dark);
        TypeStyle styleFairy = new TypeStyle(18, R.drawable.icon_fairy, R.drawable.medal_fairy, R.drawable.background_fairy);

        styles.add(styleNormal);
        styles.add(styleFighting);
        styles.add(styleFlying);
        styles.add(stylePoison);
        styles.add(styleGround);
        styles.add(styleRock);
        styles.add(styleBug);
        styles.add(styleGhost);
        styles.add(styleSteel);
        styles.add(styleFire);
        styles.add(styleWater);
        styles.add(styleGrass);
        styles.add(styleEletric);
        styles.add(stylePsychic);
        styles.add(styleIce);
        styles.add(styleDragon);
        styles.add(styleDark);
        styles.add(styleFairy);
    }


}
