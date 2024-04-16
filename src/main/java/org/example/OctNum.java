package org.example;

public class OctNum extends Num{
    public OctNum(String value) throws Exception {
        setNumber(toDec(value,"^[0-7]+$"));
    }

    @Override
    public int getNumSystem() {
        return 8;
    }
}
