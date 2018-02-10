package com.nanolaba.commons;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ProductionCalendar {

    public enum DayType {
        WORKDAY,
        HOLIDAY,
        SHORTENED
    }

    private static Map<String, DayType> exclusions = new HashMap<String, DayType>() {

        // https://lugasoft.ru/calendar/prazdniki/2004

        {

            put("2004.01.01", DayType.HOLIDAY);
            put("2004.01.02", DayType.HOLIDAY);
            put("2004.01.06", DayType.SHORTENED);
            put("2004.01.07", DayType.HOLIDAY);
            put("2004.02.23", DayType.HOLIDAY);
            put("2004.03.08", DayType.HOLIDAY);
            put("2004.04.30", DayType.SHORTENED);
            put("2004.05.03", DayType.HOLIDAY);
            put("2004.05.04", DayType.HOLIDAY);
            put("2004.05.10", DayType.HOLIDAY);
            put("2004.06.11", DayType.SHORTENED);
            put("2004.06.14", DayType.HOLIDAY);
            put("2004.11.08", DayType.HOLIDAY);
            put("2004.12.13", DayType.HOLIDAY);
            put("2004.12.31", DayType.SHORTENED);

            put("2005.01.03", DayType.HOLIDAY);
            put("2005.01.04", DayType.HOLIDAY);
            put("2005.01.05", DayType.HOLIDAY);
            put("2005.01.06", DayType.HOLIDAY);
            put("2005.01.07", DayType.HOLIDAY);
            put("2005.01.10", DayType.HOLIDAY);
            put("2005.02.22", DayType.SHORTENED);
            put("2005.02.23", DayType.HOLIDAY);
            put("2005.03.05", DayType.SHORTENED);
            put("2005.03.07", DayType.HOLIDAY);
            put("2005.03.08", DayType.HOLIDAY);
            put("2005.05.02", DayType.HOLIDAY);
            put("2005.05.09", DayType.HOLIDAY);
            put("2005.05.10", DayType.HOLIDAY);
            put("2005.05.14", DayType.WORKDAY);
            put("2005.06.13", DayType.HOLIDAY);
            put("2005.11.03", DayType.SHORTENED);
            put("2005.11.04", DayType.HOLIDAY);

            put("2006.01.02", DayType.HOLIDAY);
            put("2006.01.03", DayType.HOLIDAY);
            put("2006.01.04", DayType.HOLIDAY);
            put("2006.01.05", DayType.HOLIDAY);
            put("2006.01.06", DayType.HOLIDAY);
            put("2006.01.09", DayType.HOLIDAY);
            put("2006.02.22", DayType.SHORTENED);
            put("2006.02.23", DayType.HOLIDAY);
            put("2006.02.24", DayType.HOLIDAY);
            put("2006.02.26", DayType.WORKDAY);
            put("2006.03.07", DayType.SHORTENED);
            put("2006.03.08", DayType.HOLIDAY);
            put("2006.05.01", DayType.HOLIDAY);
            put("2006.05.06", DayType.SHORTENED);
            put("2006.05.08", DayType.HOLIDAY);
            put("2006.05.09", DayType.HOLIDAY);
            put("2006.06.12", DayType.HOLIDAY);
            put("2006.11.03", DayType.SHORTENED);
            put("2006.11.06", DayType.HOLIDAY);

            put("2007.01.01", DayType.HOLIDAY);
            put("2007.01.02", DayType.HOLIDAY);
            put("2007.01.03", DayType.HOLIDAY);
            put("2007.01.04", DayType.HOLIDAY);
            put("2007.01.05", DayType.HOLIDAY);
            put("2007.01.08", DayType.HOLIDAY);
            put("2007.02.22", DayType.SHORTENED);
            put("2007.02.23", DayType.HOLIDAY);
            put("2007.03.07", DayType.SHORTENED);
            put("2007.03.08", DayType.HOLIDAY);
            put("2007.04.28", DayType.SHORTENED);
            put("2007.04.30", DayType.HOLIDAY);
            put("2007.05.01", DayType.HOLIDAY);
            put("2007.05.08", DayType.SHORTENED);
            put("2007.05.09", DayType.HOLIDAY);
            put("2007.06.09", DayType.SHORTENED);
            put("2007.06.11", DayType.HOLIDAY);
            put("2007.06.12", DayType.HOLIDAY);
            put("2007.11.05", DayType.HOLIDAY);
            put("2007.12.29", DayType.SHORTENED);
            put("2007.12.31", DayType.HOLIDAY);

            put("2008.01.01", DayType.HOLIDAY);
            put("2008.01.02", DayType.HOLIDAY);
            put("2008.01.03", DayType.HOLIDAY);
            put("2008.01.04", DayType.HOLIDAY);
            put("2008.01.07", DayType.HOLIDAY);
            put("2008.01.08", DayType.HOLIDAY);
            put("2008.02.22", DayType.SHORTENED);
            put("2008.02.25", DayType.HOLIDAY);
            put("2008.03.07", DayType.SHORTENED);
            put("2008.03.10", DayType.HOLIDAY);
            put("2008.04.30", DayType.SHORTENED);
            put("2008.05.01", DayType.HOLIDAY);
            put("2008.05.02", DayType.HOLIDAY);
            put("2008.05.04", DayType.WORKDAY);
            put("2008.05.08", DayType.SHORTENED);
            put("2008.05.09", DayType.HOLIDAY);
            put("2008.06.07", DayType.WORKDAY);
            put("2008.06.11", DayType.SHORTENED);
            put("2008.06.12", DayType.HOLIDAY);
            put("2008.06.13", DayType.HOLIDAY);
            put("2008.11.01", DayType.SHORTENED);
            put("2008.11.03", DayType.HOLIDAY);
            put("2008.11.04", DayType.HOLIDAY);
            put("2008.12.31", DayType.SHORTENED);

            put("2009.01.01", DayType.HOLIDAY);
            put("2009.01.02", DayType.HOLIDAY);
            put("2009.01.05", DayType.HOLIDAY);
            put("2009.01.06", DayType.HOLIDAY);
            put("2009.01.07", DayType.HOLIDAY);
            put("2009.01.08", DayType.HOLIDAY);
            put("2009.01.09", DayType.HOLIDAY);
            put("2009.01.11", DayType.WORKDAY);
            put("2009.02.23", DayType.HOLIDAY);
            put("2009.03.09", DayType.HOLIDAY);
            put("2009.04.30", DayType.SHORTENED);
            put("2009.05.01", DayType.HOLIDAY);
            put("2009.05.08", DayType.SHORTENED);
            put("2009.05.11", DayType.HOLIDAY);
            put("2009.06.11", DayType.SHORTENED);
            put("2009.06.12", DayType.HOLIDAY);
            put("2009.11.03", DayType.SHORTENED);
            put("2009.11.04", DayType.HOLIDAY);
            put("2009.12.31", DayType.SHORTENED);

            put("2010.01.01", DayType.HOLIDAY);
            put("2010.01.04", DayType.HOLIDAY);
            put("2010.01.05", DayType.HOLIDAY);
            put("2010.01.06", DayType.HOLIDAY);
            put("2010.01.07", DayType.HOLIDAY);
            put("2010.01.08", DayType.HOLIDAY);
            put("2010.02.22", DayType.HOLIDAY);
            put("2010.02.23", DayType.HOLIDAY);
            put("2010.02.27", DayType.SHORTENED);
            put("2010.03.08", DayType.HOLIDAY);
            put("2010.04.30", DayType.SHORTENED);
            put("2010.05.03", DayType.HOLIDAY);
            put("2010.05.10", DayType.HOLIDAY);
            put("2010.06.11", DayType.SHORTENED);
            put("2010.06.14", DayType.HOLIDAY);
            put("2010.11.03", DayType.SHORTENED);
            put("2010.11.04", DayType.HOLIDAY);
            put("2010.11.05", DayType.HOLIDAY);
            put("2010.11.13", DayType.WORKDAY);
            put("2010.12.31", DayType.SHORTENED);

            put("2011.01.03", DayType.HOLIDAY);
            put("2011.01.04", DayType.HOLIDAY);
            put("2011.01.05", DayType.HOLIDAY);
            put("2011.01.06", DayType.HOLIDAY);
            put("2011.01.07", DayType.HOLIDAY);
            put("2011.01.10", DayType.HOLIDAY);
            put("2011.02.22", DayType.SHORTENED);
            put("2011.02.23", DayType.HOLIDAY);
            put("2011.03.05", DayType.SHORTENED);
            put("2011.03.07", DayType.HOLIDAY);
            put("2011.03.08", DayType.HOLIDAY);
            put("2011.05.02", DayType.HOLIDAY);
            put("2011.05.09", DayType.HOLIDAY);
            put("2011.06.13", DayType.HOLIDAY);
            put("2011.11.03", DayType.SHORTENED);
            put("2011.11.04", DayType.HOLIDAY);

            put("2012.01.02", DayType.HOLIDAY);
            put("2012.01.03", DayType.HOLIDAY);
            put("2012.01.04", DayType.HOLIDAY);
            put("2012.01.05", DayType.HOLIDAY);
            put("2012.01.06", DayType.HOLIDAY);
            put("2012.01.09", DayType.HOLIDAY);
            put("2012.02.22", DayType.SHORTENED);
            put("2012.02.23", DayType.HOLIDAY);
            put("2012.03.07", DayType.SHORTENED);
            put("2012.03.08", DayType.HOLIDAY);
            put("2012.03.09", DayType.HOLIDAY);
            put("2012.03.11", DayType.WORKDAY);
            put("2012.04.28", DayType.SHORTENED);
            put("2012.04.30", DayType.HOLIDAY);
            put("2012.05.01", DayType.HOLIDAY);
            put("2012.05.05", DayType.WORKDAY);
            put("2012.05.07", DayType.HOLIDAY);
            put("2012.05.08", DayType.HOLIDAY);
            put("2012.05.09", DayType.HOLIDAY);
            put("2012.05.12", DayType.SHORTENED);
            put("2012.06.09", DayType.SHORTENED);
            put("2012.06.11", DayType.HOLIDAY);
            put("2012.06.12", DayType.HOLIDAY);
            put("2012.11.05", DayType.HOLIDAY);
            put("2012.12.29", DayType.SHORTENED);
            put("2012.12.31", DayType.HOLIDAY);

            put("2013.01.01", DayType.HOLIDAY);
            put("2013.01.02", DayType.HOLIDAY);
            put("2013.01.03", DayType.HOLIDAY);
            put("2013.01.04", DayType.HOLIDAY);
            put("2013.01.07", DayType.HOLIDAY);
            put("2013.01.08", DayType.HOLIDAY);
            put("2013.02.22", DayType.SHORTENED);
            put("2013.03.07", DayType.SHORTENED);
            put("2013.03.08", DayType.HOLIDAY);
            put("2013.04.30", DayType.SHORTENED);
            put("2013.05.01", DayType.HOLIDAY);
            put("2013.05.02", DayType.HOLIDAY);
            put("2013.05.03", DayType.HOLIDAY);
            put("2013.05.08", DayType.SHORTENED);
            put("2013.05.09", DayType.HOLIDAY);
            put("2013.05.10", DayType.HOLIDAY);
            put("2013.06.11", DayType.SHORTENED);
            put("2013.06.12", DayType.HOLIDAY);
            put("2013.11.04", DayType.HOLIDAY);
            put("2013.12.31", DayType.SHORTENED);

            put("2014.01.01", DayType.HOLIDAY);
            put("2014.01.02", DayType.HOLIDAY);
            put("2014.01.03", DayType.HOLIDAY);
            put("2014.01.06", DayType.HOLIDAY);
            put("2014.01.07", DayType.HOLIDAY);
            put("2014.01.08", DayType.HOLIDAY);
            put("2014.02.24", DayType.SHORTENED);
            put("2014.03.07", DayType.SHORTENED);
            put("2014.03.10", DayType.HOLIDAY);
            put("2014.04.30", DayType.SHORTENED);
            put("2014.05.01", DayType.HOLIDAY);
            put("2014.05.02", DayType.HOLIDAY);
            put("2014.05.08", DayType.SHORTENED);
            put("2014.05.09", DayType.HOLIDAY);
            put("2014.06.11", DayType.SHORTENED);
            put("2014.06.12", DayType.HOLIDAY);
            put("2014.06.13", DayType.HOLIDAY);
            put("2014.11.03", DayType.HOLIDAY);
            put("2014.11.04", DayType.HOLIDAY);
            put("2014.12.31", DayType.SHORTENED);

            put("2015.01.01", DayType.HOLIDAY);
            put("2015.01.02", DayType.HOLIDAY);
            put("2015.01.05", DayType.HOLIDAY);
            put("2015.01.06", DayType.HOLIDAY);
            put("2015.01.07", DayType.HOLIDAY);
            put("2015.01.08", DayType.HOLIDAY);
            put("2015.01.09", DayType.HOLIDAY);
            put("2015.02.23", DayType.HOLIDAY);
            put("2015.03.09", DayType.HOLIDAY);
            put("2015.04.30", DayType.SHORTENED);
            put("2015.05.01", DayType.HOLIDAY);
            put("2015.05.04", DayType.HOLIDAY);
            put("2015.05.08", DayType.SHORTENED);
            put("2015.05.11", DayType.HOLIDAY);
            put("2015.06.11", DayType.SHORTENED);
            put("2015.06.12", DayType.HOLIDAY);
            put("2015.11.03", DayType.SHORTENED);
            put("2015.11.04", DayType.HOLIDAY);
            put("2015.12.31", DayType.SHORTENED);

            put("2016.01.01", DayType.HOLIDAY);
            put("2016.01.04", DayType.HOLIDAY);
            put("2016.01.05", DayType.HOLIDAY);
            put("2016.01.06", DayType.HOLIDAY);
            put("2016.01.07", DayType.HOLIDAY);
            put("2016.01.08", DayType.HOLIDAY);
            put("2016.02.20", DayType.SHORTENED);
            put("2016.02.22", DayType.HOLIDAY);
            put("2016.02.23", DayType.HOLIDAY);
            put("2016.03.07", DayType.HOLIDAY);
            put("2016.03.08", DayType.HOLIDAY);
            put("2016.05.02", DayType.HOLIDAY);
            put("2016.05.03", DayType.HOLIDAY);
            put("2016.05.09", DayType.HOLIDAY);
            put("2016.06.13", DayType.HOLIDAY);
            put("2016.11.03", DayType.SHORTENED);
            put("2016.11.04", DayType.HOLIDAY);

            put("2017.01.02", DayType.HOLIDAY);
            put("2017.01.03", DayType.HOLIDAY);
            put("2017.01.04", DayType.HOLIDAY);
            put("2017.01.05", DayType.HOLIDAY);
            put("2017.01.06", DayType.HOLIDAY);
            put("2017.02.22", DayType.SHORTENED);
            put("2017.02.23", DayType.HOLIDAY);
            put("2017.02.24", DayType.HOLIDAY);
            put("2017.03.07", DayType.SHORTENED);
            put("2017.03.08", DayType.HOLIDAY);
            put("2017.05.01", DayType.HOLIDAY);
            put("2017.05.08", DayType.HOLIDAY);
            put("2017.05.09", DayType.HOLIDAY);
            put("2017.06.12", DayType.HOLIDAY);
            put("2017.11.03", DayType.SHORTENED);
            put("2017.11.06", DayType.HOLIDAY);

            put("2018.01.01", DayType.HOLIDAY);
            put("2018.01.02", DayType.HOLIDAY);
            put("2018.01.03", DayType.HOLIDAY);
            put("2018.01.04", DayType.HOLIDAY);
            put("2018.01.05", DayType.HOLIDAY);
            put("2018.01.08", DayType.HOLIDAY);
            put("2018.02.22", DayType.SHORTENED);
            put("2018.02.23", DayType.HOLIDAY);
            put("2018.03.07", DayType.SHORTENED);
            put("2018.03.08", DayType.HOLIDAY);
            put("2018.03.09", DayType.HOLIDAY);
            put("2018.04.28", DayType.SHORTENED);
            put("2018.04.30", DayType.HOLIDAY);
            put("2018.05.01", DayType.HOLIDAY);
            put("2018.05.02", DayType.HOLIDAY);
            put("2018.05.08", DayType.SHORTENED);
            put("2018.05.09", DayType.HOLIDAY);
            put("2018.06.09", DayType.SHORTENED);
            put("2018.06.11", DayType.HOLIDAY);
            put("2018.06.12", DayType.HOLIDAY);
            put("2018.11.05", DayType.HOLIDAY);
            put("2018.12.29", DayType.SHORTENED);
            put("2018.12.31", DayType.HOLIDAY);

            put("2019.01.01", DayType.HOLIDAY);
            put("2019.01.02", DayType.HOLIDAY);
            put("2019.01.03", DayType.HOLIDAY);
            put("2019.01.04", DayType.HOLIDAY);
            put("2019.01.07", DayType.HOLIDAY);
            put("2019.01.08", DayType.HOLIDAY);
            put("2019.02.22", DayType.SHORTENED);
            put("2019.02.25", DayType.HOLIDAY);
            put("2019.03.07", DayType.SHORTENED);
            put("2019.03.08", DayType.HOLIDAY);
            put("2019.04.30", DayType.SHORTENED);
            put("2019.05.01", DayType.HOLIDAY);
            put("2019.05.08", DayType.SHORTENED);
            put("2019.05.09", DayType.HOLIDAY);
            put("2019.06.11", DayType.SHORTENED);
            put("2019.06.12", DayType.HOLIDAY);
            put("2019.11.04", DayType.HOLIDAY);
            put("2019.12.31", DayType.SHORTENED);

            put("2020.01.01", DayType.HOLIDAY);
            put("2020.01.02", DayType.HOLIDAY);
            put("2020.01.03", DayType.HOLIDAY);
            put("2020.01.06", DayType.HOLIDAY);
            put("2020.01.07", DayType.HOLIDAY);
            put("2020.01.08", DayType.HOLIDAY);
            put("2020.02.24", DayType.HOLIDAY);
            put("2020.03.09", DayType.HOLIDAY);
            put("2020.04.30", DayType.SHORTENED);
            put("2020.05.01", DayType.HOLIDAY);
            put("2020.05.08", DayType.SHORTENED);
            put("2020.05.11", DayType.HOLIDAY);
            put("2020.06.11", DayType.SHORTENED);
            put("2020.06.12", DayType.HOLIDAY);
            put("2020.11.03", DayType.SHORTENED);
            put("2020.11.04", DayType.HOLIDAY);
            put("2020.12.31", DayType.SHORTENED);

        }
    };

    public static DayType getDayType(Date date) {

        DayType dayType = exclusions.get(TimeUtils.toString(date, "yyyy.MM.dd"));

        if (dayType != null) {
            return dayType;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ?
                DayType.HOLIDAY :
                DayType.WORKDAY;
    }


    public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);


        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        int workDays = 0;
        do {
            if (getDayType(startCal.getTime()) != DayType.HOLIDAY) {
                ++workDays;
            }
            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());

        return workDays;
    }

