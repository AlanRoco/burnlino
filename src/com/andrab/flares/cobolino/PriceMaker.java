package com.andrab.flares.cobolino;

interface ForCalculatingPrices {
    int echoValue(int value);
    double getTaxRateForState(String state);
    double calculatePriceWithTax(int value, String state);
}

interface ForGettingTaxRates {
    double taxRateForState(String state);
}

public class PriceMaker implements ForCalculatingPrices {

    private ForGettingTaxRates taxStore;

    public void setTaxStore(ForGettingTaxRates taxes) {
        this.taxStore = taxes;
    }

    public int echoValue(int value) {
        return value;
    }

    public double getTaxRateForState(String state) {
        return taxStore.taxRateForState(state);
    }

    public double calculatePriceWithTax(int value, String state) {
        double taxRate = getTaxRateForState(state) / 100;
        double taxAmount = value * taxRate;

        double price = value + taxAmount;

        return price;
    }
}
