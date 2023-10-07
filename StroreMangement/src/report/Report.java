package report;

import java.util.*;
import manageproduct.*;
import managewarehouse.ManagerWareHouse;
import managewarehouse.WareHouse;
import util.ValidationProduct;

public class Report {

    ManagerProduct mn = new ManagerProduct();
    ManagerWareHouse mw = new ManagerWareHouse();
    private Date nowTime = new Date();

//    private Date searchDate(Date date, ArrayList<Product> list) {
//        date = ValidationProduct.getDate("Input date do you want to search: ", "Error");
//        for (Product pr : list) {
//            if (pr.getExpirationDate().compareTo(date))
//        }
//    }
    public void expiredProducts(ArrayList<Product> listProduct) {
        int count = 0;
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");

        Date date = ValidationProduct.getDate("Input date do you want to search: ", "Error");
        for (Product pr : listProduct) {
            if (pr.getExpirationDate().compareTo(date) > 0) {
                mn.reportProduct(pr);
                count++;
            }
        }
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.println("There are " + count + " expired products.");
    }

    public void sellingProduct(ArrayList<Product> listProduct) {
        int count = 0;
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
        for (Product pr : listProduct) {
            if (pr.getQuantity() > 0 && pr.getExpirationDate().compareTo(nowTime) > 0) {
                mn.reportProduct(pr);
                count++;
            }
        }
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.println("There are " + count + " products being sold by the store.");
    }

    public void areRunningOutStock(ArrayList<Product> listProduct) {
        int count = 0;
        ArrayList<Product> listStock = new ArrayList();
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
        for (Product pr : listProduct) {
            if (pr.getQuantity() <= 3 && pr.getExpirationDate().compareTo(nowTime) > 0) {
                listStock.add(pr);
            }
        }
        Comparator<Product> c = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getQuantity(), o2.getQuantity());
            }
        };
        Collections.sort(listStock, c);
        for (Product product : listStock) {
            mn.reportProduct(product);
            count++;
        }

        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.println("There are " + count + " products that are out of stock.");
    }

    public void reportReceipt(ArrayList<WareHouse> wh) {
        if (wh.isEmpty()) {
            System.out.println("The list is emty");
            return;
        }
        for (WareHouse whr : wh) {
            System.out.println(whr);
        }
    }
}
