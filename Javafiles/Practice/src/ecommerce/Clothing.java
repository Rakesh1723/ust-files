package ecommerce;

public class Clothing extends Product{
    private int size;
    private String material;

    public Clothing(String productName, int productId, double price, int quantityInStock, int size, String material) {
        super(productName, productId, price, quantityInStock);
        this.size = size;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Size: "+size+"\nmaterial:"+material);
    }
}
