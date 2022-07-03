package com.portfolio.market.springmarket.resources;

import java.util.List;

import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.service.ProductService;

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
@RequestMapping("/api/v1/products")
public class ProductResource {

    private final ProductService productService; //Usa os métodos do service de produtos

    /*Retorna uma lista de produtos para a requisição*/
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        
        return ResponseEntity.ok().body(productService.getProducts()); // ResposeEntity com um status ok (da familia 200) e o corpo do retorno que é a lista
        
    }


    /*Retorna um único produto de acordo com o id passado*/
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(productService.getProduct(id));
    }


    /*Adiciona um novo produto ao repositório*/
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return ResponseEntity.ok().body(productService.addProduct(product));
    }     


    /*Deleta um produto de acordo com o id passado*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
           
        return ResponseEntity.ok().body(productService.deleteProduct(id));
   
    }


    /*Atualiza um produto ja existente de acordo com o id passado*/
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){
        
        return ResponseEntity.ok().body(productService.putProduct(product, id));
    }
    
}
