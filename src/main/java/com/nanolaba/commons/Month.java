package com.nanolaba.commons;

import java.util.Calendar;
import java.util.Date;

public enum Month {

    JAN(1, "январь", "января"),
    FEB(2, "февраль", "февраля"),
    MAR(3, "март", "марта"),
    APR(4, "апрель", "апреля"),
    MAY(5, "май", "мая"),
    JUN(6, "июнь", "июня"),
    JUL(7, "июль", "июля"),
    AUG(8, "август", "августа"),
    SEP(9, "сентябрь", "сентября"),
    OCT(10, "октябрь", "октября"),
    NOV(11, "ноябрь", "ноября"),
    DEC(12, "декабрь", "декабря");

    private final int monthNumber;
    private final String title;
    private final String title2;

    Month(int monthNumber, String title, String title2) {
        this.monthNumber = monthNumber;
        this.title = title;
        this.title2 = title2;
    }

    public static Month valueOf(int i) {
        for (Month month : values()) {
            if (month.monthNumber == i) {
                return month;
            }
        }
        return null;
    }

    public static Month current() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return valueOf(calendar.get(Calendar.MONTH) + 1);
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle2() {
        return title2;
    }
}
