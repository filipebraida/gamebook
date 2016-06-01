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

        while(true) {
            System.out.println(book.showHistory());

            if(book.isTheEnd()) break;

            System.out.println("Escolha:  ");

            for(Choice choice:book.nextEvents()) {
                System.out.println(choice.getDescription());
            }

            int i;
            do {
                i = in.nextInt();
            } while(!book.nextEvent(i));
        }

        System.out.println("Fim de Jogo");
    }

    public static Book createBook() {
        Event eventoFinal = new Event("Você morreu porque o Duarte não mandou ir para a trilha.", new ArrayList<Choice>());

        Collection escolhasIniciais = new ArrayList<Choice>();
        Choice escolhaFinalTrilha = new Choice("Segue a trilha", eventoFinal);
        Choice escolhaFinalFloresta = new Choice("Fica na floresta", eventoFinal);
        escolhasIniciais.add(escolhaFinalTrilha);
        escolhasIniciais.add(escolhaFinalFloresta);

        Event eventoInitial = new Event("Você está em uma floresta. " +
                "O Sensei Duarte falou para você ficar na floresta treinando " +
                "o amakakeiru 12/12.", escolhasIniciais);

        Book livro = new Book("A história da Rural", eventoInitial);

        return livro;
    }
}
