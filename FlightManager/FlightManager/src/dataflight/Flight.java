package dataflight;

import java.util.Date;

public class Flight {
    private String fightNumber;
    private String departureCity;
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
                                fightNumber, departureCity, cityArrives, despartuneTime, arrivalTime);
    }
}
