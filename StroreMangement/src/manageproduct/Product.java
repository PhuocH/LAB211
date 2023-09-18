package manageproduct;

public abstract class Product {
    protected String productID;
    protected String productName;
    protected String type;
    protected int quantity;
    protected double price;

    public Product() {
        this.productID = "";
        this.productName = "";
        this.type = "";       
    }

    public Product(String productID, String productName, String type, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("|%-5s|%-20s|%-5s|%3d|%5.3f|", 
                            productID, productName, type, quantity, price);
    }
}
