package org.example;

public class Calculator {
    public String add(int a, int b){
        return String.valueOf(a+b);
    }

    public String sub(int a, int b){
        return String.valueOf(a-b);
    }

    public String mul(int a, int b){
        return String.valueOf(a*b);
    }

    public String div(int a, int b){
        if (b == 0){
            return "Cannot divide by zero";
        }

        return String.valueOf(a / b);
    }
}
