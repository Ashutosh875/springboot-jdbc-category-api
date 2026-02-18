package com.ashutosh.categoryapi.service;

import com.ashutosh.categoryapi.model.Category;
import com.ashutosh.categoryapi.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public String createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public String deleteCategory(long id) {
        return categoryRepo.delete(id);
    }

    @Override
    public String updateCategory(Category category) {
        return categoryRepo.update(category);
    }

    @Override
    public Category findCategory(long id) {
        return categoryRepo.findById(id);
    }

}
