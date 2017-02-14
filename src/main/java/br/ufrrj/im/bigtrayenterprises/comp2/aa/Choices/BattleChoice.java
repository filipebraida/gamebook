package br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.AICharacter;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Player;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.BattleEvent;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.Event;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Usable;

/**
 * Created by filipebraida on 31/05/16.
 */
public class BattleChoice extends Choice {
    public BattleChoice(Event postBattleEvent, AICharacter enemy, Usable usable) {
        super(usable.getDescription());

        this.enemy = enemy;
        this.postBattleEvent = postBattleEvent;
        this.usable = usable;
    }

    @Override
    public Event getNextEvent() {
        return nextEvent;
    }

    @Override
    public void executeChoice(Player player) {
        usable.use(player, enemy);
        enemy.chooseUsable(player).use(enemy, player);

        if (enemy.isAlive()) {
            nextEvent = new BattleEvent(postBattleEvent, enemy, player);
        } else {
            nextEvent = postBattleEvent;
        }
    }

    private AICharacter enemy;
    private Event postBattleEvent;
    private Event nextEvent;
    private Usable usable;
}
