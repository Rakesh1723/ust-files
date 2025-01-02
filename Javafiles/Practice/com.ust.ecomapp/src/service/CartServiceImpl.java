package service;

import exceptions.ProductNotFoundException;
import model.Clothing;
import model.Electronics;
import model.Product;
import repository.CartRepository;
import repository.CartRepositoryImpl;

public class CartServiceImpl implements CartService{

    private CartRepository cartRepo = new CartRepositoryImpl();

    public void addToCart(Product product) {
        cartRepo.addProduct(product);
    }

    public Product[] getCartItems() {
        return cartRepo.getAllProducts();
    }

    public double calculateTotalPrice() {
        Product[] products=cartRepo.getAllProducts();
        double total=0;
        for(Product p:products)
        {   if(p==null)
              break;
            total+=p.getPrice();
        }
        return total;
    }

    public void applyDiscounts() {
        Product[] products=cartRepo.getAllProducts();
        for(Product p:products)
        {   if(p==null)
               break;
            if(p instanceof Electronics)
           {  double price=p.getPrice();
               price=price-price*0.10;
               p.setPrice(price);
           }
           else if(p instanceof Clothing)
          {  double price=p.getPrice();
            price=price-price*0.20;
            p.setPrice(price);
          }
        }
    }
    public Product getProductById(int id) throws ProductNotFoundException {
            return cartRepo.findProduct(id);
        }

}
