package com.tdd.training;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements PriceConsumer
{
    List<Price> prices = new ArrayList<>();

    @Override
    public void consumePrice(Price price)
    {
        prices.add(price);
    }

    public Price getTotal()
    {
        return prices.stream().reduce(Price.cents(0),(a,b)-> a.sum(b));
    }
}
