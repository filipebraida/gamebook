package br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Engine;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.Item;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.AutoAttack;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.Skill;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Usable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Player extends Character {
    public Player(Attributes attributes) {
        super(attributes);

        this.skills = new ArrayList<>();
        this.inventory = new ArrayList<>();

        addSkill(new AutoAttack());
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void addItem(Item item) {
        Attributes attr = new Attributes(getAttributes());

        int totalWeight = 0;
        for (Item i : inventory) {
            totalWeight += i.getWeight();
        }

        if (attr.getCarryCapacity() < item.getWeight() + totalWeight) {
            Engine.source.printString("Inventário muito cheio!");
        } else {
            Engine.source.printString("Item adicionado ao inventário!");
            inventory.add(item);
        }
    }


    public void equipItem(Item item) {
        switch (item.getType()) {
            case AMULET:
                currentAmulet = item;
                break;
            case ARMOR:
                currentArmor = item;
                break;
            case WEAPON:
                currentArmor = item;
                break;
            default:
                throw new IllegalArgumentException("Attempted to equip an unequippable item");
        }
        Engine.source.printString("Equipou " + item.getName());
    }

    public Collection<Usable> getUsables() {
        ArrayList<Usable> retval = new ArrayList<>();

        for (Item i : inventory) {
            if (i instanceof Usable) {
                retval.add((Usable) i);
            }
        }

        retval.addAll(skills);

        return retval;
    }

    private Collection<Skill> skills;
    private Collection<Item> inventory;
}
