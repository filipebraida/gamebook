package main.java.br.ufrrj.im.bigtrayenterprises.comp2.aa;

import java.util.ArrayList;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Character {

    public Character(Attributes attributes, ArrayList<Item> inventory) {
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
        Attributes atrr = new Attributes(getAttributes());

        int totalWeight = 0;
        for(Item i : inventory) {
            totalWeight += i.getWeight();
        }

        if(atrr.getCarryCapacity() < item.getWeight() + totalWeight) {
            System.out.println("Invetário muito cheio!");
        } else {
            System.out.println("Item adicionado ao inventário!");
            inventory.add(item);
        }
    }

    public Attributes getAttributes() {
        Attributes tempWithItems = new Attributes(tempAttributes);

        for (Item item : equipped) {
            tempWithItems.concatenate(item.getAttributes());
        }

        return tempWithItems;
    }

    public void equipItem(Item item) {
        if (item instanceof Activable) {
            System.out.println("Não é um item equipável!");
        } else {
            if (item instanceof Weapon) {
                for (Item i : equipped) {
                    if (i instanceof Weapon) {
                        System.out.println("Desequipou " + i.getName());
                        equipped.remove(i);
                    }
                }
            } else if (item instanceof Amulet) {
                for (Item i : equipped) {
                    if (i instanceof Amulet) {
                        System.out.println("Desequipou " + i.getName());
                        equipped.remove(i);
                    }
                }
            } else if (item instanceof Armor) {
                for (Item i : equipped) {
                    if (i instanceof Armor) {
                        System.out.println("Desequipou " + i.getName());
                        equipped.remove(i);
                    }
                }
            }
        }
        System.out.println("Equipou " + item.getName());
        equipped.add(item);
    }

    private Attributes tempAttributes;
    private Attributes attributes;
    private ArrayList<Item> inventory;
    private ArrayList<Item> equipped;
}
