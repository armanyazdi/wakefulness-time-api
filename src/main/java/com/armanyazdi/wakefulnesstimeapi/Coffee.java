package com.armanyazdi.wakefulnesstimeapi;

public class Coffee {
    public static short content;
    public static int arabica, robusta, caffeine, min, max;

    public static void calculateCaffeineContent(String coffee, String robusta, String time) {
        switch (coffee.toLowerCase()) {
            case "americano" -> content = 249;
            case "espresso" -> content = 63;
            case "doppio" -> content = 126;
            case "latte" -> content = 154;
            case "mocha" -> content = 152;
            case "cappuccino" -> content = 173;
            case "frappuccino" -> content = 79;
            case "macchiato" -> content = 85;
            case "affogato" -> content = 85;
            case "chemex" -> content = 172;
            case "brewed" -> content = 96;
            case "ristretto" -> content = 66;
            case "turkish" -> content = 50;
            case "lungo" -> content = 80;
            case "yazdi" -> content = 50;
        }

        Coffee.robusta = Integer.parseInt(robusta.replaceAll("[^0-9]",""));
        arabica = 100 - Coffee.robusta;
        caffeine = content + (Coffee.robusta * (content / 100));
        min = Math.round((float) caffeine / 25);
        max = min + 3;

        if (Time.fix(time).getHourOfDay() >= 13 && Time.fix(time).getHourOfDay() < 17) {
            min += 1;
            max += 1;
        }
    }
}