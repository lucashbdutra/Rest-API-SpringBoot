package com.portfolio.consume.marketconsumer.feignClient;

import com.portfolio.consume.marketconsumer.entities.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "teste", url = "http://localhost:8080/categories")
public interface FeignClientCategories {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<Category> getAll();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    Category getById(@PathVariable  Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/add/category")
    Category addCategory(@RequestBody Category category);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    Category deleteById(@PathVariable Long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/add/category/{id}")
    Object update(@RequestBody Category category, @PathVariable Long id);

}
