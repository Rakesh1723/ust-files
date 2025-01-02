package repository;

import model.Clothing;
import model.Electronics;
import model.Product;
import model.Size;

import java.util.*;

public class ProductRepo {
     public List<Product> product = new ArrayList<Product>() ;
    public ProductRepo()
    { product.add(new Electronics(1,"MackBook",195000,4,1,"Apple"));
      product.add(new Electronics(2,"S24 Ultra",150000,5,2,"Samsung"));
      product.add(new Clothing(10,"T-Shirt",2000,10, Size.X_SMALL,"cotton"));
      product.add(new Clothing(11,"Jeans",4000,10, Size.LARGE,"Denim"));
    }
    public Product getById(int id)
    {
        for(Product i:product)
        {  if(i.getProductId()==id)
          {
             return i;
          }
        }
        return null;
    }
}
