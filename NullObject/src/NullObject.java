
public class NullObject {

    public static void main(String[] args) {

        AbstractCustomer customer1 = CustomerFactory.getCustomer("Oleg");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Food");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Tony");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Kate");

        System.out.println(customer1.isNil());
        System.out.println(customer2.isNil());

        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
