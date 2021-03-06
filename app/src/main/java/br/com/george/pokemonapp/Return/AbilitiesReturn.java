package br.com.george.pokemonapp.Return;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.george.pokemonapp.Model.Ability;

/* Classe que trata o retorno das habilidades de um Pokemon selecionado */

@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilitiesReturn {
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "AbilitiesReturn{" +
                "Ability: " + ability +
                '}';
    }
}
