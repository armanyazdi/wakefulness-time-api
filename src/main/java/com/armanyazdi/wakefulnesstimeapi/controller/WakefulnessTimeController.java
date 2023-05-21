package com.armanyazdi.wakefulnesstimeapi.controller;

import com.armanyazdi.wakefulnesstimeapi.WakefulnessTime;
import com.armanyazdi.wakefulnesstimeapi.service.WakefulnessTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class WakefulnessTimeController {

    @Autowired
    WakefulnessTimeService service;
    private final AtomicLong counter = new AtomicLong();
    private final HttpStatus status = HttpStatus.OK;

    @GetMapping("/wakefulness")
    @ResponseBody
    public WakefulnessTime getWakefulnessTime(@RequestParam String coffee,
                                             @RequestParam(defaultValue = "0") String robusta,
                                             @RequestParam(defaultValue = "now") String time)
    {
        service.addCoffeeDetails(coffee, robusta, time);
        return new WakefulnessTime(
                counter.incrementAndGet(),
                status,
                service.getTime(time),
                service.getCoffee(coffee),
                service.getArabica(),
                service.getRobusta(),
                service.getCaffeine(),
                service.getWakefulness(),
                service.getMinimum(time),
                service.getMaximum(time),
                service.getAverage(time));
    }
}