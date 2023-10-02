package managementfunction;

import java.util.ArrayList;
import util.*;
import datapeople.*;

public class ManagerPassenger {
    private ArrayList<Passenger> psList;
    
    public ManagerPassenger() {
        psList = new ArrayList<>();
    }
    
    public void addPassenger() {
        String id = ValidPassenger.checkDuplicateID("Input id (XXXXX): ", "You must enter a numeric ID. X is a digit number"
                , "(0-9)\\d{5}", psList);
    }
}
