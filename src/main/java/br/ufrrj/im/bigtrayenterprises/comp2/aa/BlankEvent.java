package main.java.br.ufrrj.im.bigtrayenterprises.comp2.aa;

import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BlankEvent extends Event {
    public BlankEvent(String description, Collection<Choice> choices) {
        super(description, choices);
    }

    @Override
    public void applyHistory(Character character) {

    }
}
