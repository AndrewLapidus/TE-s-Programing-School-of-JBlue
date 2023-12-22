package com.test;

public abstract class gameAspects {

    private String focus;
    private Integer quantity;
    private Integer cost;
    private String equation;
    /*
    Unsure if all aspects will come through gameaspects or i'll make a different for each section.
     */
    public gameAspects(String focus, Integer quantity, Integer cost) {
        this.focus = focus;
        this.quantity = quantity;
        this.cost = cost;

    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
