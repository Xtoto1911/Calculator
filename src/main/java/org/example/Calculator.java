package org.example;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Calculator{
    private Num a;
    private Num b;
    private String operation;

    private Num solution;

    List<String> oper = Arrays.asList("+","-","*","/");

    public Calculator() throws Exception {
        this.a = new DecNum("0");
        this.b = new DecNum("0");
        this.operation = "+";
        solution();
    }

    public Calculator(Num a, String operation, Num b){
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public Num getA() {
        return a;
    }

    public void setA(Num a) {
        this.a = a;
    }

    public Num getB() {
        return b;
    }

    public void setB(Num b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) throws Exception {
        if(oper.contains(operation))
            this.operation = operation;
        else
            throw new Exception("Не можем выполнить такую операцию");
    }

    public Num solution() throws Exception {
        int res;
        switch (operation) {
            case ("+"):
                solution = createNum(a.getNumber() + b.getNumber(), a.getNumSystem());
                return solution;
            case ("-"):
                solution = createNum(a.getNumber() - b.getNumber(), a.getNumSystem());
                return  solution;
            case ("*"):
                solution = createNum(a.getNumber() * b.getNumber(), a.getNumSystem());
                return  solution;
            case ("/"):
                if(b.getNumber() != 0) {
                    solution = createNum(a.getNumber() / b.getNumber(), a.getNumSystem());
                    return solution;
                }
                else
                    throw new Exception("На 0 делить нельзя");
            default:
                System.out.println("Как оно сюда попало???");
                break;
        }
        throw new Exception("Нельзя выполнить!");
    }


    private Num createNum(int value, int system) throws Exception {
        String temp = "";
        switch (system){
            case(2):
                if(value >=0)
                    temp = Integer.toBinaryString(value);
                else {
                    temp = Integer.toBinaryString(value * -1);
                    temp = '-' + temp;
                }
                return new BinNum(temp);
            case(8):
                if(value >=0)
                    temp = Integer.toOctalString(value);
                else {
                    temp = Integer.toOctalString(value * -1);
                    temp = '-' + temp;
                }
                return new OctNum(temp);
            case(10):
                return new DecNum(Integer.toString(value));
            case(16):
                if(value >=0)
                    temp = Integer.toHexString(value);
                else {
                    temp = Integer.toHexString(value * -1);
                    temp = '-' + temp;
                }
                return new HexNum(temp);
            default:
                throw new Exception("Данная система счисления не поддерживается!");
        }
    }
    @Override
    public String toString() {
        return a.toString() + " " + operation + " " + b.toString() + " = " + solution;
    }
}
