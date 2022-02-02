package com.portfolio.market.springmarket.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import com.portfolio.market.springmarket.repository.ProductsRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

    public final ProductsRepository productsRepository;
    public final CategoryRepository categoryRepository;
    


    public List<Product> getProducts(){
        
        return productsRepository.findAll();
    }



    public Product getProduct(Long id){
        
        return productsRepository.findById(id).get();
    }



    public Product addProduct(Product product){
        Long id = Long.valueOf(product.getIdCategory());
        product.setCategory(categoryRepository.findById(id).get()); //setta a category dentro do product
        product.getCategory().setProducts(Arrays.asList(product));//add o product a lista de products da catedory
        productsRepository.save(product);
        return product;
    }



    public Product deleteProduct(Long id){
        productsRepository.deleteById(id);
        return productsRepository.findById(id).get();
    }



    public Product putProduct(Product product, Long id){
        Optional<Product> prod = productsRepository.findById(id);
        if(prod.isPresent()){
            Product obj = prod.get();
            if(product.getName() != null){
                obj.setName(product.getName());
            }
            if(product.getPrice() != null){
                obj.setPrice(product.getPrice());
            }
            if(product.getIdCategory() != null){
                obj.setIdCategory(product.getIdCategory());
            }
            productsRepository.save(obj);
            return obj;
        }
            return null;       
    }

}
