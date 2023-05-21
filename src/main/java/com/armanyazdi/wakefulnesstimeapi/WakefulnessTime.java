package com.armanyazdi.wakefulnesstimeapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class WakefulnessTime {
    private Long id;
    private HttpStatus status;
    private String time, coffee, arabica, robusta, caffeine, wakefulness, minimum, maximum, average;
}