package com.ashutosh.categoryapi.controller;

import com.ashutosh.categoryapi.model.Category;
import com.ashutosh.categoryapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories() , HttpStatus.OK );
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findCategory(id) , HttpStatus.OK);
    }

    @PostMapping("/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        String status = categoryService.createCategory(category);
        return new ResponseEntity<>(status , HttpStatus.CREATED);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id){
        String status = categoryService.deleteCategory(id);
        return new ResponseEntity<>(status , HttpStatus.OK);
}

    @PutMapping("/categories/{id}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable long id){
        String status = categoryService.updateCategory(category);
        return new ResponseEntity<>(status , HttpStatus.OK);
    }
}
