package com.portfolio.market.springmarket.service;

import java.util.List;
import java.util.Optional;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        
        return categoryRepository.findAll();
    }



    public Category getCategory(Long id){
        
        return categoryRepository.findById(id).get();
    }



    public Category addCategory(Category category){
        
        categoryRepository.save(category);
        
        return category;

    }



    public Category deleteCategory(Long id){

        Category deleted = categoryRepository.findById(id).get();
        categoryRepository.deleteById(id);

        return deleted;
    }



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
