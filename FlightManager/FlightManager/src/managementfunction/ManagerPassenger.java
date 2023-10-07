package managementfunction;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import util.*;
import datapeople.*;

public class ManagerPassenger {
    private ArrayList<Passenger> psList;
    
    public ManagerPassenger() {
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
        psList = new ArrayList<>();
    }
    
    public void addPassenger() {
<<<<<<< HEAD
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
        
=======
        String id = ValidPassenger.checkDuplicateID("Input id (XXXXX): ", "You must enter a numeric ID. X is a digit number"
                , "(0-9)\\d{5}", psList);
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
    }
}
