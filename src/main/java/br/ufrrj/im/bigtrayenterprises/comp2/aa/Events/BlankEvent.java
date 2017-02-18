package br.ufrrj.im.bigtrayenterprises.comp2.aa.Events;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;

import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BlankEvent extends Event {
    public BlankEvent(Collection<Choice> choices, String description) {
        super(choices);

        this.description = description;
    }

    @Override
    public void applyHistory(Character character) {
    }

    @Override
    public String getDescription() {
        return description;
    }

    private String description;
}
