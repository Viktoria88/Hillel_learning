package Product;

public class Latte extends Drinks {

    @Override
    public String name() {
        return ItemEnum.LATTE.getSymbol();
    }

    @Override
    public double price() {
        return 25.00;
    }
}
