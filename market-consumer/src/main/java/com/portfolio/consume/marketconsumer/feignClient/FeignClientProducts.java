package com.portfolio.consume.marketconsumer.feignClient;

import com.portfolio.consume.marketconsumer.entities.Category;
import com.portfolio.consume.marketconsumer.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "Products", url = "http://localhost:8080/products")
public interface FeignClientProducts {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Product> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Product getById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/add/product")
    Product addProduct(@RequestBody Product product);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Product deleteById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/add/product/{id}")
    Object update(@RequestBody Product product, @PathVariable Long id);

}
