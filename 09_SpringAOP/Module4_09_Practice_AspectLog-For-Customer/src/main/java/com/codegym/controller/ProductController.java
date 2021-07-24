package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("product")
    public Product initProduct(){
        return new Product();
    }

    @GetMapping("/products")
    public ModelAndView listProduct(@PageableDefault(value = 5) Pageable pageable, @RequestParam("search")Optional<String> search){
        Page<Product> products;
        if (search.isPresent()){
            products=productService.findAllByName(search.get(),pageable);
        } else {
            products=productService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }

//    @GetMapping("/product/{id}/view")
//    public ModelAndView viewProduct(@PathVariable Long id){
//        ModelAndView modelAndView=new ModelAndView("/product/view");
//        Optional<Product> productOptional=productService.findById(id);
//        modelAndView.addObject("product",productOptional.get());
//        return modelAndView;
//    }
}
