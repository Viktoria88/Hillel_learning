package Product;

public class Juice extends Drinks {

    @Override
    public String name() {
        return ItemEnum.JUICE.getSymbol();
    }

    @Override
    public double price() {
        return 15.00;
    }
}
