package com.andrab.flares.cobolino;

interface ForCalculatingPrices {
    public int echoValue(int value);
    public double getTaxForState(String state);
}

interface ForGettingTaxRates {
    public double taxForState(String state);
}

public class PriceMaker implements ForCalculatingPrices {

    private ForGettingTaxRates taxStore;

    public void setTaxStore(ForGettingTaxRates taxes) {
        this.taxStore = taxes;
    }

    public int echoValue(int value) {
        return value;
    }

    public double getTaxForState(String state) {
        return taxStore.taxForState(state);
    }
}
