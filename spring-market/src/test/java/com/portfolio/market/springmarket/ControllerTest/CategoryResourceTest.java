package com.portfolio.market.springmarket.ControllerTest;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import com.portfolio.market.springmarket.resources.CategoryResource;
import com.portfolio.market.springmarket.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryResourceTest {

    private static final Long ID = 1L;
    private static final String NAME = "test";
    public static final int INDEX = 0;

    @InjectMocks
    private CategoryResource resource;

    @Mock
    private CategoryService service;

    @Mock
    private CategoryRepository categoryRepository;

    private Category category;
    private List<Category> list;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        category = new Category(NAME);
        category.setId(ID);
        list = List.of(category);

    }

//    @Test
//    void findById(){
//        when(service.getCategory(anyLong())).thenReturn(category);
//
//        ResponseEntity<Category> response = resource.findById(ID);
//
//        Assertions.assertNotNull(response);
//        Assertions.assertNotNull(response.getBody()); //Verificando se o corpo não é nulo
//        Assertions.assertEquals(ResponseEntity.class, response.getClass()); // Verificando se a classe do meu retorno é um ResponseEntity
//        Assertions.assertEquals(Category.class, response.getBody().getClass()); //Verifiando se a classe do corpo da minha resposta é uma Category
//        Assertions.assertEquals(ID, response.getBody().getId()); //Testando todos os campos da entity Category
//        Assertions.assertEquals(NAME, response.getBody().getName());
//    }

    
}
