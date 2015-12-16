package com.tdd.training;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Cashier
{
    private final SystemInputReader reader;

    public Cashier(SystemInputReader systemInputReader)
    {
        this.reader = systemInputReader;
    }

    public static void main(String args[])
    {
        DisplayFormatter displayFormatter = new DisplayFormatter(new SystemOutDisplay());

        ShoppingCart shoppingCart = new ShoppingCart(displayFormatter);
        PriceConsumerChain displayPriceConsumer = new PriceConsumerChain(Arrays.asList(shoppingCart, displayFormatter));

        Cashier cashier = new Cashier(new SystemInputReader(
                new CommandParser(
                        new PriceReader(
                                new MapPriceCatalog()
                                {{
                                        addPrice("12345", Price.cents(20));
                                    }},
                                displayPriceConsumer,
                                displayFormatter),
                        shoppingCart)));

        cashier.process(System.in);
    }

    private void process(InputStream in)
    {
        try
        {
            reader.process(new InputStreamReader(in));
        }
        catch (IOException e)
        {
            throw new RuntimeException("Cannot read from input.", e);
        }
    }
}
