package com.portfolio.consume.marketconsumer.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class Product implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private BigDecimal price;
    private String idCategory;

    private Category category;

    public Product(String name, BigDecimal price, String idCategory) {
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
    }


}
