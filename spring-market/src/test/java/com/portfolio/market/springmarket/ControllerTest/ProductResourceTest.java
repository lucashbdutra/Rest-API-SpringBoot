package com.portfolio.market.springmarket.ControllerTest;

// import static org.mockito.Mockito.when;

// import java.util.Arrays;
// import java.util.List;
// import java.util.Optional;

// import com.portfolio.market.springmarket.entities.Category;
// import com.portfolio.market.springmarket.entities.Product;
// import com.portfolio.market.springmarket.repository.CategoryRepository;
// import com.portfolio.market.springmarket.repository.ProductsRepository;
// import com.portfolio.market.springmarket.resources.ProductResource;
// import com.portfolio.market.springmarket.service.ProductService;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import io.restassured.http.ContentType;
// import io.restassured.module.mockmvc.RestAssuredMockMvc;

// @SpringBootTest
public class ProductResourceTest {
    
//     @Autowired
//     public ProductResource productResource;
//     @Autowired
//     private MockMvc mockMvc;
    
//     @MockBean
//     public ProductsRepository productRepository;
//     @MockBean
//     public CategoryRepository categoryRepository;    
//     @MockBean
//     public ProductService productService;

//     @BeforeEach
//     public void setUp(){
//         RestAssuredMockMvc.standaloneSetup(this.productResource); //* O standalone eu especifico exatamente o que é pra utilizar
//         Product pro1 = new Product("Joao",null,"1");
//         Product pro2 = new Product("pedor",null,"1");
//         Category c = new Category("jorge");
//         categoryRepository.save(c);
//         productResource.addProduct(pro1);
//         productResource.addProduct(pro2);
        
//     }

//     @Test
//     public void findAll_ShouldReturnAllProducts_WhenCalled(){
    
//         when(this.productService.getProducts()).thenReturn(productRepository.findAll()); //seria referente ao service usado pra pegar o retorno
        
//         RestAssuredMockMvc.given()//* fornecer informações e dizer qual deve ser o retorno
//             .accept(ContentType.JSON) //Eu falo o tipo de retorno
//         .when()
//             .get("/products") //qual o endpoint e o método, nesse caso get
//         .then()
//             .statusCode(HttpStatus.OK.value());
//     }

    // @Test
    // public void findAll_ShouldReturnAllProducts_WhenCalled(){
        
    //     ResponseEntity<List<Product>> products = productResource.findAll(); 
    //     Product pro1 = new Product("Joao",null,"1");
    //     Product pro2 = new Product("pedor",null,"1");
    //     List<Product> prod = Arrays.asList(pro1,pro2);

    //     Assertions.assertEquals(prod, products);
    // }

    // @Test
    // public void findAll_ShouldReturnAllProducts_WhenCalled() throws Exception{

    //     Product pro1 = new Product("Joao",null,"1");
    //     Product pro2 = new Product("pedor",null,"1");
    //     List<Product> prod = Arrays.asList(pro1,pro2);

    //     mockMvc.perform(MockMvcRequestBuilders.get("/products"))
    //     .andExpect(MockMvcResultMatchers.status().isOk())
    //     .andExpect(MockMvcResultMatchers.content();
    // }
    
}

