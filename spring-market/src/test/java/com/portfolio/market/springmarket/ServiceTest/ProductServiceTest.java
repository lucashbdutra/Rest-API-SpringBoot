package com.portfolio.market.springmarket.ServiceTest;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.exceptions.CategoryNotFound;
import com.portfolio.market.springmarket.exceptions.ProductNotFound;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import com.portfolio.market.springmarket.repository.ProductsRepository;
import com.portfolio.market.springmarket.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceTest {

    @InjectMocks
    ProductService service;

    @Mock
    ProductsRepository productsRepository;

    @Mock
    CategoryRepository categoryRepository;

    private static final Long ID = 1L;
    private static final String NAME = "test";
    private static final BigDecimal PRICE = new BigDecimal(15);
    private static final Long IDCATEGORY = 1L;
    private static final Category CATEGORY = new Category();
    private static final int INDEX = 0;

    private Product product;
    private List<Product> list;
    private Optional<Product> optionalProduct;
    private Optional<Category> optionalCategory;

    @BeforeEach
    void setUp(){
        product = new Product(ID, NAME, PRICE, IDCATEGORY, CATEGORY);
        list = List.of(product);
        optionalProduct = Optional.of(product);
        optionalCategory = Optional.of(CATEGORY);

    }

    @Test
    void shouldReturnAListWhenCalled(){
        when(productsRepository.findAll()).thenReturn(list);

        List<Product> response = service.getProducts();

        assertNotNull(response);
        assertEquals(Product.class, response.get(INDEX).getClass());
        assertEquals(response, list);
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(PRICE, response.get(INDEX).getPrice());
        assertEquals(IDCATEGORY, response.get(INDEX).getIdCategory());
        assertEquals(CATEGORY, response.get(INDEX).getCategory());
    }

    @Test
    void shouldReturnAProductWhenAIDArePassed(){
        when(productsRepository.findById(anyLong())).thenReturn(optionalProduct);

        Product response = service.getProduct(ID);

        assertNotNull(response);
        assertEquals(Product.class, response.getClass());
        assertEquals(response, product);
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(PRICE, response.getPrice());
        assertEquals(IDCATEGORY, response.getIdCategory());
        assertEquals(CATEGORY, response.getCategory());
    }

    @Test
    void ShouldThrowAProductNotFoundExceptionWhenAnEmptyOptionalIsReceived() throws CategoryNotFound {
        when(productsRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ProductNotFound.class, () -> service.getProduct(ID));

    }

    @Test
    void ShouldSaveAndReturnAProductWhenAProductArePassed(){
        when(productsRepository.findAll()).thenReturn(Collections.emptyList());
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);
        when(productsRepository.save(any(Product.class))).thenReturn(product);

        Product response = service.addProduct(product);

        assertNotNull(response);
        assertEquals(Product.class, response.getClass());
        assertEquals(response, product);
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(PRICE, response.getPrice());
        assertEquals(IDCATEGORY, response.getIdCategory());
        assertEquals(CATEGORY, response.getCategory());
    }

    @Test
    void ShouldThrowACategoryNotFoundExceptionWhenAnEmptyOptionalIsReceived() throws CategoryNotFound{
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(CategoryNotFound.class, () -> service.addProduct(product));

    }

    @Test
    void ShouldDeleteAndReturnAProductWhenAIdArePassed(){
        when(productsRepository.findById(anyLong())).thenReturn(optionalProduct);
        doNothing().when(productsRepository).deleteById(anyLong());

        Product response = service.deleteProduct(ID);

        assertNotNull(response);
        assertEquals(Product.class, response.getClass());
        assertEquals(response, product);
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(PRICE, response.getPrice());
        assertEquals(IDCATEGORY, response.getIdCategory());
        assertEquals(CATEGORY, response.getCategory());
    }

    @Test
    void ShouldThrowAProductNotFoundExceptionWhenAnEmptyOptionalIsFound() throws CategoryNotFound{
        when(productsRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ProductNotFound.class, () -> service.deleteProduct(ID));
    }

    @Test
    void ShouldUpdateAndReturnAProductWhenAIdAndAProductArePassed(){
        when(productsRepository.findById(anyLong())).thenReturn(optionalProduct);
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);
        when(productsRepository.save(any(Product.class))).thenReturn(product);

        Product response = service.putProduct(product,ID);

        assertNotNull(response);
        assertEquals(Product.class, response.getClass());
        assertEquals(response, product);
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(PRICE, response.getPrice());
        assertEquals(IDCATEGORY, response.getIdCategory());
        assertEquals(CATEGORY, response.getCategory());

    }

    @Test
    void ShouldThrowACategoryNotFoundExceptionWhenNotFindAProduct() throws CategoryNotFound{
        when(productsRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ProductNotFound.class, () -> service.putProduct(product, ID));

    }
}