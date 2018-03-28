import java.util.List;

public class EventAddedListenerDisplay implements EventAddedListener {

    @Override
    public void updateEventAdded(MyEvent event, List<Quest> quests) {
        display(event, quests);
    }

    public void display(MyEvent myEvent, List<Quest> quests) {
        System.out.println("Add a new event call: " + myEvent.getTitle());
        for (int i = 0; i < quests.size(); i++) {
            System.out.println("Event have some quest: " + quests.get(i).getContent());
        }
    }
}
