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
        this.description = description;

        this.resetHistory();
    }

    public void resetHistory() {
        this.eventActually = this.eventInitial;
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

    public boolean nextEvent(int number) {
        Event event = this.choiceEvent(number);

        if(event != null) {
            this.eventActually = event;
            return true;
        }

        return false;
    }

    public Event choiceEvent(int number) {
        return this.eventActually.findEvent(number);
    }

    public Collection<Choice> nextEvents() {
        return this.eventActually.nextEvents();
    }

    private Event eventActually;
    private Event eventInitial;
    private String description;
}
