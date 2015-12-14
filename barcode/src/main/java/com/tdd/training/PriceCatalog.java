package com.tdd.training;

import com.tdd.training.Price;

public interface PriceCatalog
{
    Price findPrice(String barcode);
}
