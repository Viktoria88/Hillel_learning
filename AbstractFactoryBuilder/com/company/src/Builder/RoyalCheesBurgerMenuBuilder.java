package Builder;


import Product.CocaCola;
import Product.PotatoFry;
import Product.RoyalCheesBurger;

public class RoyalCheesBurgerMenuBuilder extends MealBuilder {

    @Override
    protected void setMeal() {
        meal.addInMenu(new RoyalCheesBurger());
        meal.addInMenu(new PotatoFry());
        meal.addInMenu(new CocaCola());
    }

    @Override
    public void setName() {
        System.out.println("Royal CheesBurger Menu");
    }
}
