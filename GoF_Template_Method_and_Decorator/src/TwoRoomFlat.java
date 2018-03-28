
public class TwoRoomFlat extends Apartment {
    @Override
    protected void countOfRoom() {
        int room = 2;
        String roomDescription = "Two room with two window";
        int kitchen = 1;
        String kitchenDescription = "Kitchen studio with relax area or only kitchen";
        System.out.println(roomDescription + "\n" + kitchenDescription);
    }

    @Override
    protected void countOfBathroom() {
        int bathroom = 1;
        String bathroomDescription = "Bath separated toilet";
        System.out.println(bathroomDescription);
    }

    @Override
    protected void areaApartment() {
        Double[] area = {55.6, 59.8, 65.3, 72.9, 78.4, 82.5, 96.3};
        for (int i = 0; i < area.length; i++) {
            System.out.println("Area can be: " + area[i]);
        }
    }
}
