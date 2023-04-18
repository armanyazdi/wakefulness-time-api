package com.armanyazdi.wakefulnesstimeapi;

import org.joda.time.DateTime;

public class Time {
    public static DateTime fix(String time) {
        if (time.equalsIgnoreCase("now")) return new DateTime();
        else return DateTime.parse("T".concat(time));
    }

    public static String format(DateTime time, int hours, int minutes) {
        DateTime dt = time.plusHours(hours).plusMinutes(minutes);

        return "%s:%s".formatted(
                String.format("%02d", dt.getHourOfDay()),
                String.format("%02d", dt.getMinuteOfHour()));
    }
}