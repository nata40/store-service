package pl.danielsiwulec.model;

public class Product {
    private String firstName;
    private String lastName;
    private String productName;
    private String todayDate;
    private int  idProduct;

    public Product(String firstName, String lastName, String productName, String todayDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productName = productName;
        this.todayDate = todayDate;
    }

    public Product(String firstName, String lastName, String productName, String todayDate, int idProduct) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.productName = productName;
        this.todayDate = todayDate;
        this.idProduct = idProduct;
    }

    public Product(String productName, int idProduct) {
        this.productName = productName;
        this.idProduct = idProduct;
    }

    public int getIdProduct() { return idProduct; }

    public void setIdProduct(int idProduct) { this.idProduct = idProduct; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }
}
