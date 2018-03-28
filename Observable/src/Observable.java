import java.util.List;

public interface Observable {

    void registerEventAddedListener(EventAddedListener e);

    void unregisterEventAddedListener(EventAddedListener e);

    void notifyEventAddedListener(MyEvent event, List<Quest> quests);
}
