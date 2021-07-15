package phuonganh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import phuonganh.model.Product;
import phuonganh.service.IProductService;
import phuonganh.service.ProductServiceImp;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService=new ProductServiceImp();

    @GetMapping("")
    public String getAll(Model model){
        List<Product> products= productService.findAll();
        model.addAttribute("products",products);
        return "list";
    }

    @GetMapping("/{id}/view")
    public String viewForm(Model model, @PathVariable int id){
        Product product= productService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }






}
