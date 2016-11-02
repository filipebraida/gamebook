package br.ufrrj.im.bigtrayenterprises.comp2.aa;

/**
 * Created by vitorhnn on 01/11/16.
 */
public class Attributes {
    public int health;
    public int mana;

    public int strength;
    public int agility;
    public int resistance;
    public int armor;
    public int firepower;

    public Attributes(int strength, int agility, int resistance, int armor, int firepower) {
        this.strength = strength;
        this.agility = agility;
        this.resistance = resistance;
        this.armor = armor;
        this.firepower = firepower;

        health = mana = resistance * 5;
    }

    public Attributes(Attributes other) {
        this.health = other.health;
        this.mana = other.mana;
        this.strength = other.strength;
        this.agility = other.agility;
        this.resistance = other.resistance;
        this.armor = other.armor;
        this.firepower = other.firepower;
    }
}
