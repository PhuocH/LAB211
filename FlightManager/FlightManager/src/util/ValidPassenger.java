package util;

import datapeople.Passenger;
import java.util.ArrayList;

public class ValidPassenger extends Validation {

    private static boolean isDuplicatePassenger(ArrayList<Passenger> pList, String id) {
        for (Passenger p : pList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static String checkDuplicateID(String msg, String error, String format, ArrayList<Passenger> pList) {
        while (true) {
            String id = getFormat(msg, error, format);
            if (!id.matches(format)) {
                continue;
            }
            if (isDuplicatePassenger(pList, id) == false) {
                System.out.println("Duplicated id. Please input another one!");
                continue;
            }
            return id;
        }
    }
}
