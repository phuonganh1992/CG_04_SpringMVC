package demo.controller;

import demo.model.Condiment;
import demo.service.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CondimentController {
    @Autowired
    private CondimentService condimentService;

    @GetMapping("/condiment")
    public String showList(Model model){
        List<Condiment> condiments= condimentService.findAll();
        model.addAttribute("condiments",condiments);
        return "list";
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam("condiment") String[] names){
        ModelAndView modelAndView=new ModelAndView("save");
       modelAndView.addObject("names",names);
        return modelAndView ;
    }
}
