package com.han.demo10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String s = "北京市(朝阳区)西城区(海定区）";
        final Pattern compile = Pattern.compile(".*?(?=\\()");
        final Matcher matcher = compile.matcher(s);
        if (matcher.find()){
            System.out.println(matcher.group()  );
        }
    }
}
