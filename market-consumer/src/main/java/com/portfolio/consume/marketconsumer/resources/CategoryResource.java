package com.portfolio.consume.marketconsumer.resources;

import com.portfolio.consume.marketconsumer.entities.Category;
import com.portfolio.consume.marketconsumer.feignClient.FeignClientCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController //controlador rest
@RequestMapping(value = "/categories") //o caminho base do controller
public class CategoryResource {

    public final FeignClientCategories feignClient;

    /*Retorna uma lista com todas as categorias adicionadas*/
    @GetMapping
    public List<Category> findAll(){

        return feignClient.getAll();
    }


    /*Retorna uma úncia categoria de acordo com o id passado*/
    @GetMapping(value = "/{id}")
    public Category findById(@PathVariable Long id){

        return feignClient.getById(id);
    }
//
//
//    /*Adciona uma nova categoria ao repository*/
//    @PostMapping("/add/category")
//    public Category addCategory(@RequestBody Category category){
//
//        return
//    }
//
//
//    /*Deleta uma categoria baseado no id passado*/
//    @DeleteMapping("/{id}")
//    public Category deleteById(@PathVariable Long id){
//
//        return
//    }
//
//
//    /*Atualiza uma categoria existente com base no id passado*/
//    @PutMapping("/add/category/{id}")
//    public ResponseEntity<?> update(@RequestBody Category category, @PathVariable Long id){
//
//        return
//    }
//
}


