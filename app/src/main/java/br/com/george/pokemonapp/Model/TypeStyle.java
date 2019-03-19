package br.com.george.pokemonapp.Model;

public class TypeStyle {

    private int cod;
    private int icon;
    private int medal;
    private int background;

    public TypeStyle(int cod, int icon, int medal, int background) {
        this.cod = cod;
        this.icon = icon;
        this.medal = medal;
        this.background = background;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getMedal() {
        return medal;
    }

    public void setMedal(int medal) {
        this.medal = medal;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    @Override
    public String toString() {
        return "Cod: " + cod + "\n" +
                "Icon: " + icon + "\n" +
                "Medal: " + medal + "\n" +
                "Background: " + background;
    }
}
