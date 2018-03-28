import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemplateMethodMain {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Apartment apartment = null;
        System.out.print("\nChoose how many rooms you wont \n" +
                "1 - Studio Apartment\n" +
                "2 - Two Room flat\n" +
                "3 - Three Room flat\n");
        int countRoom = Integer.parseInt(reader.readLine());
        System.out.println("\nDo you wont any decorations \n" +
                "1 - No, thanks\n" +
                "2 - I would like terrace\n" +
                "3 - I wold like internal works\n" +
                "4 - I wold like internal works and terrace\n" +
                "5 - I wold like internal works and design repair\n" +
                "6 - I wold like internal works, design repair and terrace\n");

        int decorations = Integer.parseInt(reader.readLine());

        switch (countRoom) {
            case 1:
                switch (decorations) {
                    case 1:
                        apartment = new StudioApartment();
                        break;
                    case 2:
                        apartment = new TerraceApartmentDecorator(new StudioApartment());
                        break;
                    case 3:
                        apartment = new InternalWorksApartmetDecorator(new StudioApartment());
                        break;
                    case 4:
                        apartment = new TerraceApartmentDecorator(
                                new InternalWorksApartmetDecorator(
                                        new StudioApartment()));
                        break;
                    case 5:
                        apartment = new DesignerRepairApartmentDecorator(
                                new InternalWorksApartmetDecorator(
                                        new StudioApartment()));
                        break;
                    case 6:
                        apartment = new DesignerRepairApartmentDecorator(
                                new TerraceApartmentDecorator(
                                        new InternalWorksApartmetDecorator(
                                                new StudioApartment())));
                        break;
                }
                    case 2:
                        switch (decorations) {
                            case 1:
                                apartment = new TwoRoomFlat();
                                break;
                            case 2:
                                apartment = new TerraceApartmentDecorator(new TwoRoomFlat());
                                break;
                            case 3:
                                apartment = new InternalWorksApartmetDecorator(new TwoRoomFlat());
                                break;
                            case 4:
                                apartment = new TerraceApartmentDecorator(
                                        new InternalWorksApartmetDecorator(
                                                new TwoRoomFlat()));
                                break;
                            case 5:
                                apartment = new DesignerRepairApartmentDecorator(
                                        new InternalWorksApartmetDecorator(
                                                new TwoRoomFlat()));
                                break;
                            case 6:
                                apartment = new DesignerRepairApartmentDecorator(
                                        new TerraceApartmentDecorator(
                                                new InternalWorksApartmetDecorator(
                                                        new TwoRoomFlat())));
                                break;
                        }
                    case 3:
                        switch (decorations) {
                            case 1:
                                apartment = new ThreeRoomFlat();
                                break;
                            case 2:
                                apartment = new TerraceApartmentDecorator(new ThreeRoomFlat());
                                break;
                            case 3:
                                apartment = new InternalWorksApartmetDecorator(new ThreeRoomFlat());
                                break;
                            case 4:
                                apartment = new TerraceApartmentDecorator(
                                        new InternalWorksApartmetDecorator(
                                                new ThreeRoomFlat()));
                                break;
                            case 5:
                                apartment = new DesignerRepairApartmentDecorator(
                                        new InternalWorksApartmetDecorator(
                                                new ThreeRoomFlat()));
                                break;
                            case 6:
                                apartment = new DesignerRepairApartmentDecorator(
                                        new TerraceApartmentDecorator(
                                                new InternalWorksApartmetDecorator(
                                                        new ThreeRoomFlat())));
                                break;
                        }
                }
                apartment.Apartament();
        }
    }
