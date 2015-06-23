package com.nanolaba.commons;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MoneyUtil {

    private MoneyUtil() {
    }

    public static String format(BigDecimal amount) {
        return format(amount, true);
    }

    public static String format(BigDecimal amount, boolean showCurrency) {
        return format(amount, showCurrency, "###,###,##0.##");
    }

    public static String format(BigDecimal amount, boolean showCurrency, String format) {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setGroupingSeparator(' ');
        DecimalFormat formatter = new DecimalFormat(format, symbols);
        return formatter.format(amount == null ? BigDecimal.valueOf(0.0) : amount) + (showCurrency ? " руб." : "");
    }
}
