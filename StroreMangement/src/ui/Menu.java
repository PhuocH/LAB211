package ui;

import manageproduct.ManagerProduct;
import util.Validation;

public class Menu {

    private ManagerProduct p = new ManagerProduct();

    public void menu(int choice) {
        switch (choice) {
            case 1:
                menuManageProduct();
                break;
            case 2:
                menuManageWarehouse(choice);
                break;
            case 3:
                menuReport(choice);
                break;
        }
    }

    public void menuManageProduct() {
        int choice;
        System.out.println("");
        System.out.println("             +-------Manage products-------+");
        System.out.println("             |1. Add a product.            |");
        System.out.println("             |2. Update product infomation.|");
        System.out.println("             |3. Delete product.           |");
        System.out.println("             |4. Show all product.         |");
        System.out.println("             |5. Exit.                     |");
        System.out.println("             +-----------------------------+");
        choice = Validation.getInt("Input your choice: ", "Please enter [1..5]", 1, 5);
        switch (choice) {
            case 1:
                p.addProductLong();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
    }

    public void menuManageWarehouse(int choice) {
        System.out.println("Manage Warehouse");
        System.out.println("1. Create an import receipt.");
        System.out.println("2. Create an export receipt.");
    }

    public void menuReport(int choice) {
        System.out.println("Report");
        System.out.println("1. Products that have expired.");
        System.out.println("2. The products that the strore is selling");
        System.out.println("3. Products that are running out of stock (sorted in ascending order.");
        System.out.println("4. Import/export receipt of a product.");
    }
}
