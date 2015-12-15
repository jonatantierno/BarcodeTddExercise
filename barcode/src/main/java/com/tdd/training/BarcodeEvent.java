package com.tdd.training;

public class BarcodeEvent
{
    private final String code;
    public BarcodeEvent(String s)
    {
        this.code = s;
    }

    public String getValue()
    {
        return code;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof BarcodeEvent) {
            return ((BarcodeEvent) obj).getValue().equals(code);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return code.hashCode();
    }
}
