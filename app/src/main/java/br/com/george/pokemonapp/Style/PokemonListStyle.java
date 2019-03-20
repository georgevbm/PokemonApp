package br.com.george.pokemonapp.Style;

public class PokemonListStyle {

    private String name;
    private int background;
    private String cod;

    public PokemonListStyle(String name, int background, String cod) {
        this.name = name;
        this.background = background;
        this.cod = cod;
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

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
}
