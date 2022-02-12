package com.portfolio.consume.marketconsumer.resources;

import com.portfolio.consume.marketconsumer.entities.Product;
import com.portfolio.consume.marketconsumer.feignClient.FeignClientProducts;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductResource {

    public final FeignClientProducts feignProducts;

    /*Retorna uma lista de produtos para a requisição*/
    @GetMapping
    public List<Product> findAll(){

        return feignProducts.getAll();

    }


    /*Retorna um único produto de acordo com o id passado*/
    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){

        return feignProducts.getById(id);
    }


    /*Adiciona um novo produto ao repositório*/
    @PostMapping("/add/product")
    public Product addProduct(@RequestBody Product product){

        return feignProducts.addProduct(product);
    }


    /*Deleta um produto de acordo com o id passado*/
    @DeleteMapping("/{id}")
    public Product deleteById(@PathVariable Long id){

        return feignProducts.deleteById(id);

    }


    /*Atualiza um produto ja existente de acordo com o id passado*/
    @PutMapping("/add/product/{id}")
    public Object update(@RequestBody Product product, @PathVariable Long id){

        return feignProducts.update(product, id);
    }
    
}
