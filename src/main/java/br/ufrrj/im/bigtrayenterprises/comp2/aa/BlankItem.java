package main.java.br.ufrrj.im.bigtrayenterprises.comp2.aa;

/**
 * Uma classe representando um item simples, que não pode ser usado.
 */
public class BlankItem extends Item {
    public BlankItem(String name, Attributes attributes) {
        super(name, attributes);
    }

    @Override
    public void use(Character character) {
        // nothing!
    }
}
