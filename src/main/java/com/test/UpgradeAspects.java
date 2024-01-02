package com.test;

import java.io.PrintWriter;
import java.security.PrivateKey;

public abstract class UpgradeAspects {
    private String focus;
    private Boolean tOrF;
    private Integer qty;
    private Integer cap;
    private Integer require;
    private Double modifyer;
    private Integer cost;
    private String equation;
/*
Unsure if all aspects will come through gameaspects or i'll make a different for each section.
this section is currently not in use yet.
 */

    public UpgradeAspects(String focus, Boolean tOrF, Integer qty, Integer cap, Integer require, Double modifyer, Integer cost, String equation) {
        this.focus = focus;
        this.tOrF = tOrF;
        this.qty = qty;
        this.cap = cap;
        this.require = require;
        this.modifyer = modifyer;
        this.cost = cost;
        this.equation = equation;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public Boolean gettOrF() {
        return tOrF;
    }

    public void settOrF(Boolean tOrF) {
        this.tOrF = tOrF;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public Integer getRequire() {
        return require;
    }

    public void setRequire(Integer require) {
        this.require = require;
    }

    public Double getModifyer() {
        return modifyer;
    }

    public void setModifyer(Double modifyer) {
        this.modifyer = modifyer;
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
