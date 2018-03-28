package AbstractFactory;


import Product.*;

public class BigMacMenuFactory implements MenuFactory {

    @Override
    public MainCourse getMainCourse() {
        return new BigMac();
    }

    @Override
    public Drinks getDrinc() {
        return new Latte();
    }

    @Override
    public PotatoFry getPotatiFry() {
        return new PotatoFry();
    }
}
