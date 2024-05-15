package org.example;

public class OctNum extends Num{
    public OctNum(String value){
        setNumber(toInt(value,"^[-]?0|[1-7][0-7]*$"));
    }

    @Override
    public int getNumSystem() {
        return 8;
    }
}
