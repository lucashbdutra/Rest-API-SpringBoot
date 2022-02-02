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
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    public final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){  

        return ResponseEntity.ok().body(categoryService.getCategories());
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(categoryService.getCategory(id));
    }



    @PostMapping("/add/category")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
    
        return ResponseEntity.ok().body(categoryService.addCategory(category));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Long id){
        
        
        return ResponseEntity.ok().body(categoryService.deleteCategory(id));
    }


    @PutMapping("/add/category/{id}")
    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long id){
        
        return ResponseEntity.ok().body(categoryService.putCategory(category, id));
    }
    //? Tenho que arrumar um teste para categorias com nomes iguais, ja que o id é gerado sozinho pelo BD.
}
    //? Tenho que arrumar um teste para categorias com nomes iguais, ja que o id é gerado sozinho pelo BD.

