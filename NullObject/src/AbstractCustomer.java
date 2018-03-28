
public abstract class AbstractCustomer {

    protected String name;
    public abstract boolean isNil();
    public abstract String getName();

    public int timeVisits(){
        int time = 0;
        if (isNil()){
            time++;
        }
        return time;
    }

}
