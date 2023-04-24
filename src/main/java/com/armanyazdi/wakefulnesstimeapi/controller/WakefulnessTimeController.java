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
    private final AtomicLong counter = new AtomicLong();
    private final HttpStatus status = HttpStatus.OK;

    @GetMapping("/wakefulness")
    public WakefulnessTime wakefulness(@RequestParam String coffee,
                                       @RequestParam(defaultValue = "0") String robusta,
                                       @RequestParam(defaultValue = "now") String time)
    {
        return new WakefulnessTime(counter.incrementAndGet(), status, coffee, robusta, time);
    }
}