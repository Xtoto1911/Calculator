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
    public CalculatorBin(String a, char operation, String b){
        setA(a);
        setB(b);
        this.operation = operation;
    }

    public void setA(String a) {
        if (a.matches("^[01]+$")) {
            aBin = a;
        } else {
            throw new IllegalArgumentException("Введено не бинарное число");
        }
    }

    @Override
    public void setA(int a) {
        aBin = Integer.toBinaryString(a);
    }

    @Override
    public int getA() {
        return Integer.parseInt();
    }

    public void setB(String b) {
        if (b.matches("^[01]+$")) {
            bBin = b;
        } else {
            throw new IllegalArgumentException("Введено не бинарное число");
        }
    }

    @Override
    public void setB(int b) {
        bBin = Integer.toBinaryString(b);
    }

    private String toBin(double num){
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
        a = Long.parseLong(aBin, 2);
        b = Long.parseLong(bBin, 2);
        super.solution();
        solutionBin = toBin(solution);
    }

    @Override
    public String toString() {
        return aBin+" "+operation+" "+bBin+" = "+solutionBin;
    }
}
