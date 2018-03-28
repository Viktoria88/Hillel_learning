
public abstract class ApartmentDecorator extends Apartment {

    protected Apartment apartment;

    public ApartmentDecorator(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    protected void countOfRoom() {
        apartment.countOfRoom();
    }

    @Override
    protected void countOfBathroom() {
        apartment.countOfBathroom();
    }

    @Override
    protected void areaApartment() {
        apartment.areaApartment();
    }
}
