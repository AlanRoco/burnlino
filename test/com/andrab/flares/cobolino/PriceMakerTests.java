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
}
