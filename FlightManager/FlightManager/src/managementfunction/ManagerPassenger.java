package managementfunction;

import java.util.*;
import util.*;
import dataflight.Flight;
import datapeople.*;
import ui.Menu;

public class ManagerPassenger {
    private ArrayList<Passenger> psList;
    private Flight fList;
    Menu m = new Menu();
    
    public ManagerPassenger(Flight fList) {
        this.fList = fList;
        psList = new ArrayList<>();
    }
    
    public void addPassenger() {
        Map<String, List<Flight>> mapLists = new HashMap<>();                
        
        String id = ValidPassenger.checkDuplicateID("Input id: ", "You must enter a numeric ID. X is a digit number"
                , "(0-9)\\d{5}", psList);
        String name = Validation.getString("Input name passenger: ", "This field is required");
        Date date = Validation.getDateFromString("Input birthday passenger: ", "Invalid date. Please try again.");
        String phone = Validation.getFormat("Input phone number: ", "Invalid phone number", "(0-9)");
        String email = Validation.getFormat("Input email: ", 
                "Invalid email. Format: abcxyz@gmail.com", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        
        psList.add(new Passenger(id, name, date, phone, email, mapLists));
        
        
    }
    
    public Flight searchFlight(ArrayList<Flight> fList) {
        m.menuFlight();
        String searchDepartCity = Validation.getString("Please enter the city you want to depart from: ", "This field is required!");
        
    }
}
