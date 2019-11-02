package com.nanolaba.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;


public class Slf4jLogger implements ILogger {

    private final Map<Class, Logger> loggers = new ConcurrentHashMap<>();

    @Override
    public void log(LogEntry entry) {

        Logger logger = loggers.computeIfAbsent(entry.getSourceClass(), aClass -> LoggerFactory.getLogger(aClass));

        switch (entry.getLevel()) {
            case TRACE:
                trace(logger, entry);
                break;
            case DEBUG:
                debug(logger, entry);
                break;
            case INFO:
                info(logger, entry);
                break;
            case WARN:
                warn(logger, entry);
                break;
            case ERROR:
                error(logger, entry);
                break;
            default:
                info(logger, entry);

        }
    }

    @Override
    public boolean isEnabled(LogEntry.LogEntryLevel level, Supplier<Class> sourceClass) {
        Logger logger = loggers.computeIfAbsent(sourceClass == null ? null : sourceClass.get(), aClass -> LoggerFactory.getLogger(aClass));

        switch (level) {
            case TRACE:
                return logger.isTraceEnabled();
            case DEBUG:
                return logger.isDebugEnabled();
            case INFO:
                return logger.isInfoEnabled();
            case WARN:
                return logger.isWarnEnabled();
            case ERROR:
                return logger.isErrorEnabled();
            default:
                return logger.isInfoEnabled();
        }
    }

    private void trace(Logger logger, LogEntry entry) {
        if (logger.isTraceEnabled()) {
            logger.trace(trim(entry.getMessage()), entry.getThrowable());
        }
    }

    private void debug(Logger logger, LogEntry entry) {
        if (logger.isDebugEnabled()) {
            logger.debug(trim(entry.getMessage()), entry.getThrowable());
        }
    }

    private void info(Logger logger, LogEntry entry) {
        if (logger.isInfoEnabled()) {
            logger.info(trim(entry.getMessage()), entry.getThrowable());
        }
    }

    private void warn(Logger logger, LogEntry entry) {
        if (logger.isWarnEnabled()) {
            logger.warn(trim(entry.getMessage()), entry.getThrowable());
        }
    }

    private void error(Logger logger, LogEntry entry) {
        if (logger.isErrorEnabled()) {
            logger.error(trim(entry.getMessage()), entry.getThrowable());
        }
    }

    private String trim(Object message) {
        return message == null ? "" : message.toString();
    }
}
