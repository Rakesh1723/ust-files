package ecommerce;

import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<Product> cart=new ArrayList<>();

    public void addProducts(Product p)
    {   cart.add(p);
    }

    public void displayCart()
    {  System.out.println(cart);
    }

    public void totalPrice()
    {  double cost=0;
        for(Product pr:cart)
      {   if(pr.getProductId()<100) {
          cost += ( (pr.getPrice()*0.9)* pr.getQuantityInStock());
         }
         else
          cost += ( (pr.getPrice()*0.8) * pr.getQuantityInStock());
      }
        System.out.println(cost);
    }

}
