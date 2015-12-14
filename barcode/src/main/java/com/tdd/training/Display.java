package com.tdd.training;

import com.tdd.training.Price;

public interface Display
{
    void showPrice(Price price);

    void showPriceNotFound(String s);
}
