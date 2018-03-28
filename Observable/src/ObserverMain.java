import java.util.ArrayList;
import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {

        List<Quest> quests = new ArrayList<>();
        quests.add(new Quest(1, "find"));
        quests.add(new Quest(2, "go on"));
        quests.add(new Quest(3, "remind"));
        BoxEvents boxEvents = new BoxEvents();
        MyEvent myEvent = new MyEvent("Happy Birdsday", quests);

        boxEvents.registerEventAddedListener(new EventAddedListenerDisplay());

        boxEvents.addEvent(myEvent, quests);
    }
}
