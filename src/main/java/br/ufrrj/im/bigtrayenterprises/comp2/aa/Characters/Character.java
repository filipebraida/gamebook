package br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Engine;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.Item;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Skills.Skill;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Usable;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(Attributes attributes, Collection<Item> inventory, Collection<Skill> skills) {
        this.attributes = attributes;
        this.tempAttributes = new Attributes(attributes);
        this.inventory = inventory;
        this.skills = skills;
    }

    public Character(Attributes attributes) {
        this(attributes, new ArrayList<>(), new ArrayList<>());
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

    public boolean isAlive() {
        return tempAttributes.health > 0;
    }

    public void changeHealth(int delta) {
        tempAttributes.health += delta;
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
            System.out.println("Inventário muito cheio!");
        } else {
            System.out.println("Item adicionado ao inventário!");
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
        System.out.println("Equipou " + item.getName());
    }

    private Attributes tempAttributes;
    private Attributes attributes;
    private Collection<Item> inventory;
    private Collection<Skill> skills;

    private Item currentWeapon;
    private Item currentArmor;
    private Item currentAmulet;
}
