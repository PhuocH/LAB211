package util;

import java.util.Scanner;

public class Validation {

    private static Scanner sc = new Scanner(System.in);

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

    public static int getIntUnknown(String msg, int lowerBound, int upBound) {
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
                if (n == 0) {
                    return n;
                }
                return n;
            } catch (Exception e) {
                System.err.println("Product year must be valid.");
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

    public static double getDoubleUnknown(String msg, double lowerBound, double upBound) {
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
                if (n == 0) {
                    return n;
                }
                return n;
            } catch (Exception e) {
                System.err.println("Price must be valid");
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
            System.out.print(msg);
            s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println(error);
            }
            return s;
        }
    }

    public static String getStringUnknown(String msg) {
        String s;

        while (true) {
            System.out.print(msg);
            s = sc.nextLine();
            if (s.length() == 0) {
                return "";
            }
            return s;
        }
    }
}
