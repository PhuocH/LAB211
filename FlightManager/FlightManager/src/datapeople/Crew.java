package datapeople;

import java.util.*;
import dataflight.Flight;

public class Crew extends People{
    private String role;
    public Map<String, List<Flight>> crewMap;

    public Crew(String role, Map<String, List<Flight>> crewMap) {
        this.role = role;
        this.crewMap = crewMap;
    }

    public Crew(String id, String name, Date birthday, String role, Map<String, List<Flight>> crewMap) {
        super(id, name, birthday);
        this.role = role;
        this.crewMap = crewMap;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<String, List<Flight>> getCrewMap() {
        return crewMap;
    }

    public void setCrewMap(Map<String, List<Flight>> crewMap) {
        this.crewMap = crewMap;
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-25s|%-12s|%-12s|%-9s|", 
                                    getId(), getName(), getBirthday(), role, crewMap);
    }
}
