
public class InternalWorksApartmetDecorator extends ApartmentDecorator {

    public InternalWorksApartmetDecorator(Apartment apartment) {
        super(apartment);
    }

    @Override
    protected void countOfRoom() {
        super.countOfRoom();
        setInternalWorks(apartment);
    }

    private void setInternalWorks(Apartment apartment) {
        System.out.println("Apartment with internal works");
    }
}
