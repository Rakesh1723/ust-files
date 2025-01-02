package model;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private int quantityInStock;

    public Product() {
    }
    public Product(int productId, String productName, double price, int quantityInStock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public void displayDetails()
    {
        System.out.println("Product Details : ");
        System.out.println("product ID : "+productId);
        System.out.println("product Name : "+productName);
        System.out.println("Product price : "+price);
        System.out.println("quantityInStock : "+quantityInStock);
    }
}
