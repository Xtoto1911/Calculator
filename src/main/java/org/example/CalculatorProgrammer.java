package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorProgrammer {
    private final Calculator calc;
    private final Scanner scanner;
    private final List<String> startMenu = Arrays.asList(
            "1.HEX","2.DEC","3.OCT","4.BIN","5.Закрыть"
    );
    private static final String FIRSTNUMBER = "Введите первое число: ";
    private static final String MESSECONDNUM = "Введите второе число: ";
    private static final String MESOPERNUM = "Введите операцию: ";

    public CalculatorProgrammer(){
        scanner = new Scanner(System.in);
        calc = new Calculator();
    }

    public void performCalculation(Class<? extends Num> numClass){
        System.out.print(FIRSTNUMBER);
        scanner.nextLine();
        try {
            Num a = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            calc.setA(a);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        System.out.print(MESOPERNUM);
        calc.setOperation(scanner.nextLine());
        System.out.println();
        System.out.print(MESSECONDNUM);
        try {
            Num b = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            calc.setB(b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println();
        Num res = calc.solution();
        System.out.println(calc);
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
