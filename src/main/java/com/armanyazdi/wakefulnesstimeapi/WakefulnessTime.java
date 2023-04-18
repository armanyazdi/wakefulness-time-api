package com.armanyazdi.wakefulnesstimeapi;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WakefulnessTime {
    private final Long id;
    private final HttpStatus status;
    private final String time;
    private final String drink;
    private final String caffeine;
    private final String wakefulness;
    private final String min;
    private final String max;
    private final String avg;

    public WakefulnessTime(Long id, HttpStatus status, String drink, String time) {
        Drink.addData(drink, time);

        this.id = id;
        this.status = status;
        this.time = "%s:%s".formatted(String.format("%02d", Time.fix(time).getHourOfDay()), String.format("%02d", Time.fix(time).getMinuteOfHour()));
        this.drink = drink.substring(0, 1).toUpperCase() + drink.substring(1);
        this.caffeine = "%s mg".formatted(Drink.caffeine);
        this.wakefulness = "%s-%s hrs".formatted(Drink.min, Drink.max);
        this.min = Time.format(Time.fix(time), Drink.min, 15);
        this.max = Time.format(Time.fix(time), Drink.max, -15);
        this.avg = Time.format(Time.fix(time), (Drink.min + Drink.max) / 2, 10);
    }
}