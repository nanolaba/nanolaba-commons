package com.nanolaba.commons.logging;

import org.junit.Before;
import org.junit.Test;

public class Slf4jLoggerTest {
    @Before
    public void init() {
        LOG.init(new Slf4jLogger());
    }

    @Test
    public void testDebugLog() {
        LOG.debug(Slf4jLoggerTest.class, new RuntimeException("ex"), () -> "ex1");
        LOG.debug(Slf4jLoggerTest.class, new RuntimeException("ex"), "ex2");
        LOG.debug(Slf4jLoggerTest.class, () -> "ex3");
        LOG.debug(Slf4jLoggerTest.class, "ex4");
        LOG.debug(() -> "ex5");
        LOG.debug("ex6");
        LOG.debug(new RuntimeException("ex7"), () -> "ex7");
        LOG.debug(new RuntimeException("ex8"), "ex8");
        LOG.debug(new RuntimeException("ex88"));
        LOG.debug("Some {} message {} with {} args ", "123123", "ASASD", 123);
    }
}