package com.portfolio.market.springmarket.ResourceTest;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.resources.CategoryResource;
import com.portfolio.market.springmarket.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CategoryResourceTest {

    @InjectMocks
    private CategoryResource resource;

    @Mock
    private CategoryService service;


    private static final Long ID = 1L;
    private static final String NAME = "test";
    private static final int INDEX = 0;

    private Category category;
    private List<Category> list;


    @BeforeEach
    void setUp(){

        category = new Category();
        category.setName(NAME);
        category.setId(ID);
        list = List.of(category);

    }

    @Test
    void shouldReturnACategoryWhenAIDArePassed(){
        when(service.getCategory(anyLong())).thenReturn(category);

        ResponseEntity<Category> response = resource.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody()); //Verificando se o corpo não é nulo
        assertEquals(ResponseEntity.class, response.getClass()); // Verificando se a classe do meu retorno é um ResponseEntity
        assertEquals(Category.class, response.getBody().getClass()); //Verifiando se a classe do corpo da minha resposta é uma Category
        assertEquals(response.getBody(), category);
        assertEquals(ID, response.getBody().getId()); //Testando todos os campos da entity Category
        assertEquals(NAME, response.getBody().getName());
    }

    @Test
    void shouldReturnAListWhenCalled(){
        when(service.getCategories()).thenReturn(list);

        ResponseEntity<List<Category>> response = resource.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Category.class, response.getBody().get(INDEX).getClass());
        assertEquals(response.getBody(), list);
        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(NAME, response.getBody().get(INDEX).getName());
    }

    @Test
    void ShouldSaveAndReturnACategoryWhenACategoryArePassed(){
        when(service.addCategory(Mockito.any(Category.class))).thenReturn(category);

        ResponseEntity<Category> response = resource.addCategory(category);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Category.class, response.getBody().getClass());
        assertEquals(response.getBody(), category);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());


    }

    @Test
    void ShouldDeleteAndReturnACategoryWhenAIdArePassed(){
        when(service.deleteCategory(anyLong())).thenReturn(category);

        ResponseEntity<Category> response = resource.deleteById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Category.class, response.getBody().getClass());
        assertEquals(response.getBody(), category);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());


    }

    @Test
    void ShouldUpdateAndReturnACategoryWhenAIdAndACategoryArePassed(){
        when(service.putCategory(Mockito.any(Category.class),anyLong())).thenReturn(category);

        ResponseEntity<Category> response = resource.update(category,ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Category.class, response.getBody().getClass());
        assertEquals(response.getBody(), category);
        assertEquals(ID, response.getBody().getId());
        assertEquals(NAME, response.getBody().getName());
    }

    
}
