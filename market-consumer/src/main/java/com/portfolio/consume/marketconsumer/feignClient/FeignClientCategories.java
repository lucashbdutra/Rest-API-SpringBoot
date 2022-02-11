package com.portfolio.consume.marketconsumer.feignClient;

import com.portfolio.consume.marketconsumer.entities.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "teste", url = "http://localhost:8080/categories")
public interface FeignClientCategories {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Category> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Category getById(@PathVariable  Long id);
}
