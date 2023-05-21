package com.armanyazdi.wakefulnesstimeapi.service;

import com.armanyazdi.wakefulnesstimeapi.WakefulnessTime;
import com.armanyazdi.wakefulnesstimeapi.repository.WakefulnessTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WakefulnessTimeService {

    @Autowired
    WakefulnessTimeRepository repository;

    public void addCoffeeDetails(String coffee, String robusta, String time) {
        repository.addCoffeeDetails(coffee, robusta, time);
    }

    public String getTime(String time) {
        return repository.getTime(time);
    }

    public String getCoffee(String coffee) {
        return repository.getCoffee(coffee);
    }

    public String getArabica() {
        return repository.getArabica();
    }

    public String getRobusta() {
        return repository.getRobusta();
    }

    public String getCaffeine() {
        return repository.getCaffeine();
    }

    public String getWakefulness() {
        return repository.getWakefulness();
    }

    public String getMinimum(String time) {
        return repository.getMinimum(time);
    }

    public String getMaximum(String time) {
        return repository.getMaximum(time);
    }

    public String getAverage(String time) {
        return repository.getAverage(time);
    }
}
