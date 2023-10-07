package util;

import java.text.SimpleDateFormat;
import java.util.*;
import manageproduct.ManagerProduct;
import manageproduct.Product;

public class ValidationProduct {

    public static final SimpleDateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

    private static Scanner sc = new Scanner(System.in);
    public static ArrayList<Product> listProduct = ManagerProduct.p;

    public static int getInt(String msg, String error, int lowerBound, int upBound) {
        if (lowerBound > upBound) {
            int t = lowerBound;
            lowerBound = upBound;
            upBound = t;
        }

        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static double getDouble(String msg, String error, double lowerBound, double upBound) {
        if (lowerBound > upBound) {
            double t = lowerBound;
            lowerBound = upBound;
            upBound = t;
        }

        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static String getFormat(String msg, String error, String format) {
        String s;
        boolean match;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine().trim();
                match = s.matches(format);
                if (s.isEmpty() || match == false) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.err.println(error);
            }

        }
    }

    public static String getString(String msg, String error) {
        String s;
        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine();
                if (s.isEmpty()) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    public static Date getDate(String msg, String error) {
        while (true) {
            try {
                System.out.print(msg);
                String dateString = sc.nextLine().trim();
                String[] dateParts = dateString.split("/");
                if (dateParts.length != 3) {
                    throw new Exception();
                }

                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (isValidDate(day, month, year)) {
                    Date date = dF.parse(dateString);
                    return date;
                } else {
                    System.err.println("Invalid day or month. Please input again.");
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

    private static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        return !(day < 1 || day > checkMonth(month, year));
    }

    private static int checkMonth(int month, int year) {
        int[] dM = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return dM[month];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static Product isDuplicateProduct(String id, ArrayList<Product> p) {
        for (Product pr : p) {
            if (pr.getProductID().equalsIgnoreCase(id)) {
                return pr;
            }
        }
        return null;
    }

    public static String checkDuplicateID(String inputMsg, String error, String format, ArrayList<Product> p) {
        while (true) {
            String productID = getFormat(inputMsg, error, format);

            if (!productID.matches(format)) {
                continue;
            }
            if (isDuplicateProduct(productID, p) != null) {
                System.out.println("Duplicated productID. Please input another one!");
                continue;
            }
            return productID;
        }
    }

    public static int getIndexProductCode(String id, ArrayList<Product> prList) {
        if (prList.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < prList.size(); i++) {
            if (prList.get(i).getProductID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    

}
