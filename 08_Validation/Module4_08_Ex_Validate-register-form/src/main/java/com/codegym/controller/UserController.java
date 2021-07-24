package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @ModelAttribute("user")
    public User initUser(){
        return new User();
    }

    @GetMapping("/user")
    public ModelAndView showRegisterForm(){
        ModelAndView modelAndView=new ModelAndView("/user/index");
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        ModelAndView modelAndView;
        if(bindingResult.hasFieldErrors()) {
            modelAndView= new ModelAndView("/user/index");
        }
        else {
            modelAndView=new ModelAndView("/user/result");
            Optional<User> optionalUser=userService.findUserByFirstNameAndLastName(user.getFirstName(), user.getLastName());
            if(optionalUser.isPresent()){
                modelAndView.addObject("message","user existed!");
            } else {
                userService.save(user);
                modelAndView.addObject("message","Congratulations! You registered successfully!");
            }
        }
        return modelAndView;
    }
}
