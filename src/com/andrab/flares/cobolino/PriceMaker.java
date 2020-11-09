package com.andrab.flares.cobolino;

interface ForCalculatingPrices {
    public int echoValue(int value);
}

public class PriceMaker implements ForCalculatingPrices {
    @Override
    public int echoValue(int value) {
        return value;
    }
}
