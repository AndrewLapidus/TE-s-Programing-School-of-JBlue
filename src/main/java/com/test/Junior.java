package com.test;

public class Junior extends gameAspects{
    public Junior(String focus, Double quantity, Integer cost, Double bonus){
        super(focus, quantity, cost, bonus);
        setEquation("(1.0/126.0)*pow(qty-37,3)+453");
        setProduction(1.0);
    }
}
