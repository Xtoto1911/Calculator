package org.example;

import java.io.Console;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(1.1,"/",2);
        System.out.println(calculator.toString());
        CalculatorBin bin = new CalculatorBin("1010","/","1010");
        bin.solution();
        System.out.println(bin);


    }
}