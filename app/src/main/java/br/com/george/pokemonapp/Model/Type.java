package br.com.george.pokemonapp.Model;

import br.com.george.pokemonapp.Style.TypeStyle;

/* Definição da classe Type */

public class Type {
    private int cod;
    private String name;
    private TypeStyle style;
    private String url;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeStyle getStyle() {
        return style;
    }

    public void setStyle(TypeStyle style) {
        this.style = style;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Cod: " + cod + "\n" +
                "Name: " + name + "\n" +
                "Url: " + url + "\n" +
                "Style: " + style.toString();
    }
}
