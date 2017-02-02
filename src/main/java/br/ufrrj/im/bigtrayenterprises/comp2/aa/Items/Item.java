package br.ufrrj.im.bigtrayenterprises.comp2.aa.Items;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Attributes;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;

/**
 * Representa um item genérico, que pode (ou não) ser usado durante o combate, e que adiciona seus atributos
 * ao seu respectivo Character.
 */
public abstract class Item {
    public Item(String name, Attributes attributes, int weight, ItemType type) {
        this.name = name;
        this.attributes = attributes;
        this.weight = weight;
        this.type = type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Usa este item
     *
     * @param character O personagem em que usar o item.
     */
    public abstract void use(Character character);

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
