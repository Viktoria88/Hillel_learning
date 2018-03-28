package AbstractFactory;


import Product.*;

public class HappyMealFactory implements MenuFactory {

    @Override
    public MainCourse getMainCourse() {
        return new ChickenMacNuggets();
    }

    @Override
    public Drinks getDrinc() {
        return new Juice();
    }

    @Override
    public PotatoFry getPotatiFry() {
        return new PotatoFry();
    }
}
