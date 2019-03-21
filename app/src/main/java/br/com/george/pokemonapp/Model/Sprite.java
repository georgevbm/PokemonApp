package br.com.george.pokemonapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/* Definição da classe Sprite */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprite {
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "frontDefault='" + frontDefault + '\'' +
                '}';
    }
}
