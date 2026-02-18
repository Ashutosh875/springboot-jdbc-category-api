package com.ashutosh.categoryapi.repository;

import com.ashutosh.categoryapi.model.Category;

import java.util.List;

public interface CategoryRepo {

    List<Category> findAll();
    String save(Category category);
    String delete(long id);
    String update(Category category);
    Category findById(long id);
}
