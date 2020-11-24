package com.han.demo5;

import java.util.Calendar;

public class Test6 {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        int actualMaximum = instance.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(actualMaximum);
    }
}
