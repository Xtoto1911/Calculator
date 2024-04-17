package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorProgrammer {
    private Calculator calc;
    private Scanner scanner;
    private Num a;
    private Num b;
    private final List<String> startMenu = Arrays.asList(
            "1.HEX","2.DEC","3.OCT","4.BIN","5.Закрыть"
    );
    private final String mesFirstNum = "Введите первое число: ";
    private final String mesSecondNum = "Введите второе число: ";
    private final String mesOperNum = "Введите операцию: ";

    public CalculatorProgrammer() throws Exception {
        scanner = new Scanner(System.in);
        calc = new Calculator();
        a = calc.getA();
        b = calc.getB();
    }

    public void start(){
        boolean flag = true;
        while(flag){
            startMenu.forEach(System.out::println);
            try {
                Num res;
                switch (scanner.next()) {
                    case ("1"):
                        System.out.print(mesFirstNum);
                        calc.setA(new HexNum(scanner.next()));
                        System.out.println();
                        System.out.print(mesOperNum);
                        calc.setOperation(scanner.next());
                        System.out.println();
                        System.out.print(mesSecondNum);
                        calc.setB(new HexNum(scanner.next()));
                        System.out.println();
                        res = calc.solution();
                        System.out.println(calc.toString());
                        System.out.println(res.toStringAllSys());
                        break;
                    case ("2"):
                        System.out.print(mesFirstNum);
                        calc.setA(new DecNum(scanner.next()));
                        System.out.println();
                        System.out.print(mesOperNum);
                        calc.setOperation(scanner.next());
                        System.out.println();
                        System.out.print(mesSecondNum);
                        calc.setB(new DecNum(scanner.next()));
                        System.out.println();
                        res = calc.solution();
                        System.out.println(calc.toString());
                        System.out.println(res.toStringAllSys());
                        break;
                    case ("3"):
                        System.out.print(mesFirstNum);
                        calc.setA(new OctNum(scanner.next()));
                        System.out.println();
                        System.out.print(mesOperNum);
                        calc.setOperation(scanner.next());
                        System.out.println();
                        System.out.print(mesSecondNum);
                        calc.setB(new OctNum(scanner.next()));
                        System.out.println();
                        res = calc.solution();
                        System.out.println(calc.toString());
                        System.out.println(res.toStringAllSys());
                        break;
                    case ("4"):
                        System.out.print(mesFirstNum);
                        calc.setA(new BinNum(scanner.next()));
                        System.out.println();
                        System.out.print(mesOperNum);
                        calc.setOperation(scanner.next());
                        System.out.println();
                        System.out.print(mesSecondNum);
                        calc.setB(new BinNum(scanner.next()));
                        res = calc.solution();
                        System.out.println(calc.toString());
                        System.out.println(res.toStringAllSys());
                        break;
                    case ("5"):
                        flag = false;
                        break;
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
