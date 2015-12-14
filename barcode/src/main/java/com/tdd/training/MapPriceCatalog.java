package com.tdd.training;

import java.util.HashMap;
import java.util.Map;

public class MapPriceCatalog implements PriceCatalog
{
    private Map<String, Price> map = new HashMap<>();

    @Override
    public Price findPrice(String barcode)
    {
        return map.get(barcode);
    }

    public void addPrice(String code, Price price)
    {
        map.put(code,price);
    }
}
