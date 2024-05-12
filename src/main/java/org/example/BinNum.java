package org.example;

public class BinNum extends Num{
    public BinNum(String value){
        setNumber(toDec(value,"^[-]?[1][0-1]*|[0-1]$"));
    }

    @Override
    public int getNumSystem() {
        return 2;
    }
}
