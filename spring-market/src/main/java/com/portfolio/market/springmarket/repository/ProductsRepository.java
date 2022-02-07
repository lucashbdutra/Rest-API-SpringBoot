package com.portfolio.market.springmarket.repository;

import com.portfolio.market.springmarket.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*A interface do Repositório de categoria que extend do JpaRepository que ja possui vários métodos usando o hibernate pra fazer a persistencia de dados*/
@Repository
public interface ProductsRepository extends JpaRepository<Product, Long>{//Aceita o tipo da classe que vai armazenar e o tipo de Id como parâmetro.
    

}
