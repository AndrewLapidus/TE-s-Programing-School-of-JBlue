package com.test;

public class Student extends gameAspects{
    public Student(String focus, Double quantity, Integer cost, Double bonus) {
        super(focus, quantity, cost, bonus);
        setEquation("(1.0/126.0)*pow(qty-10,3)+10");
        setProduction(0.1);
    }
}
