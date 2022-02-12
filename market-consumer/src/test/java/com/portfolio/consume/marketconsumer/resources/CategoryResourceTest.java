package com.portfolio.consume.marketconsumer.resources;

import com.portfolio.consume.marketconsumer.entities.Category;
import com.portfolio.consume.marketconsumer.feignClient.FeignClientCategories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CategoryResourceTest {

    private static final Long ID = 1L;
    private static final String NAME = "test";
    public static final int INDEX = 0;


    @InjectMocks
    CategoryResource categoryResource;

    @Mock
    FeignClientCategories feignCategories;

    private Category category;
    private List<Category> list;

    @BeforeEach
    void setUp(){

        category = new Category(NAME);
        category.setId(ID);
        list = List.of(category);

    }

    @Test
    void findAll_ShouldReturnAListOfCategories_WhenCalled() {

        when(feignCategories.getAll()).thenReturn(list);

        List<Category> response = categoryResource.findAll();

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(1 , response.size()) ;
        Assertions.assertEquals(Category.class, response.get(INDEX).getClass()); //Verifica se a classe retornada é do tipo "Category"
        Assertions.assertEquals(ID, response.get(INDEX).getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.get(INDEX).getName());


    }

    @Test
    void findById_ShouldReturnAProduct_WhenAnIdIsPassed() {

        when(feignCategories.getById(Mockito.anyLong())).thenReturn(category);

        Category response = categoryResource.findById(ID);

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(Category.class, response.getClass()); //Testando se está retorna um objeto da classe Category
        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.getName());
    }

    @Test
    void addCategory_ShouldAddANewCategory_WhenANameIsPassed(){
        when(feignCategories.addCategory(any())).thenReturn(category);

        Category response = categoryResource.addCategory(category);

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(category, response);
        Assertions.assertEquals(Category.class, response.getClass());
        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.getName());
    }

    @Test
    void deleteCategory_ShouldDeleteAndReturnACategory_WhenAnIdIsPassed() {
        when(feignCategories.deleteById(Mockito.anyLong())).thenReturn(category);

        Category response = categoryResource.deleteById(ID);

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(category, response);
        Assertions.assertEquals(Category.class, response.getClass());
        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.getName());

    }

    @Test
    void update_ShouldUpdateAndReturnACategory_WhenANameIsPassed() {
        when(feignCategories.update(any(), Mockito.anyLong())).thenReturn(category);

        Object response = categoryResource.update(category, ID);

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(category, response);
        Assertions.assertEquals(Category.class, response.getClass());
    }
}
