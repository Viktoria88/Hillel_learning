
public class StudioApartment extends Apartment {
    @Override
    protected void countOfRoom() {
        int room = 1;
        String roomDescription = "One room with one window";
        int kitchen = 1;
        String kitchenDescription = "Kitchen studio with relax area";
        System.out.println(roomDescription + "\n" + kitchenDescription);
    }

    @Override
    protected void countOfBathroom() {
        int bathroom = 1;
        String bathroomDescription = "Bath combined with toilet";
        System.out.println(bathroomDescription);
    }

    @Override
    protected void areaApartment() {
        Double[] area = {45.2, 55.6, 59.8, 65.3, 72.9};
        for (int i = 0; i < area.length; i++) {
            System.out.println("Area can be: " + area[i]);
        }
    }
}
