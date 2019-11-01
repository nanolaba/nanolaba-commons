package com.nanolaba.commons.logging;

import java.util.function.Supplier;

public class LogEntry {

    public enum LogEntryLevel {
        DEBUG, INFO, ERROR, FATAL
    }

    private final LogEntryLevel level;
    private final Supplier<Class> sourceClass;
    private final Throwable throwable;
    private final Supplier<Object> message;

    public LogEntry(LogEntryLevel level, Supplier<Class> sourceClass, Throwable throwable, Supplier<Object> message) {
        this.level = level;
        this.sourceClass = sourceClass;
        this.throwable = throwable;
        this.message = message;
    }

    public LogEntryLevel getLevel() {
        return level;
    }

    public Class getSourceClass() {
        return sourceClass == null ? null : sourceClass.get();
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public Object getMessage() {
        return message == null ? null : message.get();
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "level=" + level +
                ", sourceClass=" + (sourceClass == null ? null : (sourceClass.get() == null ? null : sourceClass.get().getCanonicalName())) +
                ", throwable=" + throwable +
                ", message=" + (message == null ? null : message.get()) +
                '}';
    }
}
