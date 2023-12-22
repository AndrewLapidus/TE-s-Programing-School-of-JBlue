package com.test;

public class Senior extends gameAspects{
    public Senior(String focus, Integer quantity, Integer cost) {
        super(focus, quantity, cost);
        setEquation("(1.0/10.0)*pow(qty,3)+1000");

    }
}
