package com.portfolio.market.springmarket.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Product implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private BigDecimal price;

    @NotBlank
    @Column(nullable = false)
    private Long idCategory;

    @ManyToOne //O relacionamento com a outra entity
    @JoinColumn(name = "category", nullable = false) //o nome da foreign key que o atributo "category" vai representar na tabela Product
    private Category category;


    

}
