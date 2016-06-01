import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public class Event {
    public Event(String description, Collection<Event> choices) {
        this.description = description;
        this.choices = new ArrayList<>();
        this.choices.addAll(choices);
    }

    public String history() {
        return this.description;
    }

    public boolean isEndEvent() {
        if(this.choices.isEmpty()) return true;

        return false;
    }

    public Collection<Event> nextEvents() {
        return this.choices;
    }

    private String description;
    private Collection<Event> choices;
}
