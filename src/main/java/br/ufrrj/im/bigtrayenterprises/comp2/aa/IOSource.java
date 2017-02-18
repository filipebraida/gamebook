package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;

/**
 * Created by vitorhnn on 15/02/17.
 */
public interface IOSource {
    void printString(String str);

    void addChoice(Choice choice);

    int getChoice();
}
