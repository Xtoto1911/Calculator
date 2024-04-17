package org.example;

public class HexNum extends Num{
    public HexNum(String value) throws Exception {
        int res = toDec(value,"[-]?[0-9A-Fa-f]+");
        setNumber(res);
    }

    @Override
    public int getNumSystem() {
        return 16;
    }
}
