package phuonganh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String showCalculator(){
        return "index";
    }

    @PostMapping("/calculator")
    public String calculate(Model model, @RequestParam float firstOperand, float secondOperand, String operator){

        model.addAttribute("firstOperand",firstOperand);
        model.addAttribute("secondOperand",secondOperand);
        model.addAttribute("operator",operator);
        float result=calculateByCase(firstOperand, secondOperand, operator);
        model.addAttribute("result",result);
        return "result";

    }
    public static float calculateByCase(float firstOperand, float secondOperand, String operator){
        switch (operator){
            case "Addition(+)":
                return firstOperand+secondOperand;
            case "Subtraction(-)":
                return firstOperand-secondOperand;
            case "Multiplication(x)":
                return firstOperand*secondOperand;
            case "Division(/)":
                if(secondOperand!=0) {
                    return firstOperand / secondOperand;
                } else throw new RuntimeException("Cant not divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }

}
