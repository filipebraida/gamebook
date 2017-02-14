package br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Usable;

/**
 * Created by filipebraida on 31/05/16.
 */
public abstract class AICharacter extends Character {
    public AICharacter(Attributes attributes) {
        super(attributes);
    }

    /**
     * Chooses a Usable to be used against enemy
     *
     * @param enemy The current enemy
     * @return A Usable, to be used on enemy
     */
    public abstract Usable chooseUsable(Character enemy);
}
