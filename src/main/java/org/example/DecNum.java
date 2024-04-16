package org.example;

public class DecNum extends Num{
    public DecNum(String value) throws Exception {
        setNumber(toDec(value,"^-?\\d+$"));
    }

    @Override
    public int getNumSystem() {
        return 10;
    }
}
