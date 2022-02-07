package com.portfolio.market.springmarket.resources;

import java.util.List;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.service.CategoryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController //controlador rest
@RequestMapping(value = "/categories") //o caminho base do controller
public class CategoryResource {

    public final CategoryService categoryService; //Injetando a categoria pelo construtor com lombok

    /*Retorna uma lista com todas as categorias adicionadas*/
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){  

        return ResponseEntity.ok().body(categoryService.getCategories());
    }


    /*Retorna uma úncia categoria de acordo com o id passado*/
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }


    /*Adciona uma nova categoria ao repository*/
    @PostMapping("/add/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
    
        return ResponseEntity.ok().body(categoryService.addCategory(category));
    }


    /*Deleta uma categoria baseado no id passado*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id){

        return ResponseEntity.ok().body(categoryService.deleteCategory(id));
    }


    /*Atualiza uma categoria existente com base no id passado*/
    @PutMapping("/add/category/{id}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long id){
        
        return ResponseEntity.ok().body(categoryService.putCategory(category, id));
    }

}


