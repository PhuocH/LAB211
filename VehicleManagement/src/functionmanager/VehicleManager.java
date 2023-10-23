package functionmanager;

import data.Vehicle;
import filehandle.ReadFile;
import java.util.*;
import ui.Menu;
import util.*;

public class VehicleManager {

    Menu m = new Menu();
    ArrayList<Vehicle> vList = new ArrayList<>();
    boolean ascendingOrder = true;

    public void loadFile() {
        ReadFile.loadFromFile("./data.txt", vList);
    }

    public void addVehicle() {
        String flag;
        do {
            System.out.println("");
            String id = ValidVehicle.checkDupliVehicle("Input id vehicle (VXXXXX): ",
                    "^(V|v)\\d{5}$", vList);
            String name = Validation.getString("Input name vehicle: ", "This field is required!");
            String color = Validation.getString("Input color: ", "This field is required!");
            String brand = Validation.getString("Input brand: ", "This field is required!");
            String type = Validation.getString("Input type: ", "This field is required!");
            int productYear = Validation.getInt("Input product year: ", "Year must be valid.", 2000, 2100);
            double price = Validation.getDouble("Input price: ", "Price must be valid.", 0, Double.MAX_VALUE);

            vList.add(new Vehicle(id, name, color, brand, type, productYear, price));
            System.out.println(id + " added successfully");

            flag = Validation.getFormat("Do you want to import new vehicle too(Y/N)? ", "Only Y/N", "(Y|y|N|n)");
        } while (!flag.equalsIgnoreCase("N"));
    }

    public void checkExitsVehicle() {
        String id = Validation.getFormat("Input the id you want to check (VXXXXX): ",
                "The ID should be entered as (VXXXX). X is a digit.", "^(V|v)\\d{5}$");
        if (ValidVehicle.isVehicle(id, vList) == false) {
            System.out.println(id + " is duplicated");
        } else {
            System.out.println(id + " is not in use yet");
        }
    }

    public void updateVehicle() {
        if (vList.isEmpty()) {
            System.out.println("There is no vehicle in the car!");
        }

        String id = Validation.getFormat("Input id vehicle do you want to update (VXXXXX): ",
                "The ID should be entered as (VXXXX). X is a digit.", "^(V|v)\\d{5}$");
        Vehicle v = ValidVehicle.searchVehicle(id, vList);
        if (v == null) {
            System.out.println("This ID does not exist!");
        } else {
            choiceUpdate(id, v);
        }
    }

