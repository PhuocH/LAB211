package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);
    public static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

    public static String getFormat(String msg, String error, String format) {
        String s;
        boolean match;

        while (true) {
            try {
                System.out.print(msg);
                s = sc.nextLine();
                match = s.matches(format);
                if (s.isEmpty()|| match == false) {
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
            System.out.print(msg);
            s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println(error);
            }
            return s;
        }
    }

    public static Date getDateFromString(String msg, String error) {
        while (true) {
            try {
                System.out.print(msg);
                String dateStr = sc.nextLine().trim();
                String[] dateParts = dateStr.split("/");
                if (dateParts.length != 3) {
                    throw new Exception();
                }

                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);

                if (isValidDate(day, month, year)) {
                    Date date = sdf.parse(dateStr);
                    return date;
                } else {
                    System.err.println("Invalid day or month. Please input again.");
                }
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    private static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return false;
        }

        return !(day < 1 || day > getMonth(month, year));
    }

    private static int getMonth(int month, int year) {
        int[] mth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return mth[month];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
