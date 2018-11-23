package com.nanolaba.commons.intervals;


import java.io.Serializable;

public class Interval<T extends Comparable<T> & Serializable> implements Serializable {

    private final T from;
    private final T to;
    private final boolean includeFrom;
    private final boolean includeTo;

    public static <T extends Comparable & Serializable> Interval from(T from, boolean includeFrom) {
        return create(from, null, includeFrom, false);
    }

    public static <T extends Comparable & Serializable> Interval to(T to, boolean includeTo) {
        return create(null, to, false, includeTo);
    }

    public static <T extends Comparable & Serializable> Interval create(T from, T to, boolean includeFrom, boolean includeTo) {
        return new Interval<>(from, to, includeFrom, includeTo);
    }

    public static <T extends Comparable & Serializable> Interval value(T value) {
        return new Interval<>(value, value, true, true);
    }

    public Interval(T from, T to, boolean includeFrom, boolean includeTo) {
        this.from = from;
        this.to = to;
        this.includeFrom = includeFrom;
        this.includeTo = includeTo;
    }

    public T getFrom() {
        return from;
    }

    public T getTo() {
        return to;
    }

    public boolean isIncludeFrom() {
        return includeFrom;
    }

    public boolean isIncludeTo() {
        return includeTo;
    }

    public boolean isEmpty() {
        return from == null && to == null;
    }

    public boolean contains(Interval<T> interval) {

        if (from != null) {
            if (interval.from == null) {
                return false;
            } else if (from.compareTo(interval.from) > 0) {
                return false;
            } else if (from.compareTo(interval.from) == 0) {
                if (!includeFrom && interval.includeFrom) {
                    return false;
                }
            }
        }

        if (to != null) {
            if (interval.to == null) {
                return false;
            } else if (to.compareTo(interval.to) < 0) {
                return false;
            } else if (to.compareTo(interval.to) == 0) {
                if (!includeTo && interval.includeTo) {
                    return false;
                }
            }
        }

        return true;
    }


    public Interval<T> getToInterval() {
        return new Interval<>(null, to, includeFrom, includeTo);
    }

    public Interval<T> getFromInterval() {
        return new Interval<>(from, null, includeFrom, includeTo);
    }

    public boolean contains(T value) {

        if (from != null) {
            if (value == null) {
                return false;
            } else if (from.compareTo(value) > 0) {
                return false;
            } else if (from.equals(value) && !includeFrom) {
                return false;
            }
        }

        if (to != null) {
            if (value == null) {
                return false;
            } else if (to.compareTo(value) < 0) {
                return false;
            } else if (to.equals(value) && !includeTo) {
                return false;
            }
        }

        return true;
    }


    public boolean hasIntersections(Interval<T> interval) {

        // a.start <= b.end AND a.end >= b.start
        boolean left = true;
        boolean right = true;

        if (from != null && interval.to != null) {
            int comparision = from.compareTo(interval.to);
            if (comparision > 0) {
                left = false;
            } else if (comparision == 0) {
                left = interval.includeTo && includeFrom;
            }
        }

        if (to != null && interval.from != null) {
            int comparision = to.compareTo(interval.from);
            if (comparision < 0) {
                right = false;
            } else if (comparision == 0) {
                right = includeTo && interval.includeFrom;
            }
        }

        return left && right;
    }

    public Class<T> getValueClass() {
        return from != null ? (Class<T>) from.getClass() :
                to != null ? (Class<T>) to.getClass() : null;
    }

    public boolean hasBorders() {
        return from != null || to != null;
    }

    @Override
    public String toString() {
        return (includeFrom ? "[" : ")") +
                from + "; " + to +
                (includeTo ? "]" : ")");
    }
}
