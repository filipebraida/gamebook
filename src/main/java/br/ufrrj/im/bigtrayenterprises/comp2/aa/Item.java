package br.ufrrj.im.bigtrayenterprises.comp2.aa;

/**
 * Representa um item genérico, que pode (ou não) ser usado durante o combate, e que adiciona seus atributos
 * ao seu respectivo Character.
 */
public abstract class Item {
    public Item(String name, Attributes attributes) {
        this.name = name;
        this.attributes = attributes;
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

    private final String name;
    private final Attributes attributes;
}
