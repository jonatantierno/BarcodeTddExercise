package com.tdd.training;

public class Price
{
    private final long cents;

    public static Price cents(long c)
    {
        return new Price(c);
    }

    private Price(long cents) {
        this.cents = cents;
    }

    public Price sum(Price that) {
        return new Price(this.cents + that.cents);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Price) return cents == ((Price)obj).cents;
        return false;
    }

    @Override
    public int hashCode()
    {
        return (int) cents;
    }

    public String inEur()
    {
        return String.format("EUR %2f",cents/100f);
    }
}
