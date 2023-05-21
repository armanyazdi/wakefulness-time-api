package com.armanyazdi.wakefulnesstimeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoffeeUtils {

    @Autowired
    TimeUtils timeUtils;
    public short defaultContent;
    public int arabicaPercent, robustaPercent, caffeineContent, minimumHours, maximumHours;

    public void calculateRobustaPercent(String robusta) {
        robustaPercent = Integer.parseInt(robusta.replaceAll("[^0-9]",""));
    }

    public void calculateArabicaPercent() {
        arabicaPercent = 100 - robustaPercent;
    }

    public void calculateCaffeineContent(String coffee) {
        switch (coffee.toLowerCase()) {
            case "americano" -> defaultContent = 249;
            case "espresso" -> defaultContent = 63;
            case "doppio" -> defaultContent = 126;
            case "latte" -> defaultContent = 154;
            case "mocha" -> defaultContent = 152;
            case "cappuccino" -> defaultContent = 173;
            case "frappuccino" -> defaultContent = 79;
            case "macchiato" -> defaultContent = 85;
            case "affogato" -> defaultContent = 85;
            case "chemex" -> defaultContent = 172;
            case "brewed" -> defaultContent = 96;
            case "ristretto" -> defaultContent = 66;
            case "turkish" -> defaultContent = 50;
            case "lungo" -> defaultContent = 80;
            case "yazdi" -> defaultContent = 50;
        }

        caffeineContent = defaultContent + (robustaPercent * (defaultContent / 100));
    }

    public void calculateMinimumHours(String time) {
        minimumHours = Math.round((float) caffeineContent / 25);
        if (timeUtils.fixTime(time).getHourOfDay() >= 13 && timeUtils.fixTime(time).getHourOfDay() < 17) minimumHours += 1;
    }

    public void calculateMaximumHours(String time) {
        maximumHours = minimumHours + 3;
        if (timeUtils.fixTime(time).getHourOfDay() >= 13 && timeUtils.fixTime(time).getHourOfDay() < 17) maximumHours += 1;
    }
}