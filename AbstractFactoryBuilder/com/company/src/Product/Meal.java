package Product;


import java.util.ArrayList;
import java.util.List;

public class Meal {

    private List<Item> items = new ArrayList<>();
    private double discount = 0.05;
    String name = "";

    public String getName() {
        return name;
    }

    public void addInMenu(Item item) {
        items.add(item);
    }

    public double getCost() {

        double cost = 0.00;

        for (Item item : items) {
            cost += item.price();
        }
        return cost - (cost * discount);
    }

    public void showMenu(){
        System.out.println("Menu contains: ");
        for (Item item : items){
            System.out.println(item.name() + " price: " + item.price());
        }
    }


}
