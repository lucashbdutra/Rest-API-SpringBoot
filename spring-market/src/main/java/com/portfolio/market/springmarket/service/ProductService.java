package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.exceptions.CategoryNotFound;
import com.portfolio.market.springmarket.exceptions.ExistingProduct;
import com.portfolio.market.springmarket.exceptions.ProductNotFound;
import com.portfolio.market.springmarket.interfaces.ProductServiceInterface;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import com.portfolio.market.springmarket.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class  ProductService implements ProductServiceInterface {

    public final ProductsRepository productsRepository;
    public final CategoryRepository categoryRepository; // Injetando o repositório da categoria para linkar os produtos as respectivas categorias


    /*Retorna uma lista com todos os produtos*/
    @Override
    public List<Product> getProducts() {

        return productsRepository.findAll();
    }


    /*Retorna um produto específico de acordo com o Id passado*/
    @Override
    public Product getProduct(Long id) throws ProductNotFound {

        return productsRepository.findById(id).
                orElseThrow(() -> new ProductNotFound("Product not found for this id: " + id));
    }


    /* Adiciona o produto, e linka esse produto a uma categoria, não é permitido produtos com o mesmo nome */
    @Override
    public Product addProduct(Product product) throws CategoryNotFound {

        List<Product> produto = productsRepository.findAll().stream()
                .filter(e -> e.getName().equals(product.getName()))
                .collect(Collectors.toList());

        if(produto.size() == 0){
            Long id = product.getIdCategory();
            product.setCategory(categoryRepository.findById(id)
                    .orElseThrow(() -> new CategoryNotFound("Category not found for this id: " + id))); //setta a category dentro do product
            product.getCategory().setProducts(List.of(product));//add o product a lista de products da catedory
            productsRepository.save(product);
            return product;
        } else {
            throw new ExistingProduct("This product already exist!");
        }

    }


    /*Deleta um produto de acordo com o id*/
    @Override
    public Product deleteProduct(Long id) throws ProductNotFound {

        Product delete = productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found for this id: " + id));

        productsRepository.deleteById(id);

        return delete;
    }


    /* Atualiza um produto de acordo com o id passado */
    @Override
    public Product putProduct(Product product, Long id) throws ProductNotFound, CategoryNotFound{
        Product prod = productsRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("Product not found for this id: " + id));
        Category cate = categoryRepository.findById(prod.getIdCategory())
                .orElseThrow(() -> new CategoryNotFound("Category not found for this id: " + id));

        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        prod.setIdCategory(product.getIdCategory());
        prod.setCategory(cate);

        productsRepository.save(prod);

        return prod;
    }

}
