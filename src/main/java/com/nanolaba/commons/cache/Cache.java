package com.nanolaba.commons.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Cache<T, TT> implements Serializable {

    private final Map<T, TT> cache = new HashMap<>();
    private SerializableFunction<T, TT> getter;

    public Cache() {
    }

    public Cache(SerializableFunction<T, TT> getter) {
        this.getter = getter;
    }

    public void remove(T key) {
        cache.remove(key);
    }

    public TT get(T key) {
        TT val = cache.get(key);
        if (getter != null && val == null) {
            synchronized (cache) {
                return cache.computeIfAbsent(key, getter);
            }
        } else {
            return val;
        }
    }

    public void put(T key, TT value) {
        cache.put(key, value);
    }

    public void clear() {
        synchronized (cache) {
            cache.clear();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FunctionalInterface
    public interface SerializableFunction<T, R> extends Function<T, R>, Serializable {

    }
}
