package br.com.george.pokemonapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

import br.com.george.pokemonapp.Return.AbilitiesReturn;

/* Definição da classe Pokemon */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private int id;
    private String name;
    private double weight;
    private double height;
    private ArrayList<AbilitiesReturn> abilities;
    private Sprite sprites;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public ArrayList<AbilitiesReturn> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<AbilitiesReturn> abilities) {
        this.abilities = abilities;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "Name: " + name + "\n" +
                "Weight: " + weight + "\n" +
                "Height: " + height + "\n" +
                "Abilities: " + abilities + "\n" +
                "Sprites: " + sprites;
    }
}
