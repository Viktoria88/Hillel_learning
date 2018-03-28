
public class Quest {

    private String content;
    private int lvl;

    public Quest(int lvl, String content) {

        this.content = content;
        this.lvl = lvl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

}
