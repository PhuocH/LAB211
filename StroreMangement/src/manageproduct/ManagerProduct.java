package manageproduct;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import ui.Menu;
import util.Validation;

public class ManagerProduct {

    private ArrayList<Product> p = new ArrayList<>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean loadFromFile(String path) {
        File f = new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line = bfr.readLine();
            while (line != null) {                
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                String type = st.nextToken().trim();
                Date dateOM = sdf.parse(st.nextToken().trim());
                Date expDate = sdf.parse(st.nextToken().trim());
                System.out.println(expDate);
                int quantity = Integer.parseInt(st.nextToken());
                double price = Double.parseDouble(st.nextToken());                
                p.add(new LongLastingProduct(id, name, type, dateOM, expDate, quantity, price));                
            }
            System.out.println("Import data successful!");
            return true;
        } catch (IOException | NumberFormatException | ParseException e) {
            System.err.println("Load file error!");
            return false;
        }
    }
    
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

    public Product searchProduct(String id) {
        if (p.isEmpty()) {
            return null;
        } else {
            for (int i = 0; i < p.size(); i++) {
                if (p.get(i).getProductID().equalsIgnoreCase(id)) {
                    return p.get(i);
                }
            }
        }
        return null;
    }

    public void updateProduct() {
        if (p.isEmpty()) {
            System.out.println("The list is emty.");
        } else {            

            String searchID = Validation.getFormat("Input ID do you want to update (LXXXX): ", "Please enter the correct sytax"
                    + " (LXXXX). X is a digit", "^(L|l)\\d{4}$");
            Product pr = searchProduct(searchID);
            if (pr == null) {
                System.out.println("Product " + searchID + " is not in the list");
            } else {
                selectUpdate(pr);

            }
        }
    }

    private void selectUpdate(Product pr) {
        Menu m = new Menu();
        int choice;
        do {
            m.menuUpdate();
            choice = Validation.getInt("Input the data you want to update: ", "Please enter [1..8]", 1, 8);
            switch (choice) {
                case 1:
                    System.out.println("Before product update product name: ");
                    System.out.println("\t\t\t+-----+--------------------+-----+--------+----------------------------+");
                    System.out.printf("\t\t\t|%5s|%20s|%5s|%10s|%19s|%6s|%8s|",
                           "ID", "Name", "Type", "Date of manufacture", "Expiration Date", "Quantity", "Price");
                    String afterPN = Validation.getString("Input the product you want to update: ", "This field is required!");
                    pr.setProductName(afterPN);
                    
                    break;
            }
        } while (true);
    }
    
     public void showProduct() {
        if (p.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Product pr : p) {
                System.out.println(pr);
            }
        }
    }
}