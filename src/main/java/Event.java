import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by filipebraida on 31/05/16.
 */
public abstract class Event {
    public Event(String description, Collection<Choice> choices) {
        this.description = description;
        this.choices = new ArrayList<>();

        int i = 0;
        for (Choice choice : choices) {
            choice.defineNumber(i);
            this.choices.add(choice);
            i++;
        }

    }

    public String history() {
        return this.description;
    }

    public boolean isEndEvent() {
        return choices.isEmpty();
    }

    public Collection<Choice> nextEvents() {
        return this.choices;
    }

    public Choice findChoice(int number) {
        for (Choice choice : this.choices) {
            if (choice.getNumber() == number) return choice;
        }

        return null;
    }

    public abstract void applyHistory(Character character);

    private String description;
    private Collection<Choice> choices;
}
