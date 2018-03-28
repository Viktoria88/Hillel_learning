package Product;

public class CocaCola extends Drinks {

    @Override
    public String name() {
        return ItemEnum.COCACOLA.getSymbol();
    }

    @Override
    public double price() {
        return 20.00;
    }
}
