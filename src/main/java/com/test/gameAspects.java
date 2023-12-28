package com.test;

public abstract class gameAspects {

    private String focus;
    private Double quantity;
    private Integer cost;
    private Double production;
    private String equation;
    private Double bonus;
    /*
    Unsure if all aspects will come through gameaspects or i'll make a different for each section.
     */
    public gameAspects(String focus, Double quantity, Integer cost, Double bonus) {
        this.focus = focus;
        this.quantity = quantity;
        this.cost = cost;
        this.bonus = bonus;

    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Double getProduction() {
        return production;
    }

    public void setProduction(Double production) {
        this.production = production;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus() {
        double bonus=0.0;
        // convert qty to int and set bonus to 1
        int qty = (int)((getQuantity()*100)/100);
        bonus += 1;
        if(!focus.equals("Money")){
            // Double production for Student if over 20
            if (getFocus().equals("Student") && qty >= 20){
                bonus += 1;
            }
            // for every 50 give 25% boost for every 100 give 50% for every 500 double production
            bonus += .25*(qty/50);
            bonus += .50*(qty/100);
            bonus += 1*(qty/500);
        }else {
            bonus = 0.0;
        }
        this.bonus = bonus;
    }
}
