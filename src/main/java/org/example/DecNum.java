package org.example;

public class DecNum extends Num{
    public DecNum(String value) throws Exception {
        int temp = toDec(value,"^-?\\d+$");
        setNumber(temp);
    }

    @Override
    public int getNumSystem() {
        return 10;
    }

    @Override
    public String toString() {
        return Integer.toString(getNumber());
    }
}
