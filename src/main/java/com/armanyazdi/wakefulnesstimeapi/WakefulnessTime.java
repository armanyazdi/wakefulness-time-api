package com.armanyazdi.wakefulnesstimeapi;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WakefulnessTime {
    private final Long id;
    private final HttpStatus status;
    private final String time, coffee, arabica, robusta, caffeine, wakefulness, min, max, avg;

    public WakefulnessTime(Long id, HttpStatus status, String coffee, String robusta, String time) {
        Coffee.calculateCaffeine(coffee, robusta, time);

        this.id = id;
        this.status = status;
        this.time = "%s:%s".formatted(String.format("%02d", Time.fix(time).getHourOfDay()), String.format("%02d", Time.fix(time).getMinuteOfHour()));
        this.coffee = coffee.substring(0, 1).toUpperCase() + coffee.substring(1);
        this.arabica = Coffee.arabica + "%";
        this.robusta = Coffee.robusta + "%";
        this.caffeine = "%s mg".formatted(Coffee.caffeine);
        this.wakefulness = "%s-%s hours".formatted(Coffee.min, Coffee.max);
        this.min = Time.format(Time.fix(time), Coffee.min, 15);
        this.max = Time.format(Time.fix(time), Coffee.max, -15);
        this.avg = Time.format(Time.fix(time), (Coffee.min + Coffee.max) / 2, 10);
    }
}