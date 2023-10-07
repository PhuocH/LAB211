package managewarehouse;

import java.util.*;
import util.ValidationProduct;

public class WareHouse {

    private String id;
    private Date date;
    public Map<String, Integer> wareList;

    public WareHouse() {
        this.id = "";
    }

    public WareHouse(String id, Date date, Map<String, Integer> wareList) {
        this.id = id;
        this.date = date;
        this.wareList = wareList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Integer> getWareList() {
        return wareList;
    }

    public void setWareList(Map<String, Integer> wareList) {
        this.wareList = wareList;
    }

//    public double getTotalPrice() {
//        return totalPrice;
//    }

//    public void setTotalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }
    
//    public double totalPrice() {
//        return getQuantity() * getUnitPrice();
//    }
//
//    private double totalPrice = totalPrice();
//
//    public void totalPrice(double totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    @Override
    public String toString() {
        String dateStr = ValidationProduct.dF.format(date);
        return String.format("|%-8s|%-15s|%-10s|\n",
                id, dateStr, wareList);
    }
}
