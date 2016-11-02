package br.ufrrj.im.bigtrayenterprises.comp2.aa;

public class AttributeBuilder {
    private int strength = 2;
    private int agility = 2;
    private int resistance = 2;
    private int armor = 2;
    private int firepower = 2;

    public AttributeBuilder setStrength(int strength) {
        this.strength = strength;
        return this;
    }

    public AttributeBuilder setAgility(int agility) {
        this.agility = agility;
        return this;
    }

    public AttributeBuilder setResistance(int resistance) {
        this.resistance = resistance;
        return this;
    }

    public AttributeBuilder setArmor(int armor) {
        this.armor = armor;
        return this;
    }

    public AttributeBuilder setFirepower(int firepower) {
        this.firepower = firepower;
        return this;
    }

    public Attributes createAttributes() {
        return new Attributes(strength, agility, resistance, armor, firepower);
    }
}