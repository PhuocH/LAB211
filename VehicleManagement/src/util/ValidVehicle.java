package util;

import data.Vehicle;
import java.util.*;

public class ValidVehicle extends Validation {

    public static boolean isVehicle(String id, ArrayList<Vehicle> vList) {
        for (Vehicle v : vList) {
            if (v.getId().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static String checkDupliVehicle(String msg, String format, ArrayList<Vehicle> vList) {
        while (true) {
            String id = getFormat(msg, "The ID should be entered as (VXXXX). X is a digit.", format);

            if (!id.matches(format)) {
                continue;
            }

            if (isVehicle(id, vList) == false) {
                System.out.println("Duplicated id. Please input another one!");
                continue;
            }
            return id;
        }
    }
    
    public static Vehicle searchVehicle(String id, ArrayList<Vehicle> vList) {
        if (vList.isEmpty())
            return null;
        for (Vehicle v : vList) {
            if (v.getId().equalsIgnoreCase(id))
                return v;
        }
        return null;
    }
}
