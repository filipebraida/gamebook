package br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Engine;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.Item;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(Attributes attributes) {
        this.attributes = attributes;
        this.tempAttributes = new Attributes(attributes);
    }

    public int getDefensePower() {
        Attributes thisAttr = getAttributes();

        return thisAttr.agility + thisAttr.armor + Engine.random.nextInt(5) + 1;
    }

    public int getAttackPower() {
        Attributes thisAttr = getAttributes();

        return thisAttr.strength + thisAttr.agility + Engine.random.nextInt(5) + 1;
    }

    public Attributes getAttributes() {
        Attributes tempWithItems = new Attributes(tempAttributes);

        if (currentWeapon != null) {
            tempWithItems.concatenate(currentWeapon.getAttributes());
        }

        if (currentAmulet != null) {
            tempWithItems.concatenate(currentAmulet.getAttributes());
        }

        if (currentArmor != null) {
            tempWithItems.concatenate(currentArmor.getAttributes());
        }

        return tempWithItems;
    }


    public boolean isAlive() {
        return tempAttributes.health > 0;
    }

    public void changeHealth(int delta) {
        tempAttributes.health += delta;
    }


    private Attributes tempAttributes;
    private Attributes attributes;

    protected Item currentWeapon;
    protected Item currentArmor;
    protected Item currentAmulet;
}
