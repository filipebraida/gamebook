package br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.AutoAttack;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Player extends Character {
    public Player(Attributes attributes) {
        super(attributes);
        addSkill(new AutoAttack());
    }
}
