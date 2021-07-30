package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(size = 5)Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("/product/list");
        modelAndView.addObject("products",productService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/product/create");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }

//    @PostMapping("/create")
//    public String create(Product product){
//        productService.save(product);
//        return "redirect:/products";
//    }

    @GetMapping("/api")
    public ResponseEntity<Iterable<Product>> findAllApi() {
        Iterable<Product> products = productService.findAll();
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @PostMapping("/api")
    public ResponseEntity<Product> create(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/api/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id){
        Optional<Product> productOptional=productService.findById(id);
        if(!productOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(productOptional.get(),HttpStatus.OK);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
        Optional<Product> productOptional=productService.findById(id);
        if(!productOptional.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        product.setId(productOptional.get().getId());
        productService.save(product);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


    @DeleteMapping("/api/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.delete(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.NO_CONTENT);
    }


}
