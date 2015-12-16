package com.tdd.training;

class SystemOutDisplay implements Display
{
    @Override
    public void show(String s)
    {
        System.out.println(s);
    }
}
