import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Engine {
    public static void main(String[] args) throws IOException {
        Book book = Engine.createBook();

        System.out.println(book.showHistoryBook());

        Scanner in = new Scanner(System.in);

        do {
            System.out.println(book.showHistory());

            System.out.println("Escolha:  ");

            for(Choice choice:book.nextEvents()) {
                System.out.println(choice.getDescription());
            }

            int i;
            do {
                i = in.nextInt();
            } while(!book.nextEvent(i));
        } while(!book.isTheEnd());

        System.out.println(book.showHistory());
    }

    public static Book createBook() {
        Event eventoFinal = new BlankEvent("Você morreu porque o Duarte não mandou ir para a trilha.", new ArrayList<Choice>());

        Collection escolhasIniciais = new ArrayList<Choice>();
        Choice escolhaFinalTrilha = new BlankChoice("Segue a trilha", eventoFinal);
        Choice escolhaFinalFloresta = new BlankChoice("Fica na floresta", eventoFinal);
        escolhasIniciais.add(escolhaFinalTrilha);
        escolhasIniciais.add(escolhaFinalFloresta);

        Event eventoInitial = new BlankEvent("Você está em uma floresta. " +
                "O Sensei Duarte falou para você ficar na floresta treinando " +
                "o amakakeiru 12/12.", escolhasIniciais);

        Book livro = new Book("A história da Rural", eventoInitial, new Player(10, 10));

        return livro;
    }
}
