package br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Engine;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(Attributes attributes, Collection<Item> inventory) {
        this.attributes = attributes;
        this.tempAttributes = new Attributes(attributes);
        this.inventory = inventory;
    }

    public Character(Attributes attributes) {
        this(attributes, new ArrayList<>());
    }

    public void battle(Character enemy) {
        {
            int damage = getAttackPower() - enemy.getDefensePower();

            if (damage <= 0) {
                damage = 1;
            }

            enemy.changeHealth(-damage);
        }

        {
            int damage = enemy.getAttackPower() - getDefensePower();

            if (damage <= 0) {
                damage = 1;
            }

            changeHealth(-damage);
        }
    }

    public int getDefensePower() {
        Attributes thisAttr = getAttributes();

        return thisAttr.agility + thisAttr.armor + Engine.random.nextInt(5) + 1;
    }

    public int getAttackPower() {
        Attributes thisAttr = getAttributes();

        return thisAttr.strength + thisAttr.agility + Engine.random.nextInt(5) + 1;
    }

    public void changeHealth(int delta) {
        tempAttributes.health += delta;
    }

    public boolean isAlive() {
        return tempAttributes.health > 0;
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

    public void equipItem(Item item) {
        if (item instanceof Activable) {
            System.out.println("Não é um item equipável!");
            return;
        }

        if (item instanceof Weapon) {
            currentWeapon = (Weapon) item;
        } else if (item instanceof Amulet) {
            currentAmulet = (Amulet) item;
        } else if (item instanceof Armor) {
            currentArmor = (Armor) item;
        }
        System.out.println("Equipou " + item.getName());
    }

    private Attributes tempAttributes;
    private Attributes attributes;
    private Collection<Item> inventory;

    private Weapon currentWeapon;
    private Armor currentArmor;
    private Amulet currentAmulet;
}
