package com.andrab.flares.cobolino;

public class InMemoryTaxRateStore implements ForGettingTaxRates {
    public double taxRateForState(String state) {
        return 6.85;
    }
}
