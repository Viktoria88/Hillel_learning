
public class CustomerFactory {

    public static final String[] customers = {"Tony", "Food", "Vitaliy"};

    public static AbstractCustomer getCustomer(String name) {

        for (int i = 0; i < customers.length; i++) {
            if (customers[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }

}
