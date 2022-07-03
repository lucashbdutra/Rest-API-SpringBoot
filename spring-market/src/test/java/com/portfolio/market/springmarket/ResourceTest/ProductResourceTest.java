package com.portfolio.market.springmarket.ResourceTest;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.resources.ProductResource;
import com.portfolio.market.springmarket.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductResourceTest {

    @InjectMocks
    ProductResource resource;

    @Mock
    ProductService service;

    private static final Long ID = 1L;
    private static final String NAME = "test";
    private static final BigDecimal PRICE = new BigDecimal(15);
    private static final Long IDCATEGORY = 1L;
    private static final Category CATEGORY = new Category();
    private static final int INDEX = 0;

    private Product product;
    private List<Product> list;

    @BeforeEach
    void setUp(){
        product = new Product(ID,NAME,PRICE,IDCATEGORY,CATEGORY);
        list = List.of(product);
    }

    @Test
    void shouldReturnAProductWhenAIDArePassed(){
        when(service.getProduct(anyLong())).thenReturn(product);

        ResponseEntity<Product> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Product.class, response.getBody().getClass());
        assertEquals(response.getBody(), product);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(PRICE, response.getBody().getPrice());
        assertEquals(IDCATEGORY, response.getBody().getIdCategory());
        assertEquals(CATEGORY, response.getBody().getCategory());

    }

    @Test
    void shouldReturnAListWhenCalled(){
        when(service.getProducts()).thenReturn(list);

        ResponseEntity<List<Product>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Product.class, response.getBody().get(INDEX).getClass());
        assertEquals(response.getBody(), list);
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
        assertEquals(PRICE, response.getBody().get(INDEX).getPrice());
        assertEquals(IDCATEGORY, response.getBody().get(INDEX).getIdCategory());
        assertEquals(CATEGORY, response.getBody().get(INDEX).getCategory());
    }

    @Test
    void ShouldSaveAndReturnAProductWhenAProductArePassed(){
        when(service.addProduct(any(Product.class))).thenReturn(product);

        ResponseEntity<Product> response = resource.addProduct(product);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Product.class, response.getBody().getClass());
        assertEquals(response.getBody(), product);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(PRICE, response.getBody().getPrice());
        assertEquals(IDCATEGORY, response.getBody().getIdCategory());
        assertEquals(CATEGORY, response.getBody().getCategory());
    }

    @Test
    void ShouldDeleteAndReturnAProductWhenAIdArePassed(){
        when(service.deleteProduct(anyLong())).thenReturn(product);

        ResponseEntity<Product> response = resource.deleteById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Product.class, response.getBody().getClass());
        assertEquals(response.getBody(), product);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(PRICE, response.getBody().getPrice());
        assertEquals(IDCATEGORY, response.getBody().getIdCategory());
        assertEquals(CATEGORY, response.getBody().getCategory());
    }

    @Test
    void ShouldUpdateAndReturnAProductWhenAIdAndAProductArePassed(){
        when(service.putProduct(any(Product.class), anyLong())).thenReturn(product);

        ResponseEntity<Product> response = resource.update(product, ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Product.class, response.getBody().getClass());
        assertEquals(response.getBody(), product);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
        assertEquals(PRICE, response.getBody().getPrice());
        assertEquals(IDCATEGORY, response.getBody().getIdCategory());
        assertEquals(CATEGORY, response.getBody().getCategory());
    }





}

