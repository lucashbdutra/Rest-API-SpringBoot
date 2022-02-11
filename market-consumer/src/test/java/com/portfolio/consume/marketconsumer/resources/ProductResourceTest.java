package com.portfolio.consume.marketconsumer.resources;

import com.portfolio.consume.marketconsumer.entities.Product;
import com.portfolio.consume.marketconsumer.feignClient.FeignClientProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class ProductResourceTest {

    private static final Long ID = 1L;
    private static final String NAME = "test";
    private static final BigDecimal PRICE = BigDecimal.valueOf(2000.00);
    private static final String IDCATEGORY = "1";
    public static final int INDEX = 0;


    @InjectMocks
    ProductResource productResource;

    @Mock
    FeignClientProducts feignProducts;

    private Product product;
    private List<Product> list;

    @BeforeEach
    void setUp(){

        product = new Product(NAME, PRICE, IDCATEGORY);
        product.setId(ID);
        list = List.of(product);

    }

    @Test
    void findAll_ShouldReturnAListOfProducts_WhenCalled() {

        when(feignProducts.getAll()).thenReturn(list);

        List<Product> response = productResource.findAll();

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(1 , response.size()) ;
        Assertions.assertEquals(Product.class, response.get(INDEX).getClass()); //Verifica se a classe retornada é do tipo "Category"
        Assertions.assertEquals(ID, response.get(INDEX).getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.get(INDEX).getName());


    }

    @Test
    void findById_ShouldReturnAProduct_WhenAnIdIsPassed() {

        when(feignProducts.getById(Mockito.anyLong())).thenReturn(product);

        Product response = productResource.findById(ID);

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(Product.class, response.getClass()); //Testando se está retorna um objeto da classe Category
        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.getName());
    }
}