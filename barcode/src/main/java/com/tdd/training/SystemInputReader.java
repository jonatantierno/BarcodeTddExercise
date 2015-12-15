package com.tdd.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SystemInputReader
{
    private final PointOfSaleListener listener;

    public SystemInputReader(PointOfSaleListener listener)
    {
        this.listener = listener;
    }

    public void process(StringReader barcode) throws IOException
    {
        new BufferedReader(barcode).lines().map(String::trim).filter((s) -> !s.isEmpty())
                .forEach((line) -> listener.onEvent(new SystemInputEvent(line)));
    }
}
