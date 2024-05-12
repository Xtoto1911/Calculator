package org.example;

public class HexNum extends Num{
    public HexNum(String value){
        int res = toDec(value,"^(-[1-9A-Fa-f][0-9A-Fa-f]*|0|[1-9A-Fa-f][0-9A-Fa-f]*)$");
        setNumber(res);
    }

    @Override
    public int getNumSystem() {
        return 16;
    }
}
