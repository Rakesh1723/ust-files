package repository;

import exceptions.ProductNotFoundException;
import model.Product;

public interface CartRepository {

    public void addProduct(Product product);
    public Product findProduct(int id) throws ProductNotFoundException;
    public Product[] getAllProducts();

}
