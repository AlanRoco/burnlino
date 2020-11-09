package com.andrab.flares.cobolino;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

public class PriceMakerTests {
    @Test
    public void ShouldEchoValue() {
        PriceMaker app = new PriceMaker();
        assertThat(app.echoValue(100), is(equalTo(100)));
    }

    @Test
    public void ShouldGive6PercentForFlorida() {
        PriceMaker app = new PriceMaker();
        app.setTaxStore(new InMemoryTaxStore());

        double tax = app.getTaxRateForState("FL");
        assertThat(String.format("%.2f", tax), is(equalTo("6.85")));
    }

    @Test
    public void ShouldAddTaxToValue() {
        PriceMaker app = new PriceMaker();
        app.setTaxStore(new InMemoryTaxStore());

        double price = app.calculatePriceWithTax(100, "FL");
        assertThat(String.format("%.2f", price), is(equalTo("106.85")));
    }
}
