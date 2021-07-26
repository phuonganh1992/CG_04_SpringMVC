package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @ModelAttribute("user")
    public User initUser() {
        return new User();
    }

    @RequestMapping("/login")
    public ModelAndView index(@CookieValue(value = "setUser", defaultValue = "") String setUser) {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        Cookie cookie = new Cookie("setUser", setUser);
        modelAndView.addObject("cookieValue", cookie);
        return modelAndView;
    }

    @PostMapping("doLogin")
    public ModelAndView doLogin(@ModelAttribute("user") User user, @CookieValue(value = "setUser", defaultValue = "") String setUser, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            if (user.getEmail() != null) setUser = user.getEmail();
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            Cookie[] cookies = request.getCookies();
            for (Cookie c : cookies) {
                if (c.getName().equals("setUser")) {
                    modelAndView.addObject("cookieValue", c);
                    break;
                } else {
                    c.setValue("");
                    modelAndView.addObject("cookieValue", c);
                    break;
                }
            }
            modelAndView.addObject("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            modelAndView.addObject("cookieValue", cookie);
            modelAndView.addObject("message", "Login failed. Try again.");
        }
        return modelAndView;
    }

}
