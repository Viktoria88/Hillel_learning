package AbstractFactory;


import Product.Drinks;
import Product.MainCourse;
import Product.PotatoFry;

public interface MenuFactory {

    MainCourse getMainCourse();
    Drinks getDrinc();
    PotatoFry getPotatiFry();
}
