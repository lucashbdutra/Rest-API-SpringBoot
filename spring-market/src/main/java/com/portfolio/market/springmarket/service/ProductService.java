package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Category;
import com.portfolio.market.springmarket.entities.Product;
import com.portfolio.market.springmarket.repository.CategoryRepository;
import com.portfolio.market.springmarket.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class  ProductService {

    public final ProductsRepository productsRepository;
    public final CategoryRepository categoryRepository; // Injetando o repositório da categoria para linkar os produtos as respectivas categorias


    /*Retorna uma lista com todos os produtos*/
    public List<Product> getProducts() {

        return productsRepository.findAll();
    }


    /*Retorna um produto específico de acordo com o Id passado*/
    public Product getProduct(Long id) {

        return productsRepository.findById(id).get();
    }


    /* Adiciona o produto, e linka esse produto a uma categoria */
    public Product addProduct(Product product) {

        List<Product> produto = productsRepository.findAll().stream()
                .filter(e -> e.getName().equals(product.getName()))
                .collect(Collectors.toList());

        if(produto.size() == 0){
            Long id = Long.valueOf(product.getIdCategory());
            product.setCategory(categoryRepository.findById(id).get()); //setta a category dentro do product
            product.getCategory().setProducts(Arrays.asList(product));//add o product a lista de products da catedory
            productsRepository.save(product);
            return product;
        }

        return null;
    }


    /*Deleta um produto de acordo com o id*/
    public Product deleteProduct(Long id) {
        Optional<Product> delete = productsRepository.findById(id);

        if(delete.isPresent()){
            Product deleted = delete.get();
            productsRepository.deleteById(id);
            return deleted;
        }

        return null;
    }


    /* Atualiza um produto de acordo com o id passado */
    public Product putProduct(Product product, Long id) {
        Optional<Product> prod = productsRepository.findById(id);
        if (prod.isPresent()) {
            Product obj = prod.get();
            if (product.getName() != null) {
                obj.setName(product.getName());
            }
            if (product.getPrice() != null) {
                obj.setPrice(product.getPrice());
            }
            if (product.getIdCategory() != null) {
                obj.setIdCategory(product.getIdCategory());
            }
            productsRepository.save(obj);
            return obj;
        }
        return null;
    }

}