//
//    public static void main(String... a) throws IOException, URISyntaxException {
//
//
////        int year = Integer.valueOf(StringUtils.substringBetween(t, " title=\"Праздники в Январе ", " года"));
//
//        for (int year = 2004; year <= 2020; ++year) {
//
//            System.out.println("");
//
//            String t = IOUtils.toString(new URI("https://lugasoft.ru/calendar/prazdniki/" + year), "UTF-8");
//
//            t = StringUtils.substringBetween(t, "<div id=\"calen-prazd-god\">", "</table>");
//            t = StringUtils.substringAfter(t, "<table>");
//
//            int month = 0;
//            for (String tt : t.split("<tr>")) {
//
//
//                if (tt.contains("class=\"m\"")) {
//                    month++;
//                } else {
//
//                    DayType type = null;
//                    int day = 0;
//                    if (tt.contains("<td class=\"day\">")) {
//                        type = DayType.WORKDAY;
//                        day = Integer.valueOf(StringUtils.substringBetween(tt, "<td class=\"day\">", "<").trim());
//                    } else if (tt.contains("<td class=\"day v\">")) {
//                        type = DayType.HOLIDAY;
//                        day = Integer.valueOf(StringUtils.substringBetween(tt, "<td class=\"day v\">", "<").trim());
//                    } else if (tt.contains("<td class=\"day s\">")) {
//                        type = DayType.SHORTENED;
//                        day = Integer.valueOf(StringUtils.substringBetween(tt, "<td class=\"day s\">", "<").trim());
//                    }
//
//                    if (type != null) {
//                        String date = year + "." + ((month < 10 ? "0" : "") + month) + "." + ((day < 10 ? "0" : "") + day);
//                        if (getDayType(TimeUtils.toDate(date, "yyyy.MM.dd")) != type) {
//                            System.out.println("put(\"" + date + "\", DayType." + type + ");");
//                        }
//                    }
//                }
//
//            }
//        }
//
//    }
}
