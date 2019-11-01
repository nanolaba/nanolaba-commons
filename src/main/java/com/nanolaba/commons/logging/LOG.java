package com.nanolaba.commons.logging;

import java.util.function.Supplier;

public class LOG {

    private static ILogger logger;

    private LOG() {
    }

    public static void init(ILogger logger) {
        LOG.logger = logger;
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

    // FATAL
    public static void fatal(Class targetClass, Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, () -> targetClass, t, memoize(message)));
    }

    public static void fatal(Class targetClass, Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, () -> targetClass, t, () -> message));
    }

    public static void fatal(Class targetClass, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, () -> targetClass, null, memoize(message)));
    }

    public static void fatal(Class targetClass, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, () -> targetClass, null, () -> message));
    }

    public static void fatal(Class targetClass, Throwable throwable) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, () -> targetClass, throwable, null));
    }

    public static void fatal(Throwable t, Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, memoize(() -> getCurrentClass()), t, memoize(message)));
    }

    public static void fatal(Throwable t, Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, memoize(() -> getCurrentClass()), t, () -> message));
    }

    public static void fatal(Supplier<Object> message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, memoize(() -> getCurrentClass()), null, memoize(message)));
    }

    public static void fatal(Object message) {
        logger.log(new LogEntry(LogEntry.LogEntryLevel.FATAL, memoize(() -> getCurrentClass()), null, () -> message));
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
