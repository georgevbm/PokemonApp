package br.com.george.pokemonapp.Return;

import java.util.ArrayList;

public class AbilitiesReturn {
    private ArrayList abilities;

    public ArrayList getAbilities() {
        return abilities;
    }
    public void setAbilities(ArrayList abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "AbilitiesReturn{" +
                "abilities=" + abilities +
                '}';
    }
}
