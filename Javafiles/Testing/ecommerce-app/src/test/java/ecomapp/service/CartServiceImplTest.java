package ecomapp.service;

import ecomapp.exception.ProductNotFoundException;
import ecomapp.model.Clothing;
import ecomapp.model.Product;
import ecomapp.model.Size;
import ecomapp.repository.CartRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

  /* private  CartServiceImpl cs=new CartServiceImpl();

    @Test
    void testAddtoCart()
    {   //Given
        Product product = new Clothing(11, "T-Shirt", 3000, 6, Size.MEDIUM, "Cotton");

        //when
        cs.addToCart(product);

        //then
        Assertions.assertThrows(ProductNotFoundException.class,()->cs.getProductById(12));
    }

     //This is an integration test as this it depends on another layer . if another layer method fails this also fails even though this method is correct. to avoid this  we use mockito then it converted into unit test.

    */

    @Mock   // create object
    CartRepositoryImpl cartRepository;

    @InjectMocks //injecting the object
    CartServiceImpl cartService;

    @Test
    void testAddtoCart() throws ProductNotFoundException
    {   //Given
        Product product = new Clothing(11, "T-Shirt", 3000, 6, Size.MEDIUM, "Cotton");

        //when
        // for void type we use do-nothing and rest we use when-then
        Mockito.doNothing().when(cartRepository).addProduct(product);
        Mockito.when(cartRepository.findProduct(product.getProductId())).thenReturn(product);  // mocking the original call with dummy call.(This is stubbing)

        //then
        cartService.addToCart(product);
        Assertions.assertDoesNotThrow(()->cartService.getProductById(11));

        //Verify
        Mockito.verify(cartRepository,Mockito.times(1)).addProduct(product);
    }

    @Test
    void testGetProductById() throws ProductNotFoundException{

        //Given
        int id=1;
       //  Product p=new Product();
        Product p = new Clothing(11, "T-Shirt", 3000, 6, Size.MEDIUM, "Cotton");

        //when
       Mockito.when(cartRepository.findProduct(id)).thenReturn(p);

        //Then
        Assertions.assertEquals(p,cartService.getProductById(id));
        // Assertions.assertDoesNotThrow(()->cartService.getProductById(id));

        //verify
        Mockito.verify(cartRepository,Mockito.times(1)).findProduct(id);
    }

}
