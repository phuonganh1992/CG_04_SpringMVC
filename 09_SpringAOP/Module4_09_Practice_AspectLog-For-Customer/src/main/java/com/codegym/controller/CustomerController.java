package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.province.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("customer")
    public Customer initCustomer(){
        return new Customer();
    }
    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/customers")
    public ModelAndView listCustomer(@PageableDefault(value = 5) Pageable pageable, @RequestParam("search") Optional<String> search){
        Page<Customer> customers;
        if(search.isPresent()){
            customers=customerService.findAllByFirstNameContaining(search.get(), pageable);
        } else {
            customers=customerService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }


    @GetMapping("/create-customer")
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

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        try {
            Optional<Customer> customer = customerService.findById(id);
            ModelAndView modelAndView=new ModelAndView("/customer/edit");
            modelAndView.addObject("customer",customer.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }

    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        ModelAndView modelAndView=new ModelAndView("/customer/edit");
        customerService.save(customer);
        modelAndView.addObject("message","Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        try {
            Optional<Customer> customer = customerService.findById(id);
            ModelAndView modelAndView=new ModelAndView("/customer/delete");
            modelAndView.addObject("customer",customer.get());
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("redirect:/customers");
        }
    }

    @PostMapping("/delete-customer")
    public String delete(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
