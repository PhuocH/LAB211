package dataflight;

import java.util.Date;

public class Flight {
    private String fightNumber;
    private String departureCity;
<<<<<<< HEAD
    private String cityArrives;
    private Date despartuneTime;
    private Date arrivalTime;
    private int[] availableSeats = new int[60];

    public Flight(String fightNumber, String departureCity, String cityArrives, Date despartuneTime, Date arrivalTime) {
        this.fightNumber = fightNumber;
        this.departureCity = departureCity;
        this.cityArrives = cityArrives;
        this.despartuneTime = despartuneTime;
        this.arrivalTime = arrivalTime;
        int[] availableSeats = new int[60];
=======
    private String despartuneTime;
    private Date arrivalTime;
    private int[] availableSeats = new int[60];

    public Flight(String fightNumber, String departureCity, String despartuneTime, Date arrivalTime) {
        this.fightNumber = fightNumber;
        this.departureCity = departureCity;
        this.despartuneTime = despartuneTime;
        this.arrivalTime = arrivalTime;
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
    }

    public String getFightNumber() {
        return fightNumber;
    }

    public void setFightNumber(String fightNumber) {
        this.fightNumber = fightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

<<<<<<< HEAD
    public String getCityArrives() {
        return cityArrives;
    }

    public void setCityArrives(String cityArrives) {
        this.cityArrives = cityArrives;
    }
    
    public Date getDespartuneTime() {
        return despartuneTime;
    }

    public void setDespartuneTime(Date despartuneTime) {
=======
    public String getDespartuneTime() {
        return despartuneTime;
    }

    public void setDespartuneTime(String despartuneTime) {
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
        this.despartuneTime = despartuneTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int[] getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int[] availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return String.format("|%-11s|%-20s|%-20s|%-15s", 
<<<<<<< HEAD
                                fightNumber, departureCity, cityArrives, despartuneTime, arrivalTime);
=======
                                fightNumber, departureCity, despartuneTime, arrivalTime);
>>>>>>> 76195c2914f78230aa234ca9a2a1b9b42d018f98
    }
}
