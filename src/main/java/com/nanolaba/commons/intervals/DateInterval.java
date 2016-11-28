package com.nanolaba.commons.intervals;


import com.nanolaba.commons.Month;
import com.nanolaba.commons.TimeUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateInterval extends Interval<Date> {


    public static DateInterval from(Date from, boolean includeFrom) {
        return create(from, null, includeFrom, false);
    }

    public static DateInterval to(Date to, boolean includeTo) {
        return create(null, to, false, includeTo);
    }

    public static DateInterval createYearInterval(int year) {
        Date from = TimeUtils.toDate("01.01." + year);
        Date to = TimeUtils.toDate("01.01." + (year + 1));
        return create(from, to, true, false);
    }

    public static DateInterval createMonthInterval(Month month, int year) {
        Date from = TimeUtils.toDate("01." + month.getMonthNumber() + "." + year);
        Date to = TimeUtils.toDate("01." + (month.getMonthNumber() + 1) + "." + year);
        return create(from, to, true, false);
    }

    public static DateInterval createDayInterval(int day, Month month, int year) {
        return createDayInterval(TimeUtils.toDate(day + "." + month.getMonthNumber() + "." + year));
    }

    public static DateInterval createDayInterval(Date day) {
        Date from = TimeUtils.getDateWithoutTime(day);
        Date to = DateUtils.addDays(from, 1);
        return create(from, to, true, false);
    }

    public static DateInterval createStrict(Date from) {
        return new DateInterval(from, from, true, true);
    }

    public static DateInterval create(Date from, Date to, boolean includeFrom, boolean includeTo) {
        return new DateInterval(from, to, includeFrom, includeTo);
    }

    public DateInterval(Date from, Date to, boolean includeFrom, boolean includeTo) {
        super(from, to, includeFrom, includeTo);
    }


    public static DateInterval create(Interval<Date> date) {
        return create(date.getFrom(), date.getTo(), date.isIncludeFrom(), date.isIncludeTo());
    }

    public long getDaysNumber() {
        return getFrom() == null || getTo() == null ? 0L : (getFrom().getTime() - getTo().getTime()) / (1000L * 60L * 60L * 24L);
    }

    public List<DateInterval> splitByDays() {
        List<DateInterval> res = new ArrayList<>();
        Date date = TimeUtils.getDateWithoutTime(isIncludeFrom() ? getFrom() : DateUtils.addDays(getFrom(), 1));
        while (isIncludeTo() ? !date.after(getTo()) : date.before(getTo())) {
            res.add(createDayInterval(date));
            date = DateUtils.addDays(date, 1);
        }

        return res;
    }

}
