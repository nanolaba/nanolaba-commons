package com.nanolaba.commons.logging;

import org.junit.Before;
import org.junit.Test;

public class Slf4jLoggerTest {
    @Before
    public void init() {
        LOG.init(new Slf4jLogger());
    }

    @Test
    public void testLog() {
        SimpleConsoleLogger logger = new SimpleConsoleLogger();

        for (LogEntry.LogEntryLevel level : LogEntry.LogEntryLevel.values()) {
            logger.log(new LogEntry(level, () -> getClass(), new Throwable("test throwable"), () -> "some message"));
        }
    }

    @Test
    public void testDebugLog() {
        LOG.debug(LOGTest.class, new RuntimeException("ex"), () -> "ex1");
        LOG.debug(LOGTest.class, new RuntimeException("ex"), "ex2");
        LOG.debug(LOGTest.class, () -> "ex3");
        LOG.debug(LOGTest.class, "ex4");
        LOG.debug(() -> "ex5");
        LOG.debug("ex6");
        LOG.debug(new RuntimeException("ex7"), () -> "ex7");
        LOG.debug(new RuntimeException("ex8"), "ex8");
        LOG.debug(new RuntimeException("ex88"));
    }
}