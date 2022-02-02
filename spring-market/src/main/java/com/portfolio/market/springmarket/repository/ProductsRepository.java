package com.portfolio.market.springmarket.repository;

import com.portfolio.market.springmarket.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>{
    

}
