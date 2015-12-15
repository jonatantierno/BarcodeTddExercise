package com.tdd.training;

public class PriceFormatter implements PriceConsumer
{
    private final Display display;

    public PriceFormatter(Display display)
    {
        this.display = display;
    }

    @Override
    public void consumePrice(Price price)
    {
        display.show("+ "+price.inEur());
    }
}
