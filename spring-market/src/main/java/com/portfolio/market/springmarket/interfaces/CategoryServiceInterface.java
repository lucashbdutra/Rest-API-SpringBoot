package com.portfolio.market.springmarket.interfaces;

import com.portfolio.market.springmarket.entities.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryServiceInterface {

    List<Category> getCategories();
    Category getCategory(Long id);
    Category addCategory(Category category);
    Category deleteCategory(Long id);
    Category putCategory(Category category, Long id);
}
