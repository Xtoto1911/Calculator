package org.example;

public class CalculatorBin extends Calculator{

    private String aBin;
    private String bBin;
    private String solutionBin;

    public CalculatorBin(){
        super();
        aBin = "0";
        bBin = "0";
    }
    public CalculatorBin(String a, String operation, String b){
        aBin = a;
        bBin = b;
        this.operation = operation;
    }

    public void setA(String a) {
        aBin = a;
    }

    @Override
    public void setA(double a) {
        aBin = Long.toString(Double.doubleToLongBits(a));
    }

    @Override
    public double getA() {
        return Double.parseDouble(aBin);
    }
    public void setB(String b) {
        bBin = b;
    }

    @Override
    public void setB(double b) {
        bBin = Long.toString(Double.doubleToLongBits(b));
    }

    @Override
    public double getB() {
        return Double.parseDouble(bBin);
    }

    private String toBin(double num){
        int temp = (int)num;
        String binary = "";
        while (temp > 0) {
            int remainder = temp % 2;
            binary = remainder + binary;
            temp /= 2;
        }
        return binary;
    }
    @Override
    public void solution() {
        a = Long.parseLong(aBin, 2);
        b = Long.parseLong(aBin, 2);
        super.solution();
        solutionBin = toBin(solution);
    }
}
