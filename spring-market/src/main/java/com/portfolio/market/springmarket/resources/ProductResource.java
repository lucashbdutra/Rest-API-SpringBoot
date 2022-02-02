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
@RequestMapping("/products")
public class ProductResource {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        
        return ResponseEntity.ok().body(productService.getProducts());
        
    }



    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(productService.getProduct(id));
    }



    @PostMapping("/add/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){

        return ResponseEntity.ok().body(productService.addProduct(product));
    }     



    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable Long id){
           
        return ResponseEntity.ok().body(productService.deleteProduct(id));
   
    }



    @PutMapping("/add/product/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id){
        
        return ResponseEntity.ok().body(productService.putProduct(product, id));
    }
    
}