    public void choiceUpdate(String id, Vehicle v) {
        int choice;

        do {
            m.menuUpdateVehicle();
            choice = Validation.getInt("Input your choice do you want to update: ", "Only enter within the range [1..8]", 1, 8);
            switch (choice) {
                case 1:
                    System.out.println("Vehicle name before update: ");
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    System.out.println("\t" + v);
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    String nameAf = Validation.getStringUnknown("Enter the name you want to update (press enter to skip): ");
                    if (nameAf.equals("")) {
                        System.out.println("Name not updated");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    } else {
                        v.setName(nameAf);
                        System.out.println("Vehicle name after update: ");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                case 2: {
                    System.out.println("Vehicle color before update: ");
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    System.out.println("\t" + v);
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    String colorAf = Validation.getStringUnknown("Input the color you want to update (press enter to skip): ");
                    if (colorAf.equals("")) {
                        System.out.println("Color not updated");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    } else {
                        v.setColor(colorAf);
                        System.out.println("Vehicle color after update: ");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Vehicle brand before update: ");
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    System.out.println("\t" + v);
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    String brandAf = Validation.getStringUnknown("Input the brand you want to update (press enter to skip): ");
                    if (brandAf.equals("")) {
                        System.out.println("Brand not updated");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    } else {
                        v.setBrand(brandAf);
                        System.out.println("Vehicle brand after update: ");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Vehicle type before update: ");
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    System.out.println("\t" + v);
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    String typeAf = Validation.getStringUnknown("Input the type you want to update (press 0 to skip): ");
                    if (typeAf.equals("")) {
                        System.out.println("Type not updated");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    } else {
                        v.setType(typeAf);
                        System.out.println("Vehicle type after update: ");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Vehicle product year before update: ");
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    System.out.println("\t" + v);
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    int productYearAf = Validation.getIntUnknown("Input the product year you want to update (press enter 0 to skip): ", 0, Integer.MAX_VALUE);
                    if (productYearAf == 0) {
                        System.out.println("Product year not updated");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    } else {
                        v.setProductYear(productYearAf);
                        System.out.println("Vehicle product year after update: ");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Vehicle price before update: ");
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    System.out.println("\t" + v);
                    System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    double priceAf = Validation.getDoubleUnknown("Input the price you want to update (press enter 0 to skip): ", 0, Double.MAX_VALUE);
                    if (priceAf == 0) {
                        System.out.println("Price not updated");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                    } else {
                        v.setPrice(priceAf);
                        System.out.println("Vehicle price after update: ");
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("\t" + v);
                        System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
            }
        } while (choice != 7);
    }

    public void deleteVehicle() {
        String choice;
        if (vList.isEmpty()) {
            System.out.println("There is no vehicle in the car!");
        }
        String id = Validation.getFormat("Input id vehicle do you want to delete (VXXXXX): ",
                "The ID should be entered as (VXXXX). X is a digit.", "^(V|v)\\d{5}$");
        Vehicle v = ValidVehicle.searchVehicle(id, vList);
        if (v == null) {
            System.out.println("This ID does not exist!");
        } else {
            System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
            System.out.println("\t" + v);
            System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
            choice = Validation.getFormat("Are you sure (Y/N)? ", "Only Y/N", "(Y|y|N|n)");

            if (choice.equalsIgnoreCase("N")) {
                System.out.println(id + " is not deleted!");
            } else if (choice.equalsIgnoreCase("Y")) {
                vList.remove(v);
                System.out.println("Delete " + id + " successful!");
            }
        }
    }

    public void searchVehicle() {
        if (vList.isEmpty()) {
            System.out.println("There is no vehicle in the car!");
        }

        String id = Validation.getFormat("Input id vehicle do you want to update (VXXXXX): ",
                "The ID should be entered as (VXXXX). X is a digit.", "^(V|v)\\d{5}$");
        Vehicle v = ValidVehicle.searchVehicle(id, vList);
        if (v == null) {
            System.out.println("This ID does not exist!");
        } else {
            System.out.println("Found!");
            System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
            System.out.printf("\t|%-6s|%-25s|%-15s|%-10s|%-15s|%-12s|%-9s|\n",
                    "  ID", "           Name", "    Color", "   Brand", "     Type", "Product Year", "  Price");
            System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
            System.out.println("\t" + v);
            System.out.println("\t+------+-------------------------+---------------+----------+---------------+------------+---------+");
        }
    }

    public void showVehicle() {
        if (vList.isEmpty()) {
            System.out.println("No one vehicle!");
            return;
        }
        System.out.println("+------+-------------------------+---------------+----------+---------------+------------+---------+");
        System.out.printf("|%-6s|%-25s|%-15s|%-10s|%-15s|%-12s|%-9s|\n",
                "  ID", "           Name", "    Color", "   Brand", "     Type", "Product Year", "  Price");
        System.out.println("+------+-------------------------+---------------+----------+---------------+------------+---------+");
        for (Vehicle v : vList) {
            System.out.println(v);
        }
        System.out.println("+------+-------------------------+---------------+----------+---------------+------------+---------+");
    }

    public void sort() {
        if (vList.isEmpty()) {
            System.out.println("There are no vehicle");
            return;
        }
        int choice = Validation.getInt("How do you want to arrange? ", "Only [1..9]", 1, 9);
        switch (choice) {
            case 1:
                sortById(ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 2:
                sortById(!ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 3:
                sortByPrice(ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 4:
                sortByPrice(!ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 5:
                sortByType(ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 6:
                sortByType(!ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 7:
                sortByBrand(ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 8:
                sortByBrand(!ascendingOrder);
                System.out.println("Succesful!");
                break;
            case 9:
                break;
        }
    }

    private void sortById(boolean ascendingOrder) {
        Comparator<Vehicle> idComparator = Comparator.comparing(Vehicle::getId);
        if (!ascendingOrder) {
            idComparator = idComparator.reversed();
        }
        Collections.sort(vList, idComparator);
    }

    private void sortByPrice(boolean ascendingOrder) {
        Comparator<Vehicle> priceComparator = Comparator.comparing(Vehicle::getPrice);
        if (!ascendingOrder) {
            priceComparator = priceComparator.reversed();
        }
        Collections.sort(vList, priceComparator);
    }

    private void sortByType(boolean ascendingOrder) {
        Comparator<Vehicle> typeComparator = Comparator.comparing(Vehicle::getType);
        if (!ascendingOrder) {
            typeComparator = typeComparator.reversed();
        }
        Collections.sort(vList, typeComparator);
    }

    private void sortByBrand(boolean ascendingOrder) {
        Comparator brandComparator = Comparator.comparing(Vehicle::getBrand);
        if (!ascendingOrder) {
            brandComparator = brandComparator.reversed();
        }
        Collections.sort(vList, brandComparator);
    }
}
