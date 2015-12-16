package com.tdd.training;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements CheckoutListener, PriceConsumer
{
    List<Price> prices = new ArrayList<>();
    private final CheckoutFormatter checkoutFormatter;

    public ShoppingCart(CheckoutFormatter formatter)
    {
        checkoutFormatter = formatter;
    }

    @Override
    public void consumePrice(Price price)
    {
        prices.add(price);
    }

    public Price getTotal()
    {
        return prices.stream().reduce(Price.cents(0),(a,b)-> a.sum(b));
    }

    @Override
    public void onCheckout()
    {
        checkoutFormatter.checkout(getTotal());
    }
}
