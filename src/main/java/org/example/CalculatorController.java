package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    private Calculator calculator;

    public CalculatorController(){
        calculator = new Calculator();
    }

    @GetMapping("/")

    public String hello() {
        return "Welcome to online simple calculator!";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public String calculate(@RequestParam("operation") String operation,
                            @RequestParam("a")int a,
                            @RequestParam("b")int b){

        String result = "";
        switch(operation){
            case "add":
                result = calculator.add(a,b);
                break;
            case "sub":
                result = calculator.sub(a,b);
                break;
            case "mul":
                result = calculator.mul(a,b);
                break;
            case "div":
                result = calculator.div(a,b);
                break;
            default:
                throw new BadArgumentException("Invalid operation: " + operation);
        }

        return result;
    }
}
