package com.armanyazdi.wakefulnesstimeapi.controller;

import com.armanyazdi.wakefulnesstimeapi.WakefulnessTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class WakefulnessTimeController {
    private static final AtomicLong counter = new AtomicLong();
    private static final HttpStatus status = HttpStatus.OK;

    @GetMapping("/wakefulness")
    public WakefulnessTime wakefulness(@RequestParam String drink,
                                        @RequestParam(defaultValue = "now") String time)
    {
        return new WakefulnessTime(counter.incrementAndGet(), status, drink, time);
    }
}