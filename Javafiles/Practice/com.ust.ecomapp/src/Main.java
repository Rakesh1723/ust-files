import exceptions.DuplicateProductException;
import exceptions.InvalidInputException;
import exceptions.ProductNotFoundException;
import model.Clothing;
import model.Electronics;
import model.Product;
import model.Size;
import repository.ProductRepo;
import service.CartService;
import service.CartServiceImpl;
import repository.ProductRepo;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        CartService cartService = new CartServiceImpl();
        ProductRepo pr=new ProductRepo();

        Scanner sc=new Scanner(System.in);
       while(true){
         System.out.println("""
                Welcome to My Shopping App
                Select an Option:
                1 : View All Products
                2 : Add Product to cart
                3 : View Cart
                4 : exit
                """);
        int option=sc.nextInt();
        switch(option) {
            case 1: {
                viewAllProducts(pr);
                break;
            }
            case 2: {
                System.out.println("enter product id ");
                try{
                  int p = sc.nextInt();
                  if(p<0)
                  {   // Unchecked Exception for Product ID should be a positive value.->price should be a positive value.
                      throw new InvalidInputException("Product ID should be a positive value");
                  }
                  else if(!isDuplicate(cartService,p)){
                       // Checked Exception for one who tries to add two products with same id.
                       throw new DuplicateProductException("Duplicate Product is not allowed as product is already added to cart");
                  }
                  Product p1 = pr.getById(p);
                  addProductToCart(cartService,p1);
                }catch(InvalidInputException ex)
                {
                    System.err.println(ex.getMessage());
                }catch(DuplicateProductException ex)
                {
                    System.err.println(ex.getMessage());
                }
                break;
            }
            case 3: {
                viewCart(cartService);
                break;
            }
            case 4:
                 exit(0);
        }
       }


   /*
        Product ep1=new Electronics(1,"MackBook",195000,4,1,"Apple");
        Product ep2=new Electronics(2,"S24 Ultra",150000,5,2,"Samsung");
        Product cp1=new Clothing(10,"T-Shirt",2000,10, Size.X_SMALL,"cotton");
        Product cp2=new Clothing(11,"Jeans",4000,10, Size.LARGE,"Denim");

        cartService.addToCart(cp1);
        cartService.addToCart(ep1);
  

       // checked exception for product with id or name is not present.
        try {
            Product products = cartService.getProductById(100);
            products.displayDetails();
        } catch (ProductNotFoundException ex) {
            System.err.println(ex.getMessage());
        }

        Product []products=cartService.getCartItems();
        System.out.println("product in cart : ");
        for(Product p:products) {
            if(p==null)
                break;
            p.displayDetails();
        }

        double totalPrice=cartService.calculateTotalPrice();
        System.out.println("Total : "+totalPrice);

        cartService.applyDiscounts();

        System.out.println("After Discounts : ");
        products = cartService.getCartItems();
        System.out.println("Products in Cart : ");
        for (Product p:products){
            if (p==null){
                break;
            }
            p.displayDetails();
        }


        double discountedPrice = cartService.calculateTotalPrice();
        System.out.println("After Discounts : "+discountedPrice);
      */
    }

    private static void viewCart(CartService cartService) {
        Product []Products=cartService.getCartItems();
        System.out.println("product in cart : ");
        for(Product p:Products) {
            if(p==null)
                break;
            p.displayDetails();
        }
    }

    private static void addProductToCart(CartService cartService,Product p1) {
        cartService.addToCart(p1);
    }

    public static void viewAllProducts(ProductRepo pr)
    {
        for(Product p:pr.product)
        {
            p.displayDetails();
        }

    }

    public static boolean isDuplicate(CartService cartService,int id){
        Product []Products=cartService.getCartItems();
        System.out.println("product in cart : ");
        for(Product p:Products) {
            if (p == null)
                break;
            if(p.getProductId()==id)
                return false;
        }
        return true;
    }
}