package org.example;

import java.text.DecimalFormat;

public class Calculator {
    private double a;
    private double b;
    private String operation;

    public Calculator(){
        a = 0;
        b = 0;
        operation = "+";
    }

    public Calculator(double a, double b){
        this.a = a;
        this.b = b;
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

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.setDecimalSeparatorAlwaysShown(false);
        return df.format(a) + " " + operation + " " + df.format(b);
    }
}
