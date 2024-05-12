package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CalculatorProgrammer extends Calculator {

    private final Scanner scanner;
    private final List<String> startMenu = Arrays.asList(
            "1.HEX","2.DEC","3.OCT","4.BIN","5.Закрыть"
    );
    private static final String FIRSTNUMBER = "Введите первое число: ";
    private static final String MESSECONDNUM = "Введите второе число: ";
    private static final String MESOPERNUM = "Введите операцию: ";

    public CalculatorProgrammer() throws Exception {
        super();
        scanner = new Scanner(System.in);
    }

    public void performCalculation(Class<? extends Num> numClass){
        try {
            System.out.print(FIRSTNUMBER);
            scanner.nextLine();
            Constructor<? extends Num> constructor = numClass.getConstructor(String.class);
            Num a = constructor.newInstance(scanner.nextLine());
            setA(a);
            System.out.println();
            System.out.print(MESOPERNUM);
            setOperation(scanner.nextLine());
            System.out.println();
            System.out.print(MESSECONDNUM);
            Num b = numClass.getConstructor(String.class).newInstance(scanner.nextLine());
            setB(b);
            System.out.println();
            Num res = solution();
            System.out.println(super.toString());
            System.out.println(res.toStringAllSys());
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IllegalArgumentException) {
                System.out.println(cause.getMessage());
            } else {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
    public void start(){
        boolean flag = true;
        while(flag){
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
        }
    }
}
