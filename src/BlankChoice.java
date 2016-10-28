/**
 * Created by filipebraida on 31/05/16.
 */
public class BlankChoice extends Choice {
    public BlankChoice(String description, Event nextEvent) {
        super(description);

        this.nextEvent = nextEvent;
    }

    @Override
    public Event getNextEvent() {
        return nextEvent;
    }

    @Override
    public void executeChoice(Character character) {

    }

    private Event nextEvent;
}
