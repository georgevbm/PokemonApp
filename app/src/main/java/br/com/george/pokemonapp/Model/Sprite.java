package br.com.george.pokemonapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sprite {
    private String front_default;

    public String getFront_default() {
        return front_default;
    }
    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    @Override
    public String toString() {
        return "Sprite{" +
                "front_default='" + front_default + '\'' +
                '}';
    }
}
