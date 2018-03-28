package Product;

public class BigMac extends MainCourse {
    @Override
    public String name() {
        return ItemEnum.BIGMAC.getSymbol();
    }

    @Override
    public double price() {
        return 65.00;
    }
}
