package managementfunction;

import dataflight.Flight;
import java.util.*;
import util.*;

public class ManagerFlight {
    ArrayList<Flight> fList = new ArrayList<>();
    
    public void addFlight() {
        String id = ValidFlight.checkDuplicateFlight("Input number Flight (FXXXX): ", 
                "The flight code is (FXXXXX). X is a digit number. Please re-enter", "(F|f)\\d{5}", fList);
        String departureCity = Validation.getString("Please input departure city: ", "This field is required!");
        String cityArrives = Validation.getString("Please input city arrives: ", "This field is required!");
        Date despartuneTime = Validation.getDateFromString("Input despartune time: ", "Invalid date. Please input again!");
        Date arrivalTime = Validation.getDateFromString("Input arrvial time: ", "Invalid date. Please input again!");
        
    }
    
}
