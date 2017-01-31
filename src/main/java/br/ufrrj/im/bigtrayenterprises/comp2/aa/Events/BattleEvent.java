package br.ufrrj.im.bigtrayenterprises.comp2.aa.Events;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Enemy;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.BattleChoice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;

import java.util.ArrayList;

/**
 * Created by vitorhnn on 28/10/16.
 */
public class BattleEvent extends Event {

    // yeah java is kind of special.
    public static BattleEvent makeBattleEvent(Event postBattleEvent, Enemy enemy, Character player) {
        String desc = String.format("Seu HP: %d, HP do inimigo: %d", player.getAttributes().health, enemy.getAttributes().health);
        ArrayList<Choice> choices = new ArrayList<>();

        choices.add(new BattleChoice("Lutar!", postBattleEvent, enemy));

        return new BattleEvent(desc, choices);
    }

    private BattleEvent(String description, ArrayList<Choice> choices) {
        super(description, choices);
    }

    @Override
    public void applyHistory(Character character) {
        // nothing!
    }
}
