package br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.Event;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BlankChoice extends Choice {
    public BlankChoice(String description, Event nextEvent) {
        super(description);

        this.nextEvent = nextEvent;
    }

    @Override
    public Event getNextEvent() {
        return nextEvent;
    }

    @Override
    public void executeChoice(Character character) {

    }

    private Event nextEvent;
}
