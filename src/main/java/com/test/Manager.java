package com.test;

public class Manager extends gameAspects{
    public Manager(String focus, Integer quantity, Integer cost) {
        super(focus, quantity, cost);
        setEquation("(1.0/10.0)*pow(qty,3)+10000");
    }
}
