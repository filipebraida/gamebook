import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Book {

    public Book(String description, Event eventInitial) {
        this.eventInitial = eventInitial;
        this.eventActually = eventInitial;
        this.description = description;
    }

    public String showHistory() {
        return this.eventActually.history();
    }

    public boolean isTheEnd() {
        return this.eventActually.isEndEvent();
    }

    public String showHistoryBook(){
        return this.description;
    }

    public static void main(String[] args) throws IOException {
        Book book = Book.createBook();

        System.out.println(book.showHistoryBook());

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println(book.showHistory());

            if(book.isTheEnd()) break;

            System.out.printf("Escolha a opção:  ");

            for(Event event:book.nextEvents()) {
                System.out.println();
                System.out.println(event.history());
            }
            int i = in.nextInt();

            System.out.println(i);
        }
    }

    public Collection<Event> nextEvents() {
        return this.eventActually.nextEvents();
    }

    public static Book createBook() {
        Event eventoFinal = new Event("Game Over", new ArrayList<Event>());
        Collection eventosIniciais = new ArrayList<Event>();
        eventosIniciais.add(eventoFinal);

        Event eventoInitial = new Event("Bem vindo a história", eventosIniciais);

        Book livro = new Book("Vem vindo a história X", eventoInitial);

        return livro;
    }

    private Character character;
    private Event eventActually;
    private Event eventInitial;
    private String description;
}
