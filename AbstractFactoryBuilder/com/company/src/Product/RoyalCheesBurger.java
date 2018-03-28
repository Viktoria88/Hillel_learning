package Product;

public class RoyalCheesBurger extends MainCourse {
    @Override
    public String name() {
        return ItemEnum.ROYAL_CHEESBURGER.getSymbol();
    }

    @Override
    public double price() {
        return 62.00;
    }
}
