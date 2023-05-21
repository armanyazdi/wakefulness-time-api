package com.armanyazdi.wakefulnesstimeapi;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Component
public class TimeUtils {
    public DateTime fixTime(String time) {
        if (time.equalsIgnoreCase("now")) return new DateTime();
        else return DateTime.parse("T".concat(time));
    }

    public String formatTime(DateTime time, int hours, int minutes) {
        DateTime dt = time.plusHours(hours).plusMinutes(minutes);

        return "%s:%s".formatted(
                String.format("%02d", dt.getHourOfDay()),
                String.format("%02d", dt.getMinuteOfHour()));
    }
}