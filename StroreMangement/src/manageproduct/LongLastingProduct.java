package manageproduct;

import java.util.Date;

public class LongLastingProduct extends Product{
    private Date dateOfManufacture;
    private Date expirationDate;

    public LongLastingProduct() {
        super();
    }

    public LongLastingProduct(String productID, String productName, String type, Date dateOfManufacture, Date expirationDate, int quantity, double price) {
        super(productID, productName, type, quantity, price);
        this.dateOfManufacture = dateOfManufacture;
        this.expirationDate = expirationDate;
    }
    
    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(Date dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        super.toString();
        return String.format("|%-5s|%-20s|%-5s|%10s|%10s|%3d|%5.3f|", 
                            productID, productName, type, dateOfManufacture, expirationDate,quantity, price);
    }    
}
