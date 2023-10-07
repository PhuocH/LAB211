package datapeople;

import java.util.*;
import dataflight.Flight;

public class Passenger extends People{
    private String phoneNumber;
    private String email;
    public Map<String, List<Flight>> passMap;

    public Passenger() {
        super();
    }

<<<<<<< HEAD
    public Passenger(String id, String name, Date birthday, String phoneNumber, String email, Map<String, List<Flight>> passMap) {
        super(id, name, birthday);
=======
    public Passenger(String id, String name, Date birthday, String country, String phoneNumber, String email, Map<String, List<Flight>> passMap) {
        super(id, name, birthday, country);
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.passMap = passMap;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, List<Flight>> getPassMap() {
        return passMap;
    }

    public void setPassMap(Map<String, List<Flight>> passMap) {
        this.passMap = passMap;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return String.format("|%-5s|%-25s|%-12s|%-12s|%-25s|%-9s|", 
                id, name, birthday, phoneNumber, email, passMap);
=======
        return String.format("|%-5s|%-25s|%-12s|%-20s|%-12s|%-25s|%-9s|", 
                getId(), getName(), getBirthday(), getCountry(), phoneNumber, email, passMap);
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
    }
}
