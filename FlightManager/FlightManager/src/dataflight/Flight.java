package dataflight;

import java.util.Date;

public class Flight {
    private String fightNumber;
    private String departureCity;
    private String despartuneTime;
    private Date arrivalTime;
    private int[] availableSeats = new int[60];

    public Flight(String fightNumber, String departureCity, String despartuneTime, Date arrivalTime) {
        this.fightNumber = fightNumber;
        this.departureCity = departureCity;
        this.despartuneTime = despartuneTime;
        this.arrivalTime = arrivalTime;
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

    public String getDespartuneTime() {
        return despartuneTime;
    }

    public void setDespartuneTime(String despartuneTime) {
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
                                fightNumber, departureCity, despartuneTime, arrivalTime);
    }
}
