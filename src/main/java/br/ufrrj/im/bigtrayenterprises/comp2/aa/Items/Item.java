package br.ufrrj.im.bigtrayenterprises.comp2.aa.Items;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;

/**
 * Representa um item genérico, que pode (ou não) ser usado durante o combate, e que adiciona seus atributos
 * ao seu respectivo Character.
 */
public class Item {
    public Item(String name, Attributes attributes, int weight, ItemType type) {
        this.name = name;
        this.attributes = attributes;
        this.weight = weight;
        this.type = type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public ItemType getType() {
        return type;
    }

    private final String name;
    private final Attributes attributes;
    private final int weight;
    private final ItemType type;
}
