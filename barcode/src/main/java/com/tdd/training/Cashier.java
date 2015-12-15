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
        Display display = new Display()
        {
            @Override
            public void show(String s)
            {
                System.out.println(s);
            }
        };
        ShoppingCart shoppingCart = new ShoppingCart(display);
        MapPriceCatalog mapPriceCatalog = new MapPriceCatalog()
        {{
                addPrice("12345", Price.cents(20));
            }};

        PriceConsumerChain displayPriceConsumer = new PriceConsumerChain(Arrays.asList(shoppingCart,new PriceFormatter(display)));
        PriceReader priceReader = new PriceReader(mapPriceCatalog, displayPriceConsumer, display);
        CommandParser commandParser = new CommandParser(priceReader, shoppingCart);
        SystemInputReader systemInputReader = new SystemInputReader(commandParser);

        new Cashier(systemInputReader).process(System.in);
    }

    private void process(InputStream in)
    {
        try
        {
            reader.process(new InputStreamReader(in));
        }
        catch (IOException e)
        {
            throw new RuntimeException("Cannot read from input.",e);
        }
    }
}
