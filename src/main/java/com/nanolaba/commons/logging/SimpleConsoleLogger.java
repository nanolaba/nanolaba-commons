package com.nanolaba.commons.logging;

import java.io.PrintStream;

public class SimpleConsoleLogger implements ILogger {
    @Override
    public void log(LogEntry entry) {
        LogEntry.LogEntryLevel level = entry.getLevel();
        Class aClass = entry.getSourceClass();
        Object message = entry.getMessage();
        Throwable throwable = entry.getThrowable();

        PrintStream out = level == LogEntry.LogEntryLevel.ERROR ? System.err : System.out;

        out.print(level);
        if (aClass != null) {
            out.print(" [");
            out.print(aClass.getSimpleName());
            out.print("]");
        }
        if (message != null) {
            out.print(" ");
            out.print(message);
        }
        if (throwable != null) {
            out.print(" ");
            throwable.printStackTrace(out);
        } else {
            out.println();
        }

    }
}
