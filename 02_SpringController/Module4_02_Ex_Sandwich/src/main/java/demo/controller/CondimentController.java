package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment ){

    }
}
