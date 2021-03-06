package com.nanolaba.commons;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class ThreadUtil {

    private ThreadUtil() {
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //ignore
        }
    }

    public static void sleep(long millis, int nanos) {
        try {
            Thread.sleep(millis, nanos);
        } catch (InterruptedException e) {
            //ignore
        }
    }

    public static List<String> getResourceAsLines(String name) throws IOException {
        return getResourceAsLines(name, Charset.defaultCharset());
    }

    public static List<String> getResourceAsLines(String name, String encoding) throws IOException {
        return getResourceAsLines(name, Charsets.toCharset(encoding));
    }

    public static List<String> getResourceAsLines(String name, Charset encoding) throws IOException {
        try (InputStream stream = getResourceAsStream(name)) {
            return IOUtils.readLines(stream, encoding);
        }
    }

    public static String getResourceAsString(String name, Charset encoding) throws IOException {
        try (InputStream stream = getResourceAsStream(name)) {
            return IOUtils.toString(stream, encoding);
        }
    }

    public static String getResourceAsString(String name, String encoding) throws IOException {
        try (InputStream stream = getResourceAsStream(name)) {
            return IOUtils.toString(stream, encoding);
        }
    }

    public static String getResourceAsString(String name) throws IOException {
        return getResourceAsString(name, Charset.defaultCharset());
    }

    public static byte[] getResourceAsByteArray(String name) throws IOException {
        try (InputStream stream = getResourceAsStream(name)) {
            return IOUtils.toByteArray(stream);
        }
    }

    public static InputStream getResourceAsStream(String name) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
    }

    public static URL getResource(String name) {
        return Thread.currentThread().getContextClassLoader().getResource(name);
    }
}
