package report;

import java.util.*;
import manageproduct.*;

public class Report {

    ManagerProduct mn = new ManagerProduct();

    public void expiredProducts(ArrayList<Product> listProduct) {
        Date nowTime = new Date();
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
        System.out.println("There are " + count + " expired products");
    }
}
