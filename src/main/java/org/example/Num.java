package org.example;


public abstract class Num {
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public abstract int getNumSystem();


    protected int toDec(String numSt, String regex){
        if (!numSt.matches(regex) || numSt.matches("[ ,;:]")) {
            throw new IllegalArgumentException("Не подходит под формат данной системы счисления");
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
        return switch (getNumSystem()) {
            case (2) -> Integer.toBinaryString(number);
            case (8) -> Integer.toOctalString(number);
            case (10) -> Integer.toString(number);
            case (16) -> Integer.toHexString(number);
            default -> throw new IllegalArgumentException("Данная система счисления не поддерживается!");
        };
    }
}
