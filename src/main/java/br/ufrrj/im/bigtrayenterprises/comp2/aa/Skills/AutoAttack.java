package br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;

/**
 * Created by vitorhnn on 31/01/17.
 */
public class AutoAttack extends Skill {
    @Override
    public String getDescription() {
        return "Ataque básico";
    }

    @Override
    public void use(Character caster, Character target) {
        int damage = caster.getAttackPower() - target.getDefensePower();

        if (damage <= 0) {
            damage = 1;
        }

        target.changeHealth(-damage);
    }
}
