package Builder;


import Product.Meal;

public abstract class MealBuilder {

    protected Meal meal;

    protected Meal getMeal() {
        System.out.println("Menu completed");
        return meal;
    }

    protected void getCost() {
        System.out.println("Total cost: " + meal.getCost());
    }

    protected void showMenu() {
        meal.showMenu();
    }

    protected void createMealMenu() {
        meal = new Meal();
    }

    protected abstract void setMeal();

    protected abstract void setName();

}
