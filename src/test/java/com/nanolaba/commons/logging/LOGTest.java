package com.nanolaba.commons.logging;

import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.junit.Assert;
import org.junit.Test;

public class LOGTest {

    @Test
    public void testDebugLog() {

        Mutable<String> message = new MutableObject<>();

        LOG.init(entry -> message.setValue(entry.toString()));

        LOG.debug(LOGTest.class, new RuntimeException("ex"), () -> "ex1");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex1}", message.getValue());

        LOG.debug(LOGTest.class, new RuntimeException("ex"), "ex2");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex2}", message.getValue());

        LOG.debug(LOGTest.class, () -> "ex3");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex3}", message.getValue());

        LOG.debug(LOGTest.class, "ex4");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex4}", message.getValue());

        LOG.debug(() -> "ex5");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex5}", message.getValue());

        LOG.debug("ex6");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex6}", message.getValue());

        LOG.debug(new RuntimeException("ex7"), () -> "ex7");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex7, message=ex7}", message.getValue());

        LOG.debug(new RuntimeException("ex8"), "ex8");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex8, message=ex8}", message.getValue());
    }


    @Test
    public void testInfoLog() {

        Mutable<String> message = new MutableObject<>();

        LOG.init(entry -> message.setValue(entry.toString()));

        LOG.info(LOGTest.class, new RuntimeException("ex"), () -> "ex1");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex1}", message.getValue());

        LOG.info(LOGTest.class, new RuntimeException("ex"), "ex2");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex2}", message.getValue());

        LOG.info(LOGTest.class, () -> "ex3");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex3}", message.getValue());

        LOG.info(LOGTest.class, "ex4");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex4}", message.getValue());

        LOG.info(() -> "ex5");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex5}", message.getValue());

        LOG.info("ex6");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex6}", message.getValue());

        LOG.info(new RuntimeException("ex7"), () -> "ex7");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex7, message=ex7}", message.getValue());

        LOG.info(new RuntimeException("ex8"), "ex8");
        Assert.assertEquals("LogEntry{level=INFO, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex8, message=ex8}", message.getValue());
    }


    @Test
    public void testErrorLog() {

        Mutable<String> message = new MutableObject<>();

        LOG.init(entry -> message.setValue(entry.toString()));

        LOG.error(LOGTest.class, new RuntimeException("ex"), () -> "ex1");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex1}", message.getValue());

        LOG.error(LOGTest.class, new RuntimeException("ex"), "ex2");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex2}", message.getValue());

        LOG.error(LOGTest.class, () -> "ex3");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex3}", message.getValue());

        LOG.error(LOGTest.class, "ex4");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex4}", message.getValue());

        LOG.error(() -> "ex5");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex5}", message.getValue());

        LOG.error("ex6");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex6}", message.getValue());

        LOG.error(new RuntimeException("ex7"), () -> "ex7");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex7, message=ex7}", message.getValue());

        LOG.error(new RuntimeException("ex8"), "ex8");
        Assert.assertEquals("LogEntry{level=ERROR, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex8, message=ex8}", message.getValue());
    }


    @Test
    public void testWarnLog() {

        Mutable<String> message = new MutableObject<>();

        LOG.init(entry -> message.setValue(entry.toString()));

        LOG.warn(LOGTest.class, new RuntimeException("ex"), () -> "ex1");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex1}", message.getValue());

        LOG.warn(LOGTest.class, new RuntimeException("ex"), "ex2");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex, message=ex2}", message.getValue());

        LOG.warn(LOGTest.class, () -> "ex3");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex3}", message.getValue());

        LOG.warn(LOGTest.class, "ex4");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex4}", message.getValue());

        LOG.warn(() -> "ex5");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex5}", message.getValue());

        LOG.warn("ex6");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex6}", message.getValue());

        LOG.warn(new RuntimeException("ex7"), () -> "ex7");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex7, message=ex7}", message.getValue());

        LOG.warn(new RuntimeException("ex8"), "ex8");
        Assert.assertEquals("LogEntry{level=WARN, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=java.lang.RuntimeException: ex8, message=ex8}", message.getValue());
    }


    @SuppressWarnings({"Convert2Lambda", "TrivialFunctionalExpressionUsage", "AnonymousInnerClass"})
    @Test
    public void testInnerClasses() {

        Mutable<String> message = new MutableObject<>();

        LOG.init(entry -> message.setValue(entry.toString()));

        //lambda
        ((Runnable) () -> {
            LOG.debug("ex6");
            Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex6}", message.getValue());
        }).run();

        //anonymous class
        new Runnable() {
            @Override
            public void run() {
                LOG.debug("ex7");
                Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex7}", message.getValue());
            }
        }.run();

        //anonymous class with two levels
        new Runnable() {
            @Override
            public void run() {
                new Runnable() {
                    @Override
                    public void run() {
                        LOG.debug("ex8");
                        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex8}", message.getValue());
                    }
                }.run();
            }
        }.run();

        //anonymous class with three levels
        new Runnable() {
            @Override
            public void run() {
                new Runnable() {
                    @Override
                    public void run() {
                        new Runnable() {
                            @Override
                            public void run() {
                                LOG.debug("ex9");
                                Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex9}", message.getValue());
                            }
                        }.run();
                    }
                }.run();
            }
        }.run();

        // named inner class
        new NamedInnerCLass().log("ex10");
        Assert.assertEquals("LogEntry{level=DEBUG, sourceClass=com.nanolaba.commons.logging.LOGTest, throwable=null, message=ex10}", message.getValue());
    }


    private class NamedInnerCLass {

        public void log(String message) {
            LOG.debug(message);
        }
    }
}