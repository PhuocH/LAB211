package util;

import dataflight.Flight;
import java.util.ArrayList;

public class ValidFlight extends Validation{

    private static boolean isDupliFlightID(ArrayList<Flight> fList, String id) {
        for (int i = 0; i < fList.size(); i++) {
            if (fList.get(i).getFightNumber().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    public static String checkDuplicateFlight(String msg, String error, String format, ArrayList<Flight> fList) {
        while (true) {
            String id = getFormat(msg, error, error);

            if (!id.matches(format)) {
                continue;
            }

            if (isDupliFlightID(fList, id) == false) {
                System.out.println("Duplicated number flight. Please input again!");
                continue;
            }
            return id;
        }
    }
    
    private static int getChoiceFlight(ArrayList<Flight> fList) {        
        for (int i = 0; i < fList.size(); i++) {
            System.out.println((i + 1) + "/ " + fList.get(i).toString());
        }
        System.out.println("This is a list of available planes, which trip do you choose to take?");
        int choice = getInt("Please input your choice: ", "The list has only " + fList.size() + "flights"
                , 1, fList.size());
        return choice;
    }
    
    public static Flight choiceFlight(ArrayList<Flight> fList) {
        if (fList.isEmpty()) {
            System.out.println("There are no flights");
            return null;
        }
        int i = getChoiceFlight(fList);
        return fList.get(i - 1);
    }
}
