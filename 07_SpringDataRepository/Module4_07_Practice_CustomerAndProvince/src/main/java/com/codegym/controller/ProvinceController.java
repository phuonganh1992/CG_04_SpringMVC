package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping
    public ModelAndView listProvince(){
        ModelAndView modelAndView=new ModelAndView("/customer/list");
        Iterable<Province> provinces= provinceService.findAll();
        modelAndView.addObject("provinces",provinces);
        return modelAndView;
    }


    @GetMapping("create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        return modelAndView;
    }
    @PostMapping("create-customer")
    public ModelAndView saveCustomer(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");


        return modelAndView;
    }
}
