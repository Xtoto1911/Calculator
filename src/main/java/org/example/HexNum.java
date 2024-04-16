package org.example;

public class HexNum extends Num{
    public HexNum(String value) throws Exception {
        setNumber(toDec(value,"^[0-9A-Fa-f]+$"));
    }

    @Override
    public int getNumSystem() {
        return 16;
    }
}
