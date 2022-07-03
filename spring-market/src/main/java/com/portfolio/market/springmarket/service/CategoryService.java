package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.exceptions.CategoryNotFound;
import com.portfolio.market.springmarket.exceptions.ExistingCategory;
import com.portfolio.market.springmarket.interfaces.CategoryServiceInterface;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CategoryService implements CategoryServiceInterface {

    public final CategoryRepository categoryRepository;

    /*Retorna uma lista contendo todos os produtos do repositório*/
    @Override
    public List<Category> getCategories(){
        
        return categoryRepository.findAll();
    }



    /*Retorna um produto específico de acordo com o id passado*/
    @Override
    public Category getCategory(Long id) throws CategoryNotFound{
        
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFound("Category not found for this id: " + id));
    }


    /*Adiciona uma nova categoria ao repositório, não é permitido categorias com o mesmo nome*/
    @Override
    public Category addCategory(Category category) throws ExistingCategory{

        List<Category> categories = categoryRepository.findAll().stream()
                .filter(e -> e.getName().equals(category.getName()))
                .collect(Collectors.toList());

        if(categories.size() == 0){
            categoryRepository.save(category);
            return category;

        }else {
            throw new ExistingCategory("This category already exist!");
        }

    }



    /*Deleta uma categoria baseado no id*/
    @Override
    public Category deleteCategory(Long id) throws CategoryNotFound {

        Category delete = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFound("Category not found for this id: " + id));

        categoryRepository.deleteById(id);

        return delete;
        }



    /*Atualiza uma categoria existente baseado no id passado*/
    @Override
    public Category putCategory(Category category, Long id) throws CategoryNotFound{

       Category update = categoryRepository.findById(id)
               .orElseThrow(() -> new CategoryNotFound("Category not found for this id: " + id));

       update.setName(category.getName());

       categoryRepository.save(update);

       return update;
    }


    
}
