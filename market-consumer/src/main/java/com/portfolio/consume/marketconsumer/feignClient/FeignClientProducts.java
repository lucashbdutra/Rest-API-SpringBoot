package com.portfolio.consume.marketconsumer.feignClient;

import com.portfolio.consume.marketconsumer.entities.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "Products", url = "http://localhost:8080/products")
public interface FeignClientProducts {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Product> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Product getById(@PathVariable Long id);
}
