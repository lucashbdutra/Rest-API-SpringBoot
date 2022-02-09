package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Category getCategory(Long id){
        
        return categoryRepository.findById(id).get();
    }


    /*Adiciona uma nova categoria ao repositório, não é permitido categorias com o mesmo nome*/
    @Override
    public Category addCategory(Category category){

        List<Category> cat = categoryRepository.findAll().stream()
                .filter(e -> e.getName().equals(category.getName()))
                .collect(Collectors.toList());

        if(cat.size() == 0){
            categoryRepository.save(category);
            return category;
        }

        return null;

    }



    /*Deleta uma categoria baseado no id*/
    @Override
    public Category deleteCategory(Long id){

        Optional<Category> delete = categoryRepository.findById(id);

        if(delete.isPresent()){
            Category deleted = delete.get();
            categoryRepository.deleteById(id);
            return deleted;
        }

        return null;
//        Category delete = categoryRepository.findById(id).get();
//        categoryRepository.deleteById(id);
//        return delete;

    }



    /*Atualiza uma categoria existente baseado no id passado*/
    @Override
    public Category putCategory(Category category, Long id){

        Optional<Category> cat = categoryRepository.findById(id);

        if(cat.isPresent()){

            Category obj = cat.get();

            if(category.getName() != null){
                obj.setName(category.getName());
            }

            categoryRepository.save(obj);

            return obj;
        }
        
        return null;       
    }


    
}
