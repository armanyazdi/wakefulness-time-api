package com.armanyazdi.wakefulnesstimeapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WakefulnessTimeApiApplicationTests {

    @Test
    public void testCaffeineContentOfDrinks() {
        Drink.addData("americano", "now");
        assertEquals(249, Drink.caffeine);
    }

    @Test
    public void testMinAndMaxWakefulnessTimeOfDrinks13To17() {
        Drink.addData("americano", "13:00");
        assertEquals(11, Drink.min);
        assertEquals(14, Drink.max);
    }

    @Test
    public void testMinAndMaxWakefulnessTimeOfDrinksAtOtherTimes() {
        Drink.addData("americano", "12:59");
        assertEquals(10, Drink.min);
        assertEquals(13, Drink.max);
    }
}