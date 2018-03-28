package Builder;


public class Seller {

    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mb){
        mealBuilder = mb;
    }

    public void createNewMealMenu(){
        mealBuilder.createMealMenu();
        mealBuilder.setName();
        mealBuilder.setMeal();
        mealBuilder.showMenu();
        mealBuilder.getCost();
        mealBuilder.getMeal();
    }
}
