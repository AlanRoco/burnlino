package com.andrab.flares.cobolino;

public class InMemoryTaxStore implements ForGettingTaxRates {
    public double taxRateForState(String state) {
        return 6.85;
    }
}
