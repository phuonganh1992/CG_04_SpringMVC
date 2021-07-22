package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ModelAndView listProduct(Pageable pageable){
        ModelAndView modelAndView=new ModelAndView("/product/list");
        Page<Product> products=productService.findAll(pageable);
        modelAndView.addObject("products",products);
        return modelAndView;
    }
}
