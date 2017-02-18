package br.ufrrj.im.bigtrayenterprises.comp2.aa.Events;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.AICharacter;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Player;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.BattleChoice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Usable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by vitorhnn on 28/10/16.
 */
public class BattleEvent extends Event {
    public BattleEvent(Event postBattleEvent, AICharacter enemy, Player player) {
        super(new ArrayList<>());

        this.postBattleEvent = postBattleEvent;
        this.enemy = enemy;
        this.player = player;
    }

    @Override
    public String getDescription() {
        return String.format("Seu HP: %d, HP do inimigo: %d", player.getAttributes().health, enemy.getAttributes().health);
    }

    @Override
    public Collection<Choice> getChoices() {
        // this is kind of a hack, and I should be ashamed of it
        // but it is needed to load the player's usables when the event triggers, not when it's built
        ArrayList<Choice> retval = new ArrayList<>();

        int i = 0;
        for (Usable usable : player.getUsables()) {
            Choice bChoice = new BattleChoice(postBattleEvent, enemy, usable);
            bChoice.setNumber(i);

            retval.add(bChoice);

            i++;
        }

        this.addChoices(retval);

        return retval;
    }

    @Override
    public boolean isEndEvent() {
        return false;
    }

    @Override
    public void applyHistory(Character character) {
        // nothing!
    }

    private Event postBattleEvent;
    private AICharacter enemy;
    private Player player;
}
