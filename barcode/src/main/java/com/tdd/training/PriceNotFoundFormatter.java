package com.tdd.training;

public class PriceNotFoundFormatter
{
    private final Display display;

    public PriceNotFoundFormatter(Display display)
    {
        this.display = display;
    }

    public void showNotFound(String barcode)
    {
        display.show(String.format("%s Not found", barcode));
    }
}
