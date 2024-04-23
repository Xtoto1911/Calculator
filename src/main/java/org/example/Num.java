package org.example;

import java.util.Arrays;
import java.util.List;

public abstract class Num {
    private int number;
    protected List<Integer> avalNumSystem = Arrays.asList(2,8,10,16);

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract int getNumSystem();


    protected int toDec(String numSt, String regex){
        if (!numSt.matches(regex) || numSt.matches("[ ,;:]")) {
            throw new RuntimeException("Не подходит под формат данной системы счисления");
        }
        return Integer.parseInt(numSt, getNumSystem());
    }


    public String toStringAllSys(){
        return "Hex: " + Integer.toHexString(number) + "\n" +
                "DEC: " + number + "\n" +
                "OCT: " + Integer.toOctalString(number) + "\n" +
                "BIN: " + Integer.toBinaryString(number) + "\n";
    }

    @Override
    public String toString() {
        switch (getNumSystem()){
            case(2):
                return Integer.toBinaryString(number);
            case(8):
                return Integer.toOctalString(number);
            case(10):
                return Integer.toString(number);
            case(16):
                return Integer.toHexString(number);
        }
        throw new RuntimeException("Данная система счисления не поддерживается!");
    }
}
