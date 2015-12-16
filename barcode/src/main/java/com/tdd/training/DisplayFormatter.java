package com.tdd.training;

public class DisplayFormatter implements PriceConsumer, PriceNotFoundFormatter, CheckoutFormatter
{
    private final Display display;

    public DisplayFormatter(Display display)
    {
        this.display = display;
    }

    @Override
    public void consumePrice(Price price)
    {
        display.show("+ "+price.inEur());
    }

    @Override
    public void showNotFound(String barcode)
    {
        display.show(String.format("%s Not found", barcode));
    }

    @Override
    public void checkout(Price price)
    {
        display.show("Total price "+price.inEur());
    }
}
