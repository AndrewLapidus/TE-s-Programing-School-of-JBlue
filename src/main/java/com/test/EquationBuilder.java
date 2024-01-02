package com.test;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.concurrent.ConcurrentHashMap;

public class EquationBuilder {

    static ConcurrentHashMap<String, Object> dataMap = (ConcurrentHashMap<String, Object>) App.getDataMap();

    // calculating rate of cost or something
    public static int main(String str){


        try {
            gameAspects objects = (gameAspects) dataMap.get(str);
            String equation = objects.getEquation();
            double qty = objects.getQuantity();

            Expression expression = new ExpressionBuilder(equation)
                    .variables("qty")
                    .build()
                    .setVariable("qty", qty);
            double result = expression.evaluate();
            int intResult = (int)result;
            return intResult;
        } catch (Exception e) {
            UpgradeAspects objects = (UpgradeAspects) dataMap.get(str);
            String equation = objects.getEquation();
            double qty = objects.getQty();

            Expression expression = new ExpressionBuilder(equation)
                    .variables("qty")
                    .build()
                    .setVariable("qty", qty);
            double result = expression.evaluate();
            int intResult = (int)result;
            return intResult;
        }

    }
}
