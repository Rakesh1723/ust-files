package repository;

import exceptions.ProductNotFoundException;
import model.Product;

public class CartRepositoryImpl implements CartRepository {

    private Product[] products=new Product[10];
    int currentIndex=0;

    public void addProduct(Product product) {
        products[currentIndex]=product;
         currentIndex++;
    }

    public Product findProduct(int id) throws ProductNotFoundException {
        for(Product p:products)
       {  if(p==null){
           break;
       }
       if(p.getProductId()==id){
               return p;
           }
       }
        //return null;
        throw new ProductNotFoundException("Product with ID : "+id+ " not Found");
    }

    public Product[] getAllProducts() {
        return products;
    }

}
