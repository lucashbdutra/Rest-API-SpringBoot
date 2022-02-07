package com.portfolio.market.springmarket.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Setter
@Getter
@Entity //Faz dessa class uma tabela no banco de dados
public class Category implements Serializable{

    private static final long serialVersionUID = 1L; //quando a aplicação cai, por estar serializada ela consegue meio que salvar um backup e voltar do mesmo lugar, algo do tipo
    
    @Id //especifica que a primaty key do banco de dados é o id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //o metodo de geração desse id vai ser auto increment
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category") //A realação com a outra entity e o mappedBy indica qual o nome do campo da outra tabela que é referenta a essa
    @JsonIgnore //* ignora esse campo na hora do retorno, pois como uma classe aponta pra outra elas ficam em um looop eterno
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    
    
}
