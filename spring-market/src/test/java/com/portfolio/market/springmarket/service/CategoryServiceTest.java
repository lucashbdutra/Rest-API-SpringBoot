package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class CategoryServiceTest {

    private static final Long ID = 1L;
    private static final String NAME = "test";
    public static final int INDEX = 0;


    @InjectMocks //Instancia real da classe que eu estou testando
    private CategoryService service;

    @Mock //Injeções fake onde eu vou simular  resposta
    private CategoryRepository categoryRepository;


    private Category category;
    private List<Category> list;
    private Optional<Category> optionalCategory;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category.setId(ID);
        category = new Category(NAME);
        list = List.of(category);
        optionalCategory = Optional.of(category);
    }

//    @Test
//    void getCategory_ShouldReturnAProduct_WhenAnIdIsPassed() {
//        Mockito.when(categoryRepository.findById(Mockito.anyLong()).get()).thenReturn(category); //quando o service chamar esse método o mock vai retornar essa resposta fake
//        Category response = service.getCategory(ID);
//
//        Assertions.assertNotNull(response); //Vendo se o valor não está null
//        Assertions.assertEquals(Category.class, response.getClass()); //Testando se está retorna um objeto da classe Category
//        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
//        Assertions.assertEquals(NAME, response.getName());
//    }
//
//    @Test
//    void getCategories_ShouldReturnAnListOfCategories_WhenCalled() {
//        Mockito.when(categoryRepository.findAll()).thenReturn(list);
//        List<Category> response = service.getCategories();
//
//        Assertions.assertNotNull(response); //Vendo se o valor não está null
//        Assertions.assertEquals(1 , response.size()) ;
//        Assertions.assertEquals(Category.class, response.get(INDEX).getClass()); //Verifica se a classe retornada é do tipo "Category"
//        Assertions.assertEquals(ID, response.get(INDEX).getId()); //Testando todos os campos da entity Category
//        Assertions.assertEquals(NAME, response.get(INDEX).getName());
//    }

    @Test
    void addCategory_ShouldAddANewCategory_WhenANameIsPassed(){
        Mockito.when(categoryRepository.save(any())).thenReturn(category);

        Category response = service.addCategory(category);

        Assertions.assertNotNull(response); //Vendo se o valor não está null
        Assertions.assertEquals(category, response);
        Assertions.assertEquals(Category.class, response.getClass());
        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        Assertions.assertEquals(NAME, response.getName());
    }

//    @Test
//    void deleteCategory() {
//        Mockito.when(categoryRepository.findById(Mockito.anyLong())).thenReturn(optionalCategory);
//        Mockito.doNothing().when(categoryRepository).deleteById(Mockito.anyLong()); // dizendo para não fazer nada quando chamar esse método
//
//        Category response = service.deleteCategory(ID);
//
//        Assertions.assertNotNull(response); //Vendo se o valor não está null
//        Assertions.assertEquals(category, response);
//        Assertions.assertEquals(Category.class, response.getClass());
//        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
//        Assertions.assertEquals(NAME, response.getName());
//
//    }
//
//    @Test
//    void putCategory() {
//        Mockito.when(categoryRepository.findById(Mockito.anyLong())).thenReturn(optionalCategory);
//        Mockito.doNothing().when(categoryRepository.save(any()));
//
//        Category response = service.putCategory(category, ID);
//
//        Assertions.assertNotNull(response); //Vendo se o valor não está null
//
//        Assertions.assertEquals(category, response);
//        Assertions.assertEquals(Category.class, response.getClass());
//        Assertions.assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
//        Assertions.assertEquals(NAME, response.getName());
//
//    }

}