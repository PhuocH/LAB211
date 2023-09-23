package managewarehouse;

import browsefile.FileWareHouse;
import java.io.*;
import java.text.ParseException;
import java.time.*;
import java.util.*;
import manageproduct.ManagerProduct;
import manageproduct.Product;
import util.Validation;

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

//    public boolean loadFromFile(String path) {
//        File f = new File(path);
//        try {
//            FileReader fr = new FileReader(f);
//            BufferedReader bfr = new BufferedReader(fr);
//            String line;
//            while ((line = bfr.readLine()) != null) {
//                StringTokenizer st = new StringTokenizer(line, "|");
//                String code = st.nextToken().trim();
//                String productID = st.nextToken().trim();
//                String dateStr = st.nextToken().trim();
//
//                int quantity = Integer.parseInt(st.nextToken().trim());
//                double unitPrice = Double.parseDouble(st.nextToken().trim());
//
//                Date date = Validation.dF.parse(dateStr);
//                Product p = new Product(productID, "", "", null, null, 0, 0);
//                WareHouse wh = new WareHouse(code, p, date, quantity, unitPrice);
////                wh.setUnitPrice(totalPrice);
//                whList.add(wh);
//            }
//            System.out.println("Import data successful!");
//            return true;
//        } catch (IOException | NumberFormatException | ParseException e) {
//            System.err.println("Load file error!");
//            return false;
//        }
//    }
    public void createProduct() {
        Map<String, Integer> mapList = new HashMap<>();
        int code = whList.size() + 1;
        String codeStr = String.format("IM%07d", code);
        String check;
        do {
            String codeProduct = Validation.checkDuplicateID("Input the name of the imported product (L/SXXXX): ",
                    "Please enter the correct sytax (L/SXXXX). X is a digit", "^[S|s|L|l]\\d{4}$", prList);
            int quantity = Validation.getInt("Input the import quantity: ", "Enter the appropriate value. Re-enter!", 0, Integer.MAX_VALUE);
            int index = Validation.getIndexProductCode(codeProduct, ManagerProduct.p);
            if (index >= 0) {
                int x = quantity + ManagerProduct.p.get(index).getQuantity();
                ManagerProduct.p.get(index).setQuantity(x);
            } else {
                String productName = Validation.getString("Input the product name: ", "This field is required");
                String type = Validation.getString("Input the product type: ", "This field is required");
                double price = Validation.getDouble("Input price: ", "Enter the appropriate value", 0, Double.MAX_VALUE);
                Date dateOfManufacture = Validation.getDate("Input the manufacturing date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
                Date expirationDate = Validation.getDate("Input the expiration date (DD/MM/YYYY): ", "Invalid date format. Please re-enter.");
                ManagerProduct.p.add(new Product(codeProduct, productName, type, dateOfManufacture, expirationDate, quantity, price));
            }
            mapList.put(codeProduct, quantity);

            try {
                String x = Validation.dF.format(new Date());
                Validation.dF.parse(x);
            } catch (ParseException e) {
            }

            check = Validation.getFormat("Do you want to continue creating new product? (Y/N): ", "Only (Y/N)", "(Y|y|N|n)");

        } while (!check.equalsIgnoreCase("N"));

        whList.add(new WareHouse(codeStr, new Date(), mapList));
        System.out.println("Add successfull!!");
    }

}
