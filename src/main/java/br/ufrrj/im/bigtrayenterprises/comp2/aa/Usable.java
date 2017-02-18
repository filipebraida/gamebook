package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;

/**
 * Define qualquer coisa usável por um Character durante uma batalha (skills, itens).
 */
public interface Usable {
    String getDescription();

    void use(Character caster, Character target);
}
