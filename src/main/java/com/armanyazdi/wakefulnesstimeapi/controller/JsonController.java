package com.armanyazdi.wakefulnesstimeapi.controller;

import com.armanyazdi.wakefulnesstimeapi.response.WakefulnessTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class JsonController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/wakefulness")
    public WakefulnessTime jsonResponse(@RequestParam String drink,
                                        @RequestParam(defaultValue = "now") String time)
    {
        return new WakefulnessTime(counter.incrementAndGet(), drink, time);
    }
}