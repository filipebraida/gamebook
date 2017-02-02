package br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Enemy;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.BattleEvent;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.Event;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Usable;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BattleChoice extends Choice {
    public BattleChoice(String description, Event postBattleEvent, Enemy enemy, Usable usable) {
        super(description);

        this.enemy = enemy;
        this.postBattleEvent = postBattleEvent;
        this.usable = usable;
    }

    @Override
    public Event getNextEvent() {
        return nextEvent;
    }

    @Override
    public void executeChoice(Character character) {
        usable.use(character, enemy);

        if (enemy.isAlive()) {
            nextEvent = BattleEvent.makeBattleEvent(postBattleEvent, enemy, character);
        } else {
            nextEvent = postBattleEvent;
        }
    }

    private Enemy enemy;
    private Event postBattleEvent;
    private Event nextEvent;
    private Usable usable;
}
