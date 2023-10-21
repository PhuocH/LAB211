package functionmanager;

import data.Vehicle;
import filehandle.ReadFile;
import java.util.*;
import ui.Menu;
import util.*;

public class VehicleManager {

    Menu m = new Menu();
    ArrayList<Vehicle> vList = new ArrayList<>();

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
            m.menuUpdateVehicle();
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
                    System.out.println(v);
                    String nameAf = Validation.getStringUnknown("Enter the name you want to update (press enter to skip): ");
                    if (nameAf.equals("")) {
                        System.out.println("Name not updated");
                        System.out.println(v);
                    } else {
                        v.setName(nameAf);
                        System.out.println("Vehicle name after update: ");
                        System.out.println(v);
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                case 2: {
                    System.out.println("Vehicle color before update: ");
                    System.out.println(v);
                    String colorAf = Validation.getStringUnknown("Input the color you want to update (press enter to skip): ");
                    if (colorAf.equals("")) {
                        System.out.println("Color not updated");
                        System.out.println(v);
                    } else {
                        v.setColor(colorAf);
                        System.out.println("Vehicle color after update: ");
                        System.out.println(v);
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Vehicle brand before update: ");
                    System.out.println(v);
                    String brandAf = Validation.getStringUnknown("Input the brand you want to update (press enter to skip): ");
                    if (brandAf.equals("")) {
                        System.out.println("Brand not updated");
                        System.out.println(v);
                    } else {
                        v.setBrand(brandAf);
                        System.out.println("Vehicle brand after update: ");
                        System.out.println(v);
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Vehicle type before update: ");
                    System.out.println(v);
                    String typeAf = Validation.getStringUnknown("Input the type you want to update (press 0 to skip): ");
                    if (typeAf.equals("")) {
                        System.out.println("Type not updated");
                        System.out.println(v);
                    } else {
                        v.setType(typeAf);
                        System.out.println("Vehicle type after update: ");
                        System.out.println(v);
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Vehicle product year before update: ");
                    System.out.println(v);
                    int productYearAf = Validation.getIntUnknown("Input the product year you want to update (press enter 0 to skip): ", 0, Integer.MAX_VALUE);
                    if (productYearAf == 0) {
                        System.out.println("Product year not updated");
                        System.out.println(v);
                    } else {
                        v.setProductYear(productYearAf);
                        System.out.println("Vehicle product year after update: ");
                        System.out.println(v);
                        System.out.println("Update " + id + " successful");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Vehicle price before update: ");
                    System.out.println(v);
                    double priceAf = Validation.getDoubleUnknown("Input the price you want to update (press enter 0 to skip): ", 0, Double.MAX_VALUE);
                    if (priceAf == 0) {
                        System.out.println("Price not updated");
                        System.out.println(v);
                    } else {
                        v.setPrice(priceAf);
                        System.out.println("Vehicle price after update: ");
                        System.out.println(v);
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
            System.out.println(v);
            choice = Validation.getFormat("Are you sure (Y/N)? ", "Only Y/N", "(Y|y|N|n)");

            if (choice.equalsIgnoreCase("N")) {
                System.out.println("");
            } else if (choice.equalsIgnoreCase("Y")) {
                vList.remove(v);
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
            System.out.println(v);
        }
    }

    public void showVehicle() {
        for (Vehicle v : vList) {
            System.out.println(v);
        }
    }
}
