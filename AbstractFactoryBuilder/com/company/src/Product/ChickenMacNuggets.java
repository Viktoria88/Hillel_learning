package Product;

public class ChickenMacNuggets extends MainCourse {

    @Override
    public String name() {
        return ItemEnum.CHICKEN_MACNUGGETS.getSymbol();
    }

    @Override
    public double price() {
        return 45.00;
    }
}
