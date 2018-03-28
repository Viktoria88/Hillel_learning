package AbstractFactory;


import Product.*;

public class RoyalCheesburgerMenuFactory implements MenuFactory {

    @Override
    public MainCourse getMainCourse() {
        return new RoyalCheesBurger();
    }

    @Override
    public Drinks getDrinc() {
        return new CocaCola();
    }

    @Override
    public PotatoFry getPotatiFry() {
        return new PotatoFry();
    }
}
