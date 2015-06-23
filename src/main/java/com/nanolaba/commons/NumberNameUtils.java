package com.nanolaba.commons;

public class NumberNameUtils {

    private NumberNameUtils() {
    }

    public static String format(String aa, String bb, String cc, Long num, String a, String b, String c) {
        num = num == null ? 0L : num;
        long r = num % 10L;
        if (num >= 10L && num <= 20L) {
            return aa + " " + num + " " + a;
        }

        return (r == 1L ? bb : (r > 0 && r < 5 ? cc : aa)) + " " + num + " " + (r == 1L ? b : (r > 0 && r < 5 ? c : a));
    }

    public static String format(Long num, String a, String b, String c) {
        num = num == null ? 0L : num;
        long r = num % 10L;
        if (num >= 10L && num <= 20L) {
            return num + " " + a;
        }

        return num + " " + (r == 1L ? b : (r > 0 && r < 5 ? c : a));
    }


}
