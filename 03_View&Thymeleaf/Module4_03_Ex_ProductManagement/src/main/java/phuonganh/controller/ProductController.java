package phuonganh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import phuonganh.service.IProductService;
import phuonganh.service.ProductServiceImp;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private final IProductService productService=new ProductServiceImp();




}
