package com.han.demo5;

import java.time.Clock;
import java.util.Calendar;

public class Test5 {
    public static void main(String[] args) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        System.out.println(timeInMillis);
        long l = System.currentTimeMillis();
        System.out.println(l);
        long millis = Clock.systemDefaultZone().millis();
        System.out.println(millis);
    }
}
