import java.util.List;
import java.util.Map;

public class MyEvent {

    private String title;
    List<Quest> quests;

    public MyEvent(String title, List<Quest> quests) {
        this.title = title;
        this.quests = quests;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }
}
