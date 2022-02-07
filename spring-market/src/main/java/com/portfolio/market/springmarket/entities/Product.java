package com.portfolio.market.springmarket.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Product implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    private String idCategory;

    @ManyToOne //O relacionamento com a outra entity
    @JoinColumn(name = "category") //o nome da foreign key que o atributo "category" vai representar na tabela Product
    private Category category;

    public Product(String name, BigDecimal price, String idCategory) {
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
    }

    

}
