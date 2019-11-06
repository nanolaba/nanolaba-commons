package com.nanolaba.commons.logging;

import org.junit.Before;
import org.junit.Test;

public class SimpleConsoleLoggerTest {

    @Before
    public void init() {
        LOG.init(new SimpleConsoleLogger());
    }

    @Test
    public void testLog() {
        SimpleConsoleLogger logger = new SimpleConsoleLogger();

        for (LogEntry.LogEntryLevel level : LogEntry.LogEntryLevel.values()) {
            logger.log(new LogEntry(level, () -> getClass(), new Throwable("test throwable"), () -> "some message"));
        }
    }

    @Test
    public void testArgsLog() {
        SimpleConsoleLogger logger = new SimpleConsoleLogger();

        for (LogEntry.LogEntryLevel level : LogEntry.LogEntryLevel.values()) {
            logger.log(new LogEntry(level, () -> getClass(), new Throwable("test throwable"), () -> "some message {} next {}", "abc", "123"));
        }
    }

}