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

    public void setOperation(String operation) {
        this.operation = operation;
    }

    private void run(){

    }
    public Num solution(){
        try {
            switch (operation) {
                case ("+"):
                    solution = createNum(a.getNumber() + b.getNumber(), a.getNumSystem());
                    break;
                case ("-"):
                    solution.setNumber(a.getNumber() - b.getNumber());
                    break;
                case ("*"):
                    solution.setNumber(a.getNumber() * b.getNumber());
                    break;
                case ("/"):
                    if(b.getNumber() != 0)
                        solution.setNumber(a.getNumber() / b.getNumber());
                    else
                        throw new Exception("На 0 делить нельзя");
                    return solution;
                default:
                    System.out.println("Как оно сюда попало???");
                    break;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return solution;
    }
    private Num createNum(int value, int system) throws Exception {
        switch (system){
            case(10):
                return new DecNum(Integer.toString(value));
            default:
                throw new Exception("Данная система счисления не поддерживается!");
        }
    }
    @Override
    public String toString() {
        return a + " " + operation + " " + b + " = " + solution;
    }
}
