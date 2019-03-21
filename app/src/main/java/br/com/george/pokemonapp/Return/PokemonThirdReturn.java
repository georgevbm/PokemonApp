package br.com.george.pokemonapp.Return;

/* Classe que trata o terceiro retorno dos Pokemons de um tipo selecionado */

public class PokemonThirdReturn {
    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Url: " + url + "\n" +
                "Name: " + name;
    }
}
