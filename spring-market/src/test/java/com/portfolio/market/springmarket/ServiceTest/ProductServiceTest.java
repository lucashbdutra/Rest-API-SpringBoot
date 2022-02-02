package com.portfolio.market.springmarket.ServiceTest;

import com.portfolio.market.springmarket.repository.ProductsRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private MockMvc mvc;

    @Mock
    private ProductsRepository productRepository;


    @Test
    public void getProducts_ShouldReturnListOfProducts_WhenCalled(){
        
        

    }
    
}
