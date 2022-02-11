package com.portfolio.consume.marketconsumer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class Category implements Serializable{

    private static final long serialVersionUID = 1L; //quando a aplicação cai, por estar serializada ela consegue meio que salvar um backup e voltar do mesmo lugar, algo do tipo

    private Long id;
    private String name;

    @JsonIgnore //* ignora esse campo na hora do retorno, pois como uma classe aponta pra outra elas ficam em um looop eterno
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

}
