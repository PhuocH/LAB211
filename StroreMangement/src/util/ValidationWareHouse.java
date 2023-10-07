package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import manageproduct.*;
import managewarehouse.WareHouse;

public class ValidationWareHouse {

    public static ArrayList<Product> listProductRight = ManagerProduct.p;

    public static String getCodeRight(String input, String error, String format) {
        boolean match;
        while (true) {
            String id = ValidationProduct.getString(input, error);
            match = id.matches(format);
            if (match == false || id.isEmpty()) {
                System.err.println(error);
                continue;
            } else if (getProductCodeRight(id, listProductRight) == null) {
                System.out.println("Product code is not exists or expired. Please enter another product code.!!");
                continue;
            }
            return id;
        }
    }

    public static Product getProductCodeRight(String id, ArrayList<Product> list) {
        if (list.isEmpty()) {
            return null;
        }
        for (Product pr : list) {
            if (pr.getProductID().equalsIgnoreCase(id) && pr.getExpirationDate().compareTo(new Date()) > 0) {
                return pr;
            }
        }

        return null;
    }
    
    // Returns the order ID to find in the list
    public static WareHouse getProductCode(String id, ArrayList<WareHouse> listWare) {
        if (listWare.isEmpty()) {
            return null;
        }

        for (WareHouse wh : listWare) {
            if (id.equalsIgnoreCase(wh.getId())) {
                return wh;
            }
        }
        return null;
    }
}
