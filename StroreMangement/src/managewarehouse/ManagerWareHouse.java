package managewarehouse;

import browsefile.FileWareHouse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.util.*;
import manageproduct.ManagerProduct;
import manageproduct.Product;
import util.*;

public class ManagerWareHouse {

    public static ArrayList<WareHouse> whList = new ArrayList();
    private ManagerProduct mp;
    private ArrayList<Product> prList = new ArrayList<>();
    Product pd = new Product();
    FileWareHouse fl = new FileWareHouse();

    public ManagerWareHouse() {
        whList = new ArrayList<>();
    }

    public ArrayList<WareHouse> getWhList() {
        return whList;
    }
    
    public boolean loadFromFile(String path) {
        File f = new File(path);
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) { // Check if there are 4 parts
                    String code = parts[1].trim();
                    String dateStr = parts[2].trim();
                    Date date = ValidationProduct.dF.parse(dateStr);

                    String mapString = parts[3].trim();
                    Map<String, Integer> mapData = new HashMap<>();
                    mapString = mapString.substring(1, mapString.length() - 1); // Remove curly braces {}
                    String[] keyValuePairs = mapString.split(",");
                    for (String keyValue : keyValuePairs) {
                        String[] keyValueArr = keyValue.trim().split("=");
                        String key = keyValueArr[0].trim();
                        int value = Integer.parseInt(keyValueArr[1].trim());
                        mapData.put(key, value);
                    }

                    WareHouse wh = new WareHouse(code, date, mapData);
                    whList.add(wh);
                }
            }
            System.out.println(whList.size());
            System.out.println("Import data warehouse.dat successful!");
            return true;
        } catch (Exception e) {
            System.out.println("warehouse.dat error!");
            return false;
        }
    }


    public void createProduct() {
        Map<String, Integer> mapList = new HashMap<>();
        int code = whList.size() + 1;
        String codeStr = String.format("IM%07d", code);
        String check;
        do {
            String codeProduct = ValidationProduct.checkDuplicateID("Input the name of the imported product (L/SXXXX): ",
                    "Please enter the correct sytax (L/SXXXX). X is a digit", "^[S|s|L|l]\\d{4}$", prList);
            int quantity = ValidationProduct.getInt("Input the import quantity: ", "Enter the appropriate value. Re-enter!", 0, Integer.MAX_VALUE);
            int index = ValidationProduct.getIndexProductCode(codeProduct, ManagerProduct.p);
            if (index >= 0) {
                int x = quantity + ManagerProduct.p.get(index).getQuantity();
                ManagerProduct.p.get(index).setQuantity(x);
            } else {
                String productName = ValidationProduct.getString("Input the product name: ", "This field is required");
                String type = ValidationProduct.getString("Input the product type: ", "This field is required");
                double price = ValidationProduct.getDouble("Input price: ", "Enter the appropriate value", 0, Double.MAX_VALUE);
                Date dateOfManufacture = ValidationProduct.getDate("Input the manufacturing date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
                Date expirationDate = ValidationProduct.getDate("Input the expiration date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
                ManagerProduct.p.add(new Product(codeProduct, productName, type, dateOfManufacture, expirationDate, quantity, price));
            }
            mapList.put(codeProduct, quantity);

            try {
                String x = ValidationProduct.dF.format(new Date());
                ValidationProduct.dF.parse(x);
            } catch (ParseException e) {
            }

            check = ValidationProduct.getFormat("Do you want to continue creating new product? (Y/N): ", "Only (Y/N)", "(Y|y|N|n)");

        } while (!check.equalsIgnoreCase("N"));

        whList.add(new WareHouse(codeStr, new Date(), mapList));
        System.out.println("Add successfull!!");
//        show();
    }

    public void expirtation() {
        Map<String, Integer> mapList = new HashMap<>();

        int code = whList.size() + 1;
        String codeStr = String.format("EM%07d", code);
        String check;

        do {
            String codeProduct = ValidationWareHouse.getCodeRight("Input the name of the imported product (L/SXXXX): ",
                    "Please enter the correct sytax (L/SXXXX). X is a digit", "^[S|s|L|l]\\d{4}$");
            int quantity = ValidationProduct.getInt("Input the import quantity: ", "Enter the appropriate value. Re-enter!", 0, Integer.MAX_VALUE);
            int index = ValidationProduct.getIndexProductCode(codeProduct, ManagerProduct.p);
            if (index >= 0) {
                if (quantity > ManagerProduct.p.get(index).getQuantity()) {
                    System.err.println("You cannot add to an invoice when the quantity you need to export is greater than the quantity of products.");
                    System.err.println("Ex-stock quantity only " + pd.getQuantity());
                } else {
                    int x = ManagerProduct.p.get(index).getQuantity() - quantity;
                    ManagerProduct.p.get(index).setQuantity(x);
                    mapList.put(codeProduct, quantity);
                }
            }
            check = ValidationProduct.getFormat("Do you want to continue creating new product? (Y/N): ", "Only (Y/N)", "(Y|y|N|n)");
            if (mapList.isEmpty()) {
                System.err.println("No products were added to the export list.");
            }
        } while (!check.equalsIgnoreCase(check));
        
        Date time = null;
        try {
            String x = ValidationProduct.dF.format(new Date());
            time = ValidationProduct.dF.parse(x);
        } catch (ParseException e) {
        }
        
        if (!mapList.isEmpty()) {
            whList.add(new WareHouse(codeStr, time, mapList));
            System.out.println("Add successful!!");
        }
    }

    public void show(WareHouse wh) {
            System.out.println(wh);
    }

    public void saveToFile() {
        fl.saveToFile(whList, "./warehouse.dat");
    }
}
