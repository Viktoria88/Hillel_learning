
public class DesignerRepairApartmentDecorator extends ApartmentDecorator {

    public DesignerRepairApartmentDecorator(Apartment apartment) {
        super(apartment);
    }

    @Override
    protected void countOfRoom() {
        super.countOfRoom();
        setDesignerRepair(apartment);
    }

    private void setDesignerRepair(Apartment apartment){
        System.out.println("Apartment with designer repair");
    }
}
