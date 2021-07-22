package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute
    public Customer initCustomer(){
        return new Customer();
    }
    @GetMapping
    public ModelAndView listCustomer(){
        ModelAndView modelAndView=new ModelAndView("/customer/list");
        Iterable<Customer> customers= customerService.findAll();
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }


    @GetMapping("create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("customer",customer);
        modelAndView.addObject("message","New customer is created successfully!");
        return modelAndView;
    }



}
