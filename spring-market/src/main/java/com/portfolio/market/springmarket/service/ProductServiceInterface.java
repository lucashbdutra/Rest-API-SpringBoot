package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Product;

import java.util.List;

public interface ProductServiceInterface {

    public List<Product> getProducts();
    public Product getProduct(Long id);
    public Product addProduct(Product product);
    public Product deleteProduct(Long id);
    public Product putProduct(Product product, Long id);

}
