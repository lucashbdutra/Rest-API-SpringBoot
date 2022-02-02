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
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    private static final Long ID = 1L;

    @InjectMocks //Instancia real da classe que eu estou testando
    private CategoryService service;

    @Mock //Injeções fake onde eu vou simular  resposta
    private CategoryRepository categoryRepository;


    private Category category;
    private List<Category> list;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCategory();
    }

    @Test
    void getCategories() {
    }

    @Test
    void getCategory_ShouldReturnAProduct_WhenAnIdIsPassed() {
        Mockito.when(categoryRepository.findById(Mockito.anyLong()).get()).thenReturn(category); //quando o service chamar esse método o mock vai retornar essa resposta fake
        Category response = service.getCategory(ID);

        Assertions.assertEquals(Category.class, response.getClass());
    }

    @Test
    void addCategory() {
    }

    @Test
    void deleteCategory() {
    }

    @Test
    void putCategory() {
    }

    private void startCategory(){
        category = new Category("test");
        category.setId(ID);
        list = Arrays.asList(category);

    }
}