package com.andrab.flares.cobolino;

public class PriceMaker implements ForCalculatingPrices {

    private ForGettingTaxRates taxRateStore;

    public void setTaxRateStore(ForGettingTaxRates taxes) {
        this.taxRateStore = taxes;
    }

    public int echoValue(int value) {
        return value;
    }

    public double getTaxRateForState(String state) {
        return taxRateStore.taxRateForState(state);
    }

    public double calculatePriceWithTaxRate(int value, String state) {
        double taxRate = getTaxRateForState(state) / 100;
        double taxAmount = value * taxRate;

        double price = value + taxAmount;

        return price;
    }

}
