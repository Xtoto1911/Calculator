package org.example;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Calculator{
    protected int a;
    protected int b;
    protected char operation;

    protected int solution;

    List<Character> oper = Arrays.asList('+','-','*','/');

    public Calculator(){
        this.a = 0;
        this.b = 0;
        this.operation = '+';
    }

    public Calculator(int a, char operation, int b){
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public void solution(){
        try {
            switch (operation) {
                case ('+'):
                    solution = a + b;
                    break;
                case ('-'):
                    solution = a - b;
                    break;
                case ('*'):
                    solution = a * b;
                    break;
                case ('/'):
                    if(b != 0)
                        solution = a / b;
                    else
                        throw new Exception("На 0 делить нельзя");
                    break;
                default:
                    System.out.println("Как оно сюда попало???");
                    break;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setDecimalSeparatorAlwaysShown(false);
        return df.format(a) + " " + operation + " " + df.format(b) + " = " + df.format(solution);
    }
}
