package com.nanolaba.commons;

import java.util.*;

public class CollectionUtils {

    private CollectionUtils() {/**/}

    public static <T> T first(Iterator<T> iterator) {
        return iterator == null || !iterator.hasNext() ? null : iterator.next();
    }

    public static <T> T first(Collection<T> collection) {

        if (collection == null || collection.isEmpty()) {
            return null;
        }

        if (collection instanceof List) {
            return ((List<T>) collection).get(0);
        }

        return collection.iterator().next();
    }

    public static <T> T first(Collection<T> collection, Comparator<T> comparator) {

        if (collection == null || collection.isEmpty()) {
            return null;
        }

        List<T> list = new ArrayList<T>(collection);
        list.sort(comparator);
        return list.get(0);
    }

    public static <T> T last(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        Iterator<T> iterator = collection.iterator();
        T last = null;
        while (iterator.hasNext()) {
            last = iterator.next();
        }
        return last;
    }

    public static <T> T last(Collection<T> collection, Comparator<T> comparator) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }

        List<T> list = new ArrayList<T>(collection);
        list.sort(comparator);
        return list.get(list.size() - 1);
    }

    public static boolean isEmpty(Collection... collections) {
        for (Collection c : collections) {
            if (c != null && !c.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static <T> Set<T> union(Collection<T> first, Collection<T> second) {
        Set<T> set = new HashSet<T>();

        set.addAll(first);
        set.addAll(second);

        return set;
    }

    public static <T> Set<T> intersection(Collection<T> first, Collection<T> second) {
        Set<T> list = new HashSet<>();

        for (T t : first) {
            if (second.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
}
