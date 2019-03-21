package br.com.george.pokemonapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* Definição da classe Type  */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TypeList {

    private String name;
    private int medal;

    public TypeList(String name, int medal) {
        this.name = name;
        this.medal = medal;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMedal() {
        return medal;
    }
    public void setMedal(int medal) {
        this.medal = medal;
    }
}
