package com.example.productmanagement.controller;

import com.example.productmanagement.model.Category;
import com.example.productmanagement.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("/api")
    public ResponseEntity<Iterable<Category>> findAllApi() {
        List<Category> categories = (List<Category>) categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id) {
        Optional<Category> categoryOptional=categoryService.findById(id);
        if(!categoryOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
}
