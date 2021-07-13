package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showForm(){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam float firstOperand, @RequestParam float secondOperand, @RequestParam String operator, Model model){
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("operator",operator);
        float result= calculateByCase(firstOperand, secondOperand, operator);
        model.addAttribute("result",result);
        return "result";
    }

    public static float calculateByCase(float firstOperand, float secondOperand, String operator){
        switch (operator){
            case "add":
                return firstOperand+secondOperand;
            case "sub":
                return firstOperand-secondOperand;
            case "mul":
                return firstOperand*secondOperand;
            case "divide":
                if(secondOperand!=0) {
                    return firstOperand / secondOperand;
                } else throw new RuntimeException("Cant not divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

}
