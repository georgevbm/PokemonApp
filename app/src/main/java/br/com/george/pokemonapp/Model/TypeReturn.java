package br.com.george.pokemonapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties({"next", "previous"})
public class TypeReturn {

    private int count;
    private ArrayList<Type> results;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Type> getResults() {
        return results;
    }
    public void setResults(ArrayList<Type> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return  "Count: " + count +
                "Results: " + results;
    }
}
