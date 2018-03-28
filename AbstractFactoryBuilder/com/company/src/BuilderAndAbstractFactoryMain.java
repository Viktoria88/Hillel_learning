import AbstractFactory.BigMacMenuFactory;
import AbstractFactory.HappyMealFactory;
import AbstractFactory.MenuFactory;
import AbstractFactory.RoyalCheesburgerMenuFactory;
import Builder.*;
import Product.Drinks;
import Product.MainCourse;
import Product.PotatoFry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BuilderAndAbstractFactoryMain {
    public static void main(String[] args) {

        Seller seller = new Seller();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MealBuilder mealBuilder = null;
        MenuFactory menuFactory = null;
        Drinks drinks;
        MainCourse mainCourse;
        PotatoFry potatoFry;
        try {
            System.out.println("Choose what menu you would like \n" +
                    "1 - HappyMeal Menu\n" +
                    "2 - BigMac Menu\n" +
                    "3 - Royal Cheesbugreg Menu");
            int menu = Integer.parseInt(reader.readLine());

            switch (menu) {
                case 1:
                    mealBuilder = new HappyMealBuilder();
                    menuFactory = new HappyMealFactory();
                    break;
                case 2:
                    mealBuilder = new BigMacMenuBuilder();
                    menuFactory = new BigMacMenuFactory();
                    break;
                case 3:
                    mealBuilder = new RoyalCheesBurgerMenuBuilder();
                    menuFactory = new RoyalCheesburgerMenuFactory();
                    break;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Builder:");
        seller.setMealBuilder(mealBuilder);
        seller.createNewMealMenu();

        System.out.println("\nAbstract Factory");
        drinks = menuFactory.getDrinc();
        mainCourse = menuFactory.getMainCourse();
        potatoFry = menuFactory.getPotatiFry();
        System.out.printf("Your menu: %s %s %s ", drinks.name(), mainCourse.name(), potatoFry.name());
    }
}
