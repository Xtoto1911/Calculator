package org.example;

public class CalculatorOct extends Calculator{
    private String aOct;
    private String bOct;


    public CalculatorOct(){
        super();
        aOct = "0";
        bOct = "0";
    }
    public CalculatorOct(String a, String operation, String b){
        setA(a);
        setB(b);
        this.operation = operation;
    }

    public void setA(String a) {
        if (a.matches("^[01]+$")) {
            aOct = a;
        } else {
            throw new IllegalArgumentException("Введено не бинарное число");
        }
    }

    @Override
    public void setA(double a) {
        aOct = Long.toString(Double.doubleToLongBits(a));
    }

    @Override
    public double getA() {
        return Double.parseDouble(aOct);
    }
    public void setB(String b) {
        bOct = b;
    }

    @Override
    public void setB(double b) {
        bOct = Long.toString(Double.doubleToLongBits(b));
    }

    @Override
    public double getB() {
        return Double.parseDouble(bOct);
    }

    private String toOct(double num){
        StringBuilder binary = new StringBuilder();
        int temp = (int)num;
        if (temp < 0) {
            temp = ~temp + 1;
            binary.append("1");
        } else {
            binary.append("0");
        }
        while (temp != 0) {
            int remainder = temp % 2;
            binary.append(remainder);
            temp /= 2;
        }

        while (binary.length() < 32 && num < 0) {
            binary.insert(0, "1");
        }
        return binary.toString();
    }
    @Override
    public void solution() {
        a = Long.parseLong(aOct, 8);
        b = Long.parseLong(bOct, 8);
        super.solution();
        toOct(solution);
    }

    @Override
    public String toString() {
        return aOct+" "+operation+" "+bOct+" = "+ toOct(solution);
    }
}
