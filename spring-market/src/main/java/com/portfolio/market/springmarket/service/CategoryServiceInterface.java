package com.portfolio.market.springmarket.service;

import com.portfolio.market.springmarket.entities.Category;

import java.util.List;

public interface CategoryServiceInterface {

    public List<Category> getCategories();
    public Category getCategory(Long id);
    public Category addCategory(Category category);
    public Category deleteCategory(Long id);
    public Category putCategory(Category category, Long id);
}
