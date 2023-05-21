package com.armanyazdi.wakefulnesstimeapi.repository;

import com.armanyazdi.wakefulnesstimeapi.CoffeeUtils;
import com.armanyazdi.wakefulnesstimeapi.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class WakefulnessTimeRepository {

    @Autowired
    TimeUtils timeUtils;
    @Autowired
    CoffeeUtils coffeeUtils;

    public void addCoffeeDetails(String coffee, String robusta, String time) {
        coffeeUtils.calculateRobustaPercent(robusta);
        coffeeUtils.calculateArabicaPercent();
        coffeeUtils.calculateCaffeineContent(coffee);
        coffeeUtils.calculateMinimumHours(time);
        coffeeUtils.calculateMaximumHours(time);
    }

    public String getTime(String time) {
        return "%s:%s".formatted(String.format("%02d", timeUtils.fixTime(time).getHourOfDay()), String.format("%02d", timeUtils.fixTime(time).getMinuteOfHour()));
    }

    public String getCoffee(String coffee) {
        return coffee.substring(0, 1).toUpperCase() + coffee.substring(1);
    }

    public String getArabica() {
        return coffeeUtils.arabicaPercent + "%";
    }

    public String getRobusta() {
        return coffeeUtils.robustaPercent + "%";
    }

    public String getCaffeine() {
        return "%s mg".formatted(coffeeUtils.caffeineContent);
    }

    public String getWakefulness() {
        return "%s-%s hours".formatted(coffeeUtils.minimumHours, coffeeUtils.maximumHours);
    }

    public String getMinimum(String time) {
        return timeUtils.formatTime(timeUtils.fixTime(time), coffeeUtils.minimumHours, 15);
    }

    public String getMaximum(String time) {
        return timeUtils.formatTime(timeUtils.fixTime(time), coffeeUtils.maximumHours, -15);
    }

    public String getAverage(String time) {
        return timeUtils.formatTime(timeUtils.fixTime(time), (coffeeUtils.minimumHours + coffeeUtils.maximumHours) / 2, 10);
    }
}