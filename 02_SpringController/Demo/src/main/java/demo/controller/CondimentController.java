package demo.controller;

import demo.model.Condiment;
import demo.service.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class CondimentController {
    @Autowired
    private CondimentService condimentService;

    @GetMapping("/show")
    public String showList(Model model){
        List<Condiment> condiments= condimentService.findAll();
        model.addAttribute("condiments",condiments);
        return "list";
    }
    @GetMapping()
    public String save(@RequestParam("condiment") String[] condiment ){
        return "save";
    }
}
