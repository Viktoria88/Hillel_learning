
public class TerraceApartmentDecorator extends ApartmentDecorator {

    public TerraceApartmentDecorator(Apartment apartment) {
        super(apartment);
    }

    @Override
    protected void countOfRoom() {
        super.countOfRoom();
        setTerrace(apartment);
    }

    private void setTerrace(Apartment apartment) {
        System.out.println("The apartment have terrace");
    }
}
