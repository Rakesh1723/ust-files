package ecomapp.repository;

import ecomapp.exception.ProductNotFoundException;
import ecomapp.model.Clothing;
import ecomapp.model.Electronics;
import ecomapp.model.Product;
import ecomapp.model.Size;
import ecomapp.service.CartService;
import ecomapp.service.CartServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CartRepositoryImplTest {

    @Test
    void testAddProduct(){
        // Given

        Product product = new Clothing(10, "T-Shirt", 2000, 10, Size.MEDIUM, "Cotton");
        CartRepositoryImpl cartRepository = new CartRepositoryImpl();
        // When
        cartRepository.addProduct(product);
        // Then
        Assertions.assertDoesNotThrow(()->cartRepository.findProduct(product.getProductId()));
    }

    @Test
    void testFindProduct() throws ProductNotFoundException
    {   Product product = new Clothing(11, "T-Shirt", 3000, 6, Size.MEDIUM, "Cotton");
        Product product1 = new Clothing(10, "T-Shirt", 2000, 10, Size.MEDIUM, "Cotton");
        CartRepositoryImpl cartRepository = new CartRepositoryImpl();
        cartRepository.addProduct(product);
        Assertions.assertEquals(product,cartRepository.findProduct(11));
    }

    @Test
    void testGetAllProducts(){
        Product ep1 = new Electronics(1, "Macbook", 195000, 4, 1, "Apple");
        Product cp1 = new Clothing(11, "Jeans", 4000, 10, Size.LARGE, "Denim");

        CartService cs = new CartServiceImpl();
        cs.addToCart(cp1);
        cs.addToCart(ep1);

        List<Product> al=new ArrayList<>();
        al.add(cp1);
        al.add(ep1);
      //  Assertions.assertIterableEquals();
       Assertions.assertEquals(al.size(),cs.getCartItems().size());

    }




}
