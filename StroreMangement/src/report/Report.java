package report;

import java.util.*;
import manageproduct.*;

public class Report {

    ManagerProduct mn = new ManagerProduct();
    private Date nowTime = new Date();

    public void expiredProducts(ArrayList<Product> listProduct) {
        int count = 0;
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.printf("   | %-5s|%-20s|%-6s|%-10s|%-19s|%-6s|%-8s|\n",
                " ID", "        Name", " Type", "Date of manufacture", "  Expiration Date", "Quantity", "  Price");
        for (Product pr : listProduct) {
            if (pr.getExpirationDate().compareTo(nowTime) < 0) {
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
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getQuantity(), o2.getQuantity());
            }
        });
        
        for (Product product : listStock) {
            mn.reportProduct(product);
        }
        System.out.println("   +------+--------------------+------+-------------------+-------------------+--------+--------+");
        System.out.println("There are " + count + " products that are out of stock.");
    }
}
