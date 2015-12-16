package com.tdd.training;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PriceConsumerChainTest
{
    public static final Price PRICE = Price.cents(1234);

    @Test
    public void whenPriceConsumedInChainThenConsumeInEachConsumer()
    {
        List<PriceConsumer> consumers = Arrays.asList(mock(PriceConsumer.class),mock(PriceConsumer.class));
        PriceConsumerChain consumer = new PriceConsumerChain(consumers);

        consumer.consumePrice(PRICE);

        consumers.forEach((c) -> verify(c).consumePrice(PRICE));
    }
}
