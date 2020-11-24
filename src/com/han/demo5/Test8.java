package com.han.demo5;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Test8 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, -1);
        System.out.println(instance.getTime());

        //java 8
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1);
        System.out.println(yesterday);
    }
}
