package Product;

public abstract class Drinks implements Item {
    @Override
    public abstract String name();

    @Override
    public abstract double price();
}
