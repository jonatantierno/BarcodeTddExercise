package com.tdd.training;

public class SystemInputEvent
{
    private final String code;
    public SystemInputEvent(String s)
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
        if (obj instanceof SystemInputEvent) {
            return ((SystemInputEvent) obj).getValue().equals(code);
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return code.hashCode();
    }
}
