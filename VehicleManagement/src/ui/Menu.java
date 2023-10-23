package ui;

public class Menu {

    public void mainMenu() {
        System.out.println("");
        System.out.println("        +~~~~~~~~~~~~~~~~~~Vehicle Management~~~~~~~~~~~~~~~~~~+");
        System.out.println("        |   1. Add new vehicle.                                |");
        System.out.println("        |   2. Check exits Vehicle.                            |");
        System.out.println("        |   3. Update vehicle.                                 |");
        System.out.println("        |   4. Delete vehicle.                                 |");
        System.out.println("        |   5. Search vehicle.                                 |");
        System.out.println("        |   6. Display all Vehicle.                            |");
        System.out.println("        |   7. Save all vehicles to file.                      |");
        System.out.println("        |   8. Sort.                                           |");
        System.out.println("        |   9. Exit.                                           |");
        System.out.println("        +~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
    }

    public void menuUpdateVehicle() {
        System.out.println("\t  +-------------------------+");
        System.out.println("\t  |1. Update name.          |");
        System.out.println("\t  |2. Update color.         |");
        System.out.println("\t  |3. Update brand.         |");
        System.out.println("\t  |4. Update type.          |");
        System.out.println("\t  |5. Update product year.  |");
        System.out.println("\t  |6. Update price.         |");
        System.out.println("\t  |7. Exit.                 |");
        System.out.println("\t  +-------------------------+");
    }

    public void menuSort() {
        System.out.println("\t  +-------------------------+");
        System.out.println("\t  |1. Sort By ID (ACS).     |");
        System.out.println("\t  |2. Sort By ID (DECS).    |");
        System.out.println("\t  |3. Sort By Price (ACS).  |");
        System.out.println("\t  |4. Sort By Price (DECS). |");
        System.out.println("\t  |5. Sort By Type (ACS).   |");
        System.out.println("\t  |6. Sort By Type (DECS).  |");
        System.out.println("\t  |7. Sort By Brand (ACS).  |");
        System.out.println("\t  |8. Sort By Brand (DECS). |");
        System.out.println("\t  |9. Exit.                 |");
        System.out.println("\t  +-------------------------+");
    }
}
