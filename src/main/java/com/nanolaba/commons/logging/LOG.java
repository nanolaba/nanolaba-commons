package com.nanolaba.commons.logging;

import java.util.function.Supplier;

public class LOG {

    private static ILogger logger = new SimpleConsoleLogger();

    private LOG() {/**/}

    public static void init(ILogger logger) {
        LOG.logger = logger;
    }

    // TRACE
    public static void trace(Class targetClass, Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, () -> targetClass, t, memoize(message)));
    }

    public static void trace(Class targetClass, Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, () -> targetClass, t, () -> message));
    }

    public static void trace(Class targetClass, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, () -> targetClass, null, memoize(message)));
    }

    public static void trace(Class targetClass, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, () -> targetClass, null, () -> message));
    }

    public static void trace(Class targetClass, Throwable throwable) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, () -> targetClass, throwable, null));
    }

    public static void trace(Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, memoize(() -> getCurrentClass()), t, memoize(message)));
    }

    public static void trace(Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, memoize(() -> getCurrentClass()), t, () -> message));
    }

    public static void trace(Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, memoize(() -> getCurrentClass()), null, memoize(message)));
    }

    public static void trace(Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.TRACE, memoize(() -> getCurrentClass()), null, () -> message));
    }

    // DEBUG
    public static void debug(Class targetClass, Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, () -> targetClass, t, memoize(message)));
    }

    public static void debug(Class targetClass, Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, () -> targetClass, t, () -> message));
    }

    public static void debug(Class targetClass, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, () -> targetClass, null, memoize(message)));
    }

    public static void debug(Class targetClass, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, () -> targetClass, null, () -> message));
    }

    public static void debug(Class targetClass, Throwable throwable) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, () -> targetClass, throwable, null));
    }

    public static void debug(Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, memoize(() -> getCurrentClass()), t, memoize(message)));
    }

    public static void debug(Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, memoize(() -> getCurrentClass()), t, () -> message));
    }

    public static void debug(Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, memoize(() -> getCurrentClass()), null, memoize(message)));
    }

    public static void debug(Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.DEBUG, memoize(() -> getCurrentClass()), null, () -> message));
    }

    // INFO
    public static void info(Class targetClass, Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, () -> targetClass, t, memoize(message)));
    }

    public static void info(Class targetClass, Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, () -> targetClass, t, () -> message));
    }

    public static void info(Class targetClass, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, () -> targetClass, null, memoize(message)));
    }

    public static void info(Class targetClass, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, () -> targetClass, null, () -> message));
    }

    public static void info(Class targetClass, Throwable throwable) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, () -> targetClass, throwable, null));
    }

    public static void info(Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, memoize(() -> getCurrentClass()), t, memoize(message)));
    }

    public static void info(Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, memoize(() -> getCurrentClass()), t, () -> message));
    }

    public static void info(Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, memoize(() -> getCurrentClass()), null, memoize(message)));
    }

    public static void info(Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.INFO, memoize(() -> getCurrentClass()), null, () -> message));
    }

    // WARN
    public static void warn(Class targetClass, Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, () -> targetClass, t, memoize(message)));
    }

    public static void warn(Class targetClass, Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, () -> targetClass, t, () -> message));
    }

    public static void warn(Class targetClass, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, () -> targetClass, null, memoize(message)));
    }

    public static void warn(Class targetClass, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, () -> targetClass, null, () -> message));
    }

    public static void warn(Class targetClass, Throwable throwable) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, () -> targetClass, throwable, null));
    }

    public static void warn(Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, memoize(() -> getCurrentClass()), t, memoize(message)));
    }

    public static void warn(Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, memoize(() -> getCurrentClass()), t, () -> message));
    }

    public static void warn(Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, memoize(() -> getCurrentClass()), null, memoize(message)));
    }

    public static void warn(Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.WARN, memoize(() -> getCurrentClass()), null, () -> message));
    }

    // ERROR
    public static void error(Class targetClass, Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, () -> targetClass, t, memoize(message)));
    }

    public static void error(Class targetClass, Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, () -> targetClass, t, () -> message));
    }

    public static void error(Class targetClass, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, () -> targetClass, null, memoize(message)));
    }

    public static void error(Class targetClass, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, () -> targetClass, null, () -> message));
    }

    public static void error(Class targetClass, Throwable throwable) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, () -> targetClass, throwable, null));
    }

    public static void error(Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, memoize(() -> getCurrentClass()), t, memoize(message)));
    }

    public static void error(Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, memoize(() -> getCurrentClass()), t, () -> message));
    }

    public static void error(Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, memoize(() -> getCurrentClass()), null, memoize(message)));
    }

    public static void error(Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.ERROR, memoize(() -> getCurrentClass()), null, () -> message));
    }

    /////////////////////////////////////////


    private static Class getCurrentClass() {
        try {
            throw new Throwable();
        } catch (Throwable t) {
            for (StackTraceElement element : t.getStackTrace()) {
                try {
                    Class result = Class.forName(element.getClassName());
                    if (result != null) {
                        while (result.getEnclosingClass() != null) {
                            result = result.getEnclosingClass();
                        }

                        if (result.equals(LOG.class) || result.equals(LogEntry.class)) {
                            continue;
                        }
                    }

                    return result;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    private static <T> Supplier<T> memoize(Supplier<T> original) {

        if (original == null) {
            return null;
        }

        return new Supplier<T>() {
            private Supplier<T> delegate = this::firstTime;
            private boolean initialized;

            @Override
            public T get() {
                return delegate.get();
            }

            private synchronized T firstTime() {
                if (!initialized) {
                    T value = original.get();
                    delegate = () -> value;
                    initialized = true;
                }
                return delegate.get();
            }
        };
    }
}
