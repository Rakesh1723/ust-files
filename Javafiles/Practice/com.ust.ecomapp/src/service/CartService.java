package service;

import exceptions.ProductNotFoundException;
import model.Product;

public interface CartService {

   public void addToCart(Product product);

   public Product[] getCartItems();

   public double  calculateTotalPrice();

   public void applyDiscounts();

   public Product getProductById(int id) throws ProductNotFoundException;

}
