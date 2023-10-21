package main;

import functionmanager.VehicleManager;
import ui.Menu;
import util.Validation;

public class main {

    public static void main(String[] args) {
        VehicleManager vm = new VehicleManager();
        Menu m = new Menu();
        vm.loadFile();
        int choice;
        do {
            m.mainMenu();
            choice = Validation.getInt("Input your choice functions: ", "The menu only has 8 functions ", 1, 8);
            switch (choice) {
                case 1:
                    vm.addVehicle();
                    break;
                case 2:
                    vm.checkExitsVehicle();
                    break;
                case 3:
                    vm.updateVehicle();
                    break;
                case 4:
                    vm.deleteVehicle();
                    break;
                case 5:
                    vm.searchVehicle();
                    break;
                case 6:
                    vm.showVehicle();
                    break;
            }
        } while (choice != 8);
    }

}
