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

    public void performCalculation(Class<? extends Num> numClass) throws Exception {
        System.out.print(mesFirstNum);
        try {
            Num a = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            calc.setA(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        System.out.print(mesOperNum);
        calc.setOperation(scanner.nextLine());
        System.out.println();
        System.out.print(mesSecondNum);
        try {
            Num b = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            calc.setB(b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        Num res = calc.solution();
        System.out.println(calc.toString());
        System.out.println(res.toStringAllSys());
    }
    public void start(){
        boolean flag = true;
        while(flag){
            try {
            startMenu.forEach(System.out::println);
                switch (scanner.next()) {
                    case ("1"):
                        performCalculation(HexNum.class);
                        break;
                    case ("2"):
                        performCalculation(DecNum.class);
                        break;
                    case ("3"):
                        performCalculation(OctNum.class);
                        break;
                    case ("4"):
                        performCalculation(BinNum.class);
                        break;
                    case ("5"):
                        flag = false;
                        break;
                    default:
                        System.out.println("Не знаю такую операцию!");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
