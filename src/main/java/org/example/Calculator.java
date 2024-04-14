package org.example;
import java.text.DecimalFormat;

public class Calculator{
    protected double a;
    protected double b;
    protected String operation;

    protected double solution;

    public Calculator(){
        this.a = 0;
        this.b = 0;
        this.operation = "+";
    }

    public Calculator(double a, String operation, double b){
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    protected double sum(){
        return a + b;
    }
    protected   double sub(){
        return  a - b;
    }
    protected double multi(){
        return a * b;
    }

    protected double div() throws Exception{
        if(b != 0)
            return a / b;
        throw new Exception("На 0 делить нельзя");
    }


    public void solution(){
        try {
            switch (operation) {
                case ("+"):
                    solution = a + b;
                    break;
                case ("-"):
                    solution = a - b;
                    break;
                case ("*"):
                    solution = a * b;
                    break;
                case ("/"):
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
