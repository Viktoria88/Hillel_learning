
public class ThreeRoomFlat extends Apartment {
    @Override
    protected void countOfRoom() {
        int room = 3;
        String roomDescription = "Three room with three window";
        int kitchen = 1;
        String kitchenDescription = "Kitchen studio with relax area or only kitchen";
        System.out.println(roomDescription + "\n" + kitchenDescription);
    }

    @Override
    protected void countOfBathroom() {
        int bathroom = 2;
        String bathroomDescription = "Bath combined with toilet and bath separated toilet";
        System.out.println(bathroomDescription);
    }

    @Override
    protected void areaApartment() {
        Double[] area = {72.9, 78.4, 82.5, 96.3, 102.6, 112.8, 125.8};
        for (int i = 0; i < area.length; i++) {
            System.out.println("Area can be: " + area[i]);
        }
    }
}
