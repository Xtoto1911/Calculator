package org.example;

public class DecNum extends Num{
    public DecNum(String value){
        setNumber(toDec(value,"^-?(0|[1-9]\\d*)$"));
    }

    @Override
    public int getNumSystem() {
        return 10;
    }
}
