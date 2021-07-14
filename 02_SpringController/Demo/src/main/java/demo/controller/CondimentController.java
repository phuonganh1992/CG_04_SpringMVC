package demo.controller;

import demo.model.Condiment;
import demo.service.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class CondimentController {
    @Autowired
    private CondimentService condimentService;

    @GetMapping("/show")
    public String showList(Model model){
        List<Condiment> condiments= condimentService.findAll();
        model.addAttribute("condiments",condiments);
        return "list";
    }
    @GetMapping("/select")
    public ModelAndView save(@RequestParam("condiment") String[] names){
        ModelAndView modelAndView=new ModelAndView("select");
        modelAndView.addObject("names",names);
        return modelAndView;
    }
}
