package br.com.george.pokemonapp.Model;

public class PokemonListStyle {

    private String name;
    private int background;

    public PokemonListStyle(String name, int background) {
        this.name = name;
        this.background = background;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getBackground() {
        return background;
    }
    public void setBackground(int background) {
        this.background = background;
    }
}
