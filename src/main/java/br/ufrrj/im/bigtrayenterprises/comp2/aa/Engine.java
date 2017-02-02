package br.ufrrj.im.bigtrayenterprises.comp2.aa;

import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Character;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Enemy;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Characters.Player;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.BlankChoice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Choices.Choice;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.BattleEvent;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.BlankEvent;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Events.Event;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.Item;
import br.ufrrj.im.bigtrayenterprises.comp2.aa.Items.ItemType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Engine {
    public static Random random = new Random();

    public static void main(String[] args) throws IOException {
        Book book = Engine.testBook();

        System.out.println(book.showHistoryBook());

        Scanner in = new Scanner(System.in);

        do {
            System.out.println(book.showHistory());

            System.out.println("Escolha:  ");

            for (Choice choice : book.nextEvents()) {
                System.out.println(choice.getDescription());
            }

            int i;
            do {
                i = in.nextInt();
            } while (!book.nextEvent(i));
        } while (!book.isTheEnd());

        System.out.println(book.showHistory());
    }

    public static Book testBook() {
        Attributes attr = new AttributeBuilder()
                .setAgility(2)
                .setStrength(2)
                .setResistance(2)
                .setArmor(2)
                .setFirepower(2)
                .createAttributes();

        Player player = new Player(attr);
        Item branch =
                new Item(
                        "Ironwood Branch",
                        new AttributeBuilder()
                                .setAgility(1)
                                .setStrength(1)
                                .setResistance(1)
                                .setArmor(1)
                                .setFirepower(1)
                                .createAttributes(),
                        10,
                        ItemType.AMULET
                ) {
                    @Override
                    public void use(Character character) {
                        character.changeHealth(-5);
                    }
                };

        player.addItem(branch);
        player.equipItem(branch);

        Event eventoFinal = new BlankEvent("IS DEAD", new ArrayList<>());

        ArrayList<Choice> start = new ArrayList<>();

        Attributes monstroAttr = new AttributeBuilder()
                .setAgility(2)
                .setStrength(1)
                .setResistance(1)
                .setArmor(0)
                .setFirepower(0)
                .createAttributes();

        Enemy monstro = new Enemy(monstroAttr);
        BattleEvent battle = BattleEvent.makeBattleEvent(eventoFinal, monstro, player);
        Choice help = new BlankChoice("correr", eventoFinal);
        Choice fite = new BlankChoice("bater", battle);
        start.add(help);
        start.add(fite);

        Event inicial = new BlankEvent("Você encontrou um bodybuilder!", start);

        return new Book("aaa", inicial, player);
    }
}
