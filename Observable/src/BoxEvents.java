import java.util.ArrayList;
import java.util.List;

public class BoxEvents implements Observable {

    private List<MyEvent> events = new ArrayList<>();
    private List<EventAddedListener> listeners = new ArrayList<>();

    public void addEvent(MyEvent event, List<Quest> quests) {
        this.events.add(event);
        this.notifyEventAddedListener(event,quests);
    }

    @Override
    public void registerEventAddedListener(EventAddedListener e) {
        this.listeners.add(e);
    }

    @Override
    public void unregisterEventAddedListener(EventAddedListener e) {
        this.listeners.remove(e);
    }

    @Override
    public void notifyEventAddedListener(MyEvent myEvent, List<Quest> quests) {
        this.listeners.forEach(e -> e.updateEventAdded(myEvent, quests));
    }
}
