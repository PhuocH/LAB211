package manageproduct;

import java.util.*;
import util.Validation;

public class ManagerProduct {

    ArrayList<Product> p = new ArrayList<>();

    public void addProductLong() {
        String check;
        do {
            String productID = Validation.checkDuplicateID("Input ID (LXXXX): ", "Please enter the correct sytax"
                    + " (LXXXX). X is a digit", "^(L|l)\\d{4}$", p);
            String productNamme = Validation.getString("Input the product name: ", "This field is required");
            String type = Validation.getString("Input the product type: ", "This field is required");
            int quantity = Validation.getInt("Input the product quanlity: ", "Enter the appropriate value", 0, Integer.MAX_VALUE);
            double price = Validation.getDouble("Input price: ", "Enter the appropriate value", 0, Double.MAX_VALUE);
            Date dateOfManufacture = Validation.getDate("Input the manufacturing date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
            Date expirationDate = Validation.getDate("Input the expiration date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
            p.add(new LongLastingProduct(productID, productNamme, type, dateOfManufacture, expirationDate, quantity, price));
            System.out.println("Data import successful!");
            
            check = Validation.getFormat("Do you want to continue creating new product? (Y/N): ", "Only (Y/N)", "(Y|y|N|n)");
        } while (!check.equalsIgnoreCase("N"));
    }
    
    public void updateProduct() {
        
    }
}
