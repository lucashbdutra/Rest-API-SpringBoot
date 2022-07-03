package com.portfolio.market.springmarket.interfaces;

import com.portfolio.market.springmarket.entities.Product;

import java.util.List;

public interface ProductServiceInterface {

    List<Product> getProducts();
    Product getProduct(Long id);
    Product addProduct(Product product);
    Product deleteProduct(Long id);
    Product putProduct(Product product, Long id);

}
