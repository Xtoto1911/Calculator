package org.example;

import java.io.Console;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            DecNum a = new DecNum("-10");
            Calculator calc = new Calculator(a,"+",a);
            Num res = calc.solution();
            System.out.println(calc.toString());
            System.out.println(res.toStringAllSys());
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }
}