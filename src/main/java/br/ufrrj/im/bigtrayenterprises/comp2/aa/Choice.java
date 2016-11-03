package main.java.br.ufrrj.im.bigtrayenterprises.comp2.aa;

/**
 * Created by filipebraida on 31/05/16.
 */
public abstract class Choice {
    public Choice(String description) {
        this.description = description;
    }

    public String getDescription() {
        return number + ": " + this.description;
    }

    public void defineNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public abstract Event getNextEvent();

    public abstract void executeChoice(Character character);

    private String description;
    private int number;
}
