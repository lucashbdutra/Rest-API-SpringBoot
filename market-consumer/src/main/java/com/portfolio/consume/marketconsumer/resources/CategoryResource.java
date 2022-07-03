package com.portfolio.consume.marketconsumer.resources;

import com.portfolio.consume.marketconsumer.entities.Category;
import com.portfolio.consume.marketconsumer.feignClient.FeignClientCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //controlador rest
@RequestMapping(value = "api/v1/categories") //o caminho base do controller
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


    /*Adciona uma nova categoria ao repository*/
    @PostMapping
    public Category addCategory(@RequestBody Category category){

        return feignClient.addCategory(category);
    }


    /*Deleta uma categoria baseado no id passado*/
    @DeleteMapping("/{id}")
    public Category deleteById(@PathVariable Long id){

        return feignClient.deleteById(id);
    }


    /*Atualiza uma categoria existente com base no id passado*/
    @PutMapping("/{id}")
    public Object update(@RequestBody Category category, @PathVariable Long id){

        return feignClient.update(category, id);
    }

}


