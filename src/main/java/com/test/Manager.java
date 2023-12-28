package com.test;

public class Manager extends gameAspects{
    public Manager(String focus,Double quantity, Integer cost, Double bonus) {
        super(focus, quantity, cost, bonus);
        setEquation("(1.0/126.0)*pow(qty-40,3)+1008");
        setProduction(50.0);
    }
}
