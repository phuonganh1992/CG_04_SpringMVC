package phuonganh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import phuonganh.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @ModelAttribute("employee")
    public Employee initEmployee(){
        return new Employee();
    }

    @GetMapping("/show")
    public String showForm() {
        return "employee/create";
    }

    @PostMapping("/add")
    public String submit(@ModelAttribute("employee") Employee employee){
        return "employee/info";
    }




}
