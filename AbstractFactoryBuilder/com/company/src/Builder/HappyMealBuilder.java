package Builder;


import Product.ChickenMacNuggets;
import Product.Juice;
import Product.PotatoFry;

public class HappyMealBuilder extends MealBuilder {

    @Override
    protected void setMeal() {
        meal.addInMenu(new ChickenMacNuggets());
        meal.addInMenu(new Juice());
        meal.addInMenu(new PotatoFry());
    }

    @Override
    public void setName() {
        System.out.println("Happy Meal");
    }
}
