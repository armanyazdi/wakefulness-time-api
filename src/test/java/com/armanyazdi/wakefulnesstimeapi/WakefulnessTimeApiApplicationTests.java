package com.armanyazdi.wakefulnesstimeapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WakefulnessTimeApiApplicationTests {

    @Test
    public void testCaffeineContentOfCoffee() {
        Coffee.calculateCaffeineContent("americano", "0", "now");
        assertEquals(249, Coffee.caffeine);

        Coffee.calculateCaffeineContent("americano", "20", "now");
        assertEquals(289, Coffee.caffeine);

        Coffee.calculateCaffeineContent("americano", "30", "now");
        assertEquals(309, Coffee.caffeine);
    }

    @Test
    public void testMinAndMaxWakefulnessTimeOfCoffee13To17() {
        Coffee.calculateCaffeineContent("americano", "0", "13:00");
        assertEquals(11, Coffee.min);
        assertEquals(14, Coffee.max);

        Coffee.calculateCaffeineContent("americano", "20", "14:30");
        assertEquals(13, Coffee.min);
        assertEquals(16, Coffee.max);
    }

    @Test
    public void testMinAndMaxWakefulnessTimeOfCoffeeAtOtherTimes() {
        Coffee.calculateCaffeineContent("americano", "0", "12:59");
        assertEquals(10, Coffee.min);
        assertEquals(13, Coffee.max);

        Coffee.calculateCaffeineContent("americano", "20", "7:30");
        assertEquals(12, Coffee.min);
        assertEquals(15, Coffee.max);
    }
}