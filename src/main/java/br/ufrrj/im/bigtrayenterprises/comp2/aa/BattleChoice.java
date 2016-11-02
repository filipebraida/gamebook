package br.ufrrj.im.bigtrayenterprises.comp2.aa;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BattleChoice extends Choice {
    public BattleChoice(String description, Event postBattleEvent, Enemy enemy) {
        super(description);

        this.enemy = enemy;
        this.postBattleEvent = postBattleEvent;
    }

    @Override
    public Event getNextEvent() {
        return nextEvent;
    }

    @Override
    public void executeChoice(Character character) {
        character.battle(this.enemy);

        if (enemy.isAlive()) {
            nextEvent = BattleEvent.makeBattleEvent(postBattleEvent, enemy, character);
        } else {
            nextEvent = postBattleEvent;
        }
    }

    private Enemy enemy;
    private Event postBattleEvent;
    private Event nextEvent;
}
