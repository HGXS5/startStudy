package com.han.demo5;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test7 {
    public static void main(String[] args) {
        SimpleDateFormat fa= new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(fa.format(date));


        //java 8
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date1 = LocalDate.now();
        System.out.println(date1.format(dateTimeFormatter));
    }
}
