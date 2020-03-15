package com.nanolaba.commons;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyUtilsTest {

    @Test
    public void testFormat() {

        Assert.assertEquals("100 ₽", MoneyUtils.format(BigDecimal.valueOf(100)));
        Assert.assertEquals("100 000 000.12 ₽", MoneyUtils.format(BigDecimal.valueOf(100_000_000.121212)));
    }

}