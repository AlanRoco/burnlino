package com.andrab.flares.cobolino;

public interface ForCalculatingPrices {
    int echoValue(int value);

    double getTaxRateForState(String state);

    double calculatePriceWithTaxRate(int value, String state);
}
