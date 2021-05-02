package com.nanolaba.commons;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertTrue;

public class NumbersTest {

    @Test
    public void testPositive() {
        assertTrue(Numbers.positive(1));
        assertTrue(Numbers.positive(1L));
        assertTrue(Numbers.positive(0.1));
        assertTrue(Numbers.positive(0.1f));
        assertTrue(Numbers.positive(new BigDecimal(1.0)));
        assertTrue(Numbers.positive(new BigInteger("1")));
        assertTrue(Numbers.positive(new AtomicLong(1)));
    }

    @Test
    public void testAnyPositive() {
        assertTrue(Numbers.anyPositive(1, 1L, 0.1, 1, new BigDecimal(0)));
    }
}