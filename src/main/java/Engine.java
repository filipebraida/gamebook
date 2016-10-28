import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Engine {
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
        Player player = new Player(10, 10);
        Event eventoFinal = new BlankEvent("IS DEAD", new ArrayList<>());

        ArrayList<Choice> start = new ArrayList<>();

        Enemy monstro = new Enemy(5, 5);
        BattleEvent battle = BattleEvent.makeBattleEvent(eventoFinal, monstro, player);
        Choice help = new BlankChoice("correr", eventoFinal);
        Choice fite = new BlankChoice("bater", battle);
        start.add(help);
        start.add(fite);

        Event inicial = new BlankEvent("Você encontrou um bodybuilder!", start);

        return new Book("aaa", inicial, player);
    }
}
