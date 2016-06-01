/**
 * Created by filipebraida on 31/05/16.
 */
public abstract class Choice {
    public Choice(String description, Event event) {
        this.event = event;
        this.description = description;
    }

    public String getDescription() {
        return number + ": "+ this.description;
    }

    public void defineNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public Event getEvent() {
        return this.event;
    }

    public abstract void executeChoice(Character character);

    private String description;
    private Event event;
    private int number;
}
