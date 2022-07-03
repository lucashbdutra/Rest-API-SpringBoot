package com.portfolio.market.springmarket.ServiceTest;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.exceptions.CategoryNotFound;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import com.portfolio.market.springmarket.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@SpringBootTest
class CategoryServiceTest {

    @InjectMocks //Instancia real da classe que eu estou testando
    private CategoryService service;

    @Mock //Injeções fake onde eu vou simular  resposta
    private CategoryRepository categoryRepository;

    private static final Long ID = 1L;
    private static final String NAME = "test";
    public static final int INDEX = 0;


    private Category category;
    private List<Category> list;
    private Optional<Category> optionalCategory;
    private Product product;


    @BeforeEach
    void setUp() {
        product = new Product(ID,NAME,new BigDecimal("651"), ID, category);
        List<Product> products = List.of(product);
        category = new Category(ID, NAME,  products);
        list = List.of(category);
        optionalCategory = Optional.of(category);
    }

    @Test
    void ShouldReturnAProductWhenAnIdIsPassed() {
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory); //quando o service chamar esse método o mock vai retornar essa resposta fake

        Category response = service.getCategory(ID);

        assertNotNull(response); //Vendo se o valor não está null
        assertEquals(Category.class, response.getClass()); //Testando se está retorna um objeto da classe Category
        assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        assertEquals(NAME, response.getName());
    }

    @Test
    void ShouldThrowACategoryNotFoundExceptionWhenAnEmptyOptionalIsReceived() throws CategoryNotFound{
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(CategoryNotFound.class, () -> service.getCategory(ID));

    }

    @Test
    void ShouldReturnAnListOfCategoriesWhenCalled() {
        when(categoryRepository.findAll()).thenReturn(list);
        List<Category> response = service.getCategories();

        assertNotNull(response); //Vendo se o valor não está null
        assertEquals(1 , response.size()) ;
        assertEquals(Category.class, response.get(INDEX).getClass()); //Verifica se a classe retornada é do tipo "Category"
        assertEquals(ID, response.get(INDEX).getId()); //Testando todos os campos da entity Category
        assertEquals(NAME, response.get(INDEX).getName());
    }

    @Test
    void ShouldAddANewCategoryWhenANameIsPassed(){
        when(categoryRepository.save(any())).thenReturn(category);

        Category response = service.addCategory(category);

        assertNotNull(response); //Vendo se o valor não está null
        assertEquals(category, response);
        assertEquals(Category.class, response.getClass());
        assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        assertEquals(NAME, response.getName());
    }


    @Test
    void ShouldDeleteACategoryWhenAIdArePassed() {
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);
        Mockito.doNothing().when(categoryRepository).deleteById(anyLong()); // dizendo para não fazer nada quando chamar esse método

        Category response = service.deleteCategory(ID);

        assertNotNull(response); //Vendo se o valor não está null
        assertEquals(category, response);
        assertEquals(Category.class, response.getClass());
        assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        assertEquals(NAME, response.getName());

    }

    @Test
    void ShouldThrowACategoryNotFoundExceptionWhenAnEmptyOptionalIsFound() throws CategoryNotFound{
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(CategoryNotFound.class, () -> service.deleteCategory(ID));
    }

    @Test
    void ShouldUpdateAndReturnAProductWhenAIdAndAProductArePassed(){
        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);

        Category response = service.putCategory(category, ID);

        assertNotNull(response); //Vendo se o valor não está null

        assertEquals(category, response);
        assertEquals(Category.class, response.getClass());
        assertEquals(ID, response.getId()); //Testando todos os campos da entity Category
        assertEquals(NAME, response.getName());

    }

    @Test
    void ShouldThrowACategoryNotFoundExceptionWhenNotFindACategory() throws CategoryNotFound{
        when(categoryRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(CategoryNotFound.class, () -> service.putCategory(category, ID));
    }

}