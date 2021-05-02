package com.nanolaba.commons;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Numbers {

    public static boolean zero(BigDecimal val) {
        return val != null && val.compareTo(BigDecimal.ZERO) == 0;
    }

    public static boolean zeroOrNull(BigDecimal val) {
        return val == null || val.compareTo(BigDecimal.ZERO) == 0;
    }

    public static boolean nonZero(BigDecimal val) {
        return val != null && val.compareTo(BigDecimal.ZERO) != 0;
    }

    public static boolean positive(BigDecimal val) {
        return val != null && val.compareTo(BigDecimal.ZERO) > 0;
    }

    public static boolean positive(Number val) {
        return val != null && val.doubleValue() > 0;
    }

    public static boolean anyPositive(BigDecimal... val) {
        return Arrays.stream(val).anyMatch(Numbers::positive);
    }

    public static boolean anyPositive(Number... val) {
        return Arrays.stream(val).anyMatch(Numbers::positive);
    }

    public static boolean negative(BigDecimal val) {
        return val != null && val.compareTo(BigDecimal.ZERO) < 0;
    }

    public static boolean negative(Number val) {
        return val != null && val.doubleValue() < 0;
    }

    public static boolean anyNegative(BigDecimal... val) {
        return Arrays.stream(val).anyMatch(Numbers::negative);
    }

    public static boolean anyNegative(Number... val) {
        return Arrays.stream(val).anyMatch(Numbers::negative);
    }

    public static BigDecimal sum(BigDecimal... val) {
        return Arrays.stream(val)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
