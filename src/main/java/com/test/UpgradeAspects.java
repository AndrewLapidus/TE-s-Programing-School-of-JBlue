package com.test;

import java.io.PrintWriter;
import java.security.PrivateKey;

public class UpgradeAspects {
    private String focus;
    private Boolean tOrF;
    private Integer qty;
    private Integer cap;
    private Integer require;
    private Double modifyer;
/*
Unsure if all aspects will come through gameaspects or i'll make a different for each section.
this section is currently not in use yet.
 */
    public UpgradeAspects(String focus, Boolean tOrF, Integer qty, Integer cap, Integer require, Double modifyer) {
        this.focus = focus;
        this.tOrF = tOrF;
        this.qty = qty;
        this.cap = cap;
        this.require = require;
        this.modifyer = modifyer;
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
}
