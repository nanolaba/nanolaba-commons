package com.nanolaba.commons;

import com.nanolaba.commons.exceptions.ParseDateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TimeUtils {

    private static final String[] MONTHS_0 = {
            "января", "февраля", "марта", "апреля", "мая", "июня", "июля", "августа",
            "сентября", "октября", "ноября", "декабря",
    };

    private static final String[] DAY_0 = {"первое", "второе", "третье", "четвертое", "пятое", "шестое", "седьмое", "восьмое", "девятое"};
    private static final String[] DAY_1 = {"десятое", "одиннадцатое", "двенадцатое", "тринадцатое", "четырнадцатое", "пятнадцатое", "шестнадцатое", "семнадцатое", "восемнадцатое", "девятнадцатое"};
    private static final String[] Y_0 = {"", "первого", "второго", "третьего", "четвертого", "пятого", "шестого", "седьмого", "восьмого", "девятого"};
    private static final String[] Y_11 = {"одиннадцатого", "двенадцатого", "тринадцатого", "четырнадцатого", "пятнадцатого", "шестнадцатого", "семнадцатого", "восемнадцатого", "девятнадцатого"};
    private static final String[] Y_1 = {"", "десятого", "двадцатого", "тридцатого", "сорокового", "пятидесятого", "шестидесятого", "семидесятого", "восьмидесятого", "девяностого"};
    private static final String[] Y_2 = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] Y_3 = {"", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String[] Y_4 = {"", "сотого", "двухсотого", "стрехсотого", "четырехсотого", "пятисотого", "шестисотого", "семисотого", "восьмисотого", "девятисотого"};
    private static final String[] Y_5 = {"", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч"};
    private static final String[] Y_6 = {"", "тысячного", "двухтысячного", "трехтысячного", "четырехтысячного", "пятитысячного", "шеститысячного", "семитысячного", "восьмитысячного", "девятитысячного"};

    private TimeUtils() {/**/}

    public static Date min(Date a, Date b) {
        return a.after(b) ? b : a;
    }

    public static Date max(Date a, Date b) {
        return b.after(a) ? b : a;
    }

    public static String formatDate(Date date, boolean showYear) {
        return formatDate(date, showYear, true);
    }

    public static String formatDate(Date date, boolean showYear, boolean showWords) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        if (showWords) {
            if (dateFormat.format(date).equals(dateFormat.format(new Date()))) {
                return "сегодня";
            }
            if (dateFormat.format(date).equals(dateFormat.format(new Date(new Date().getTime() - 1000 * 60 * 60 * 24)))) {
                return "вчера";
            }
            if (dateFormat.format(date).equals(dateFormat.format(new Date(new Date().getTime() + 1000 * 60 * 60 * 24)))) {
                return "завтра";
            }
        }

        return calendar.get(Calendar.DAY_OF_MONTH) + " " +
                MONTHS_0[calendar.get(Calendar.MONTH)] + (showYear ? " " +
                calendar.get(Calendar.YEAR) : "");
    }

    public static Date convert(Date date, TimeZone from, TimeZone to) {

        if (date == null) {
            return null;
        }

        SimpleDateFormat defaultFormatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        defaultFormatter.setTimeZone(from);
        SimpleDateFormat f = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        f.setTimeZone(to);
        try {
            return defaultFormatter.parse(f.format(date));
        } catch (ParseException e) {
            throw new ParseDateException(e);
        }
    }

    public static String formatTime(Date date) {
        if (date == null) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int min = calendar.get(Calendar.MINUTE);
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        calendar.setTime(date);
        return formatDate(date, true) + " в " +
                (hours < 10 ? "0" : "") + hours + ':' + (min < 10 ? "0" : "") + min;
    }

    public static String toString(Date value, String format) {
        return value == null ? null : new SimpleDateFormat(format).format(value);
    }

    public static String toString(Date value) {
        return value == null ? null : new SimpleDateFormat("dd.MM.yyyy").format(value);
    }

    public static Date toDate(String value, String format) {
        try {
            return value == null || value.trim().isEmpty() ? null : new SimpleDateFormat(format).parse(value);
        } catch (ParseException e) {
            throw new ParseDateException(e);
        }
    }

    public static Date toDate(String value) {
        return toDate(value, "dd.MM.yyyy");
    }

    public static int monthLength(Integer year, Month month) {
        GregorianCalendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month.getMonthNumber() - 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date getDateWithoutTime(Date date) {
        if (date == null) {
            return null;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            return dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            throw new ParseDateException(e);
        }
    }

    public static Date getDateWithoutMilliseconds(Date date) {
        if (date == null) {
            return null;
        }

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            return dateFormat.parse(dateFormat.format(date));
        } catch (ParseException e) {
            throw new ParseDateException(e);
        }
    }

    public static String getDayOfWeek(Date date) {
        switch (getCalendarField(date, Calendar.DAY_OF_WEEK)) {
            case 2:
                return "понедельник";
            case 3:
                return "вторник";
            case 4:
                return "среда";
            case 5:
                return "четверг";
            case 6:
                return "пятница";
            case 7:
                return "суббота";
            case 1:
                return "воскресенье";
            default:
                return "";
        }
    }

    public static Integer getYear(Date date) {
        if (date != null) {
            return getCalendarField(date, Calendar.YEAR);
        }
        return null;
    }

    public static int getCalendarField(Date date, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

    public static String getDayOfWeekShort(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 2:
                return "пн";
            case 3:
                return "вт";
            case 4:
                return "ср";
            case 5:
                return "чт";
            case 6:
                return "пт";
            case 7:
                return "сб";
            case 1:
                return "вс";
            default:
                return "";
        }
    }

    public static long getDifference(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int workDays = 0;

        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++workDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); //excluding end date

        return workDays;
    }

    public static String toStringInWords(Date date) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int d = calendar.get(Calendar.DAY_OF_MONTH);
        int m = calendar.get(Calendar.MONTH);
        int y = calendar.get(Calendar.YEAR);

        String res = "";

        //Day
        if (d < 10) res += DAY_0[d - 1];
        else {
            if (d == 20) res += "двадцатое";
            if (d == 30) res += "тридцатое";
            if (d < 20) res += DAY_1[d - 10];
            if ((d > 20) && (d < 30)) res += "двадцать " + DAY_0[d - 21];
            if (d > 30) res += "тридцать " + DAY_0[d - 31];
        }
        //Month
        res += " " + MONTHS_0[m];

        //Year
        res += " ";
        if ((y % 1000) != 0) {
            res += Y_5[y / 1000] + " ";
            y = y % 1000;
            if (y % 100 != 0) {
                res += Y_3[y / 100] + " ";
                y = y % 100;
                if (y % 10 != 0) {
                    if ((y > 10) && (y < 20))
                        res += Y_11[y - 11];
                    else res += Y_2[y / 10] + " " + Y_0[y % 10];
                } else res += Y_1[y / 10];
            } else res += Y_4[y / 100];
        } else res += Y_6[y / 1000];
        res += " года";

        return res.replaceAll("[ ]+", " ");
    }
}
