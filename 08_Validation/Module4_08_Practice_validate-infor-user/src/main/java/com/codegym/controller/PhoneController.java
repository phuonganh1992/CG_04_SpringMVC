package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {
    @ModelAttribute("phoneNumber")
    public PhoneNumber initPhoneNumber(){
        return new PhoneNumber();
    }

    @GetMapping("/phone")
    public ModelAndView showForm(){
        ModelAndView modelAndView=new ModelAndView("/phone/index");
        return modelAndView;
    }

    @PostMapping("/validatePhone")
    public ModelAndView modelAndView(@Validated @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult){
        new PhoneNumber().validate(phoneNumber,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/phone/index");
        } else return new ModelAndView("/phone/result");
    }

}
