package Product;

public class PotatoFry implements Item {

    @Override
    public String name() {
        return ItemEnum.POTATO_FRY.getSymbol();
    }

    @Override
    public double price() {
        return 25.00;
    }
}
