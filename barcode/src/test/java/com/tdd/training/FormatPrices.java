package com.tdd.training;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FormatPrices
{
    public static final int CENTS = 15;
    public static final Price PRICE = Price.cents(CENTS);
    @Mock
    Display display;

    @Test
    public void formatOnePrice(){
        PriceFormatter formatter = new PriceFormatter(display);

        formatter.consumePrice(PRICE);

        verify(display).show("+ "+ PRICE.inEur());
    }
}
