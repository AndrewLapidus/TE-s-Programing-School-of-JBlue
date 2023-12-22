package com.test;

public class Student extends gameAspects{
    public Student(String focus, Integer quantity, Integer cost) {
        super(focus, quantity, cost);
        setEquation("(1.0/10.0)*pow(qty,3)+10");
    }
}
