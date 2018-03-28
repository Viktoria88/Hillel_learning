package Builder;


import Product.BigMac;
import Product.Latte;
import Product.PotatoFry;

public class BigMacMenuBuilder extends MealBuilder {

    @Override
    protected void setMeal() {
        meal.addInMenu(new BigMac());
        meal.addInMenu(new PotatoFry());
        meal.addInMenu(new Latte());
    }

    @Override
    public void setName() {
        System.out.println("BigMac menu");
    }
}
