package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Book {

    public Book(String description, Event eventInitial, Player player) {
        this.eventInitial = eventInitial;
        this.description = description;
        this.player = player;

        this.resetHistory();
    }

    public void resetHistory() {
        this.eventActually = this.eventInitial;
    }

    public String showHistory() {
        return this.eventActually.getDescription();
    }

    public boolean isTheEnd() {
        return this.eventActually.isEndEvent();
    }

    public String showHistoryBook() {
        return this.description;
    }

    public boolean nextEvent(int number) {
        Choice choice = this.selectChoice(number);

        if (choice != null) {
            choice.executeChoice(player);

            if (player.isAlive()) {
                this.eventActually = choice.getNextEvent();
                this.eventActually.applyHistory(player);
            } else {
                Event gameOver = new BlankEvent("Game Over", new ArrayList<Choice>());
                this.eventActually = gameOver;
            }

            return true;
        }

        return false;
    }

    public Choice selectChoice(int number) {
        return this.eventActually.findChoice(number);
    }

    public Collection<Choice> nextEvents() {
        return this.eventActually.getChoices();
    }

    private Event eventActually;
    private Event eventInitial;
    private String description;
    private Player player;
}
