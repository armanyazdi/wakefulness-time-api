package com.armanyazdi.wakefulnesstimeapi.response;

public class Drink {
    public static short caffeine;
    public static int min, max;

    public static void addData(String drink, String time) {
        switch (drink.toLowerCase()) {
            case "americano" -> caffeine = 249;
            case "cappuccino" -> caffeine = 80;
            case "latte" -> caffeine = 154;
            case "mocha" -> caffeine = 152;
            case "espresso" -> caffeine = 63;
            case "frappuccino" -> caffeine = 79;
            case "macchiato" -> caffeine = 85;
            case "affogato" -> caffeine = 85;
            case "chemex" -> caffeine = 172;
            case "brewed" -> caffeine = 96;
            case "nescafe" -> caffeine = 50;
            case "redbull" -> caffeine = 80;
            case "hype" -> caffeine = 80;
            case "cocacola" -> caffeine = 34;
            case "tea" -> caffeine = 47;
            case "greentea" -> caffeine = 20;
        }

        min = Math.round((float) caffeine / 24);
        max = min + 3;

        if (Time.fix(time).getHourOfDay() >= 13 && Time.fix(time).getHourOfDay() < 17) {
            min += 1;
            max += 1;
        }
    }
}