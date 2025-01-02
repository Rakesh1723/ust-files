package ecommerce;

public class Test {
    public static void main(String[] args) {

        Electronics e1=new Electronics("watch",1,1000,4,"casio",1);
        Clothing c1=new Clothing("shirt",102,2000,2,30,"cotton");
        ShoppingCart sc=new ShoppingCart();
        sc.addProducts(e1);
        sc.addProducts(c1);
        sc.displayCart();
        sc.totalPrice();

    }
}
