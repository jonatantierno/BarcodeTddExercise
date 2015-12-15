package com.tdd.training;

import java.util.ArrayList;
import java.util.List;

public class PriceConsumerChain implements PriceConsumer
{

    private final List<PriceConsumer> consumers;

    public PriceConsumerChain(List<PriceConsumer> consumers)
    {
        this.consumers = new ArrayList<>(consumers);
    }

    @Override
    public void consumePrice(Price price)
    {
        consumers.stream().forEach((c)->c.consumePrice(price));
    }
}
