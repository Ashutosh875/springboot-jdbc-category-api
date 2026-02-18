package com.ashutosh.categoryapi.service;

import com.ashutosh.categoryapi.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    String createCategory(Category category);

    String deleteCategory(long id);

    String updateCategory(Category category);

    Category findCategory(long id);
}
